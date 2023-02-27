import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nk = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= nk[0]; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		while(queue.size() > 1) {
			for(int i = 0; i < nk[1] - 1; i++) {
				int value = queue.poll();
				queue.offer(value);
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.peek()).append('>');
		System.out.println(sb);
	}
}