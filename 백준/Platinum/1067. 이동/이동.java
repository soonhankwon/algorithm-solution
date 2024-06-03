import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 고속푸리에 변환
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Complex[] v = new Complex[n * 2];
        Complex[] u = new Complex[n];
        int[] data1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++) {
            v[i] = v[i + n] = new Complex(data1[i], 0);
        }

        int[] data2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++) {
            u[n - 1 - i] = new Complex(data2[i], 0);
        }

        Complex[] w = FFT.multiply(v, u);

        long answer = 0;
        for (Complex value : w) {
            answer = Math.max(answer, Math.round(value.real));
        }
        System.out.println(answer);
        br.close();
    }

    // 복소수 계산을 위한 Complex 클래스
    private static class Complex {
        double real, imag;

        public Complex(double real, double imag) {
            this.real = real;
            this.imag = imag;
        }

        public Complex add(Complex other) {
            return new Complex(this.real + other.real, this.imag + other.imag);
        }

        public Complex subtract(Complex other) {
            return new Complex(this.real - other.real, this.imag - other.imag);
        }

        public Complex multiply(Complex other) {
            return new Complex(this.real * other.real - this.imag * other.imag,
                    this.real * other.imag + this.imag * other.real
            );
        }

        public Complex divide(double val) {
            return new Complex(this.real / val, this.imag / val);
        }

        public static Complex fromPolar(double r, double theta) {
            return new Complex(r * Math.cos(theta), r * Math.sin(theta));
        }

        @Override
        public String toString() {
            return String.format("(%f, %f)", real, imag);
        }
    }

    static class FFT {
        static void fft(Complex[] v, boolean inv) {
            int s = v.length;
            for (int i = 1, j = 0; i < s; i++) {
                int bit = s / 2;

                while (j >= bit) {
                    j -= bit;
                    bit /= 2;
                }
                j += bit;

                if (i < j) {
                    Complex temp = v[i];
                    v[i] = v[j];
                    v[j] = temp;
                }
            }

            for (int k = 1; k < s; k *= 2) {
                double angle = (inv ? Math.PI / k : -Math.PI / k);
                Complex dir = Complex.fromPolar(1, angle);
                for (int i = 0; i < s; i += k * 2) {
                    Complex unit = new Complex(1, 0);

                    for (int j = 0; j < k; j++) {
                        Complex a = v[i + j];
                        Complex b = v[i + j + k].multiply(unit);

                        v[i + j] = a.add(b);
                        v[i + j + k] = a.subtract(b);

                        unit = unit.multiply(dir);
                    }
                }
            }
            if (inv) {
                for (int i = 0; i < s; i++) {
                    v[i] = v[i].divide(s);
                }
            }
        }

        static Complex[] multiply(Complex[] v, Complex[] u) {
            int s = 1;
            while (s < Math.max(v.length, u.length)) {
                s *= 2;
            }
            s *= 2;

            v = Arrays.copyOf(v, s);
            u = Arrays.copyOf(u, s);

            for (int i = 0; i < s; i++) {
                if (v[i] == null) {
                    v[i] = new Complex(0, 0);
                }
                if (u[i] == null) {
                    u[i] = new Complex(0, 0);
                }
            }

            fft(v, false);
            fft(u, false);

            Complex[] w = new Complex[s];
            for (int i = 0; i < s; i++) {
                w[i] = v[i].multiply(u[i]);
            }

            fft(w, true);

            return w;
        }
    }
}
