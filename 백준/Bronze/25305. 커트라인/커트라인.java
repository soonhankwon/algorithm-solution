import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Student[] arr = new Student[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Student(Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(arr);
		System.out.println(arr[k-1].score);
	}

}

class Student implements Comparable<Student> {
	int score;

	public Student(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Student s) {
		return s.score - getScore();
	}

}
