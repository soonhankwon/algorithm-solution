import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] unionFind;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		unionFind = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			unionFind[i] = i;
		}

		PriorityQueue<Edge> q = new PriorityQueue<>();

		for (int i = 1; i <= E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			q.offer(new Edge(A, B, C));
		}

		int useEdge = 0;
		int result = 0;

		while (useEdge < V - 1) {
			Edge now = q.poll();
			if (find(now.node) != find(now.endNode)) {
				union(now.node, now.endNode);
				result = result + now.value;
				useEdge++;
			}
		}
		System.out.println(result);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			unionFind[b] = a;
		}
	}

	private static int find(int a) {
		if (a == unionFind[a])
			return a;
		else
			return unionFind[a] = find(unionFind[a]);
	}
}

class Edge implements Comparable<Edge> {
	int node, endNode, value;
	
	public Edge(int startNode, int endNode, int value) {
		this.node = startNode;
		this.endNode = endNode;
		this.value = value;
	}
	@Override
	public int compareTo(Edge e) {
		return this.value > e.value ? 1 : -1;
	}
}