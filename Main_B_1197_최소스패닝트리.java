package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int point1;
	int point2;
	int weight;

	Edge(int p1, int p2, int weight) {
		this.point1 = p1;
		this.point2 = p2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		return (this.weight > e.weight ? 1 : (this.weight == e.weight ? 0 : -1));
	}

}

public class Main_B_1197_최소스패닝트리 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V; 
		int E; 
		int result = 0; 
		int edgeNum = 0;

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		Queue<Edge> edgePriorityQueue = new PriorityQueue<Edge>();

		for (int i = 0; i < E; i++) {

			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edgePriorityQueue.add(new Edge(A, B, C));
		}

		Union unionFind = new Union(V);

		while (edgeNum < V && !edgePriorityQueue.isEmpty()) {
			Edge edge = edgePriorityQueue.poll();
			if (unionFind.findUnion(edge.point1) == unionFind.findUnion(edge.point2)) {
				continue;
			} else {
				unionFind.union(edge.point1, edge.point2);
				result += edge.weight;
				edgeNum++;
			}
		}
		System.out.println(result);

	}

}

class Union {
	int[] root;

	public Union(int V) {
		root = new int[V + 1];
		initialize();
	}

	public int findUnion(int a) {
		if (root[a] < 0) {
			return a;
		}
		return root[a] = findUnion(root[a]);
	}

	public void union(int a, int b) {
		int root1 = findUnion(a);
		int root2 = findUnion(b);

		if (root1 == root2) {
			return;
		}

		if (root[root1] > root[root2]) {
			root1 ^= root2;
			root2 ^= root1;
			root1 ^= root2;
		}

		root[root1] += root[root2];
		root[root2] = root1;

	}

	private void initialize() {
		for (int i = 0; i < root.length; i++) {
			root[i] = -1;
		}
	}

	public int size(int a) {
		return -root[findUnion(a)];
	}
}

