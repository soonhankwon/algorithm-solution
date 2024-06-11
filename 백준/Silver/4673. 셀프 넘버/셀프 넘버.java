public class Main {
	public static void main(String args[]) {
		int index = 10001;
		boolean[] number = new boolean[index];
		for (int i = 1; i < index; i++) {
			int n = checkNumber(i);
			if (n < index)
				number[n] = true;
			if (!number[i]) {
				System.out.println(i);

			}
		}
	}

	public static int checkNumber(int n) {
		int sum = n;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}