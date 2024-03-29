import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        //nCr -> n!/(n-r)!r! -> 3! / (3-1)!1! -> 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]); //4
        m = Integer.parseInt(inputs[1]); //2
        arr = new int[m];
        recursion(0, 1);
    }

    private static void recursion(int depth, int index) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i <= n; i++) {
            arr[depth] = i;
            recursion(depth + 1, i + 1);
        }
    }
}