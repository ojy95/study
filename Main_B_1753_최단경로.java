package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_1753_최단경로 {
	static int V,E,min[];
	static boolean check[];
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V];
		for(int i=0;i<V;i++) {
			list[i] = new ArrayList<Node>(); 
		}
		min = new int[V];
		check = new boolean[V];
		Arrays.fill(min, Integer.MAX_VALUE);
		
		int start = Integer.parseInt(br.readLine())-1;
		Node tmp;
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			tmp = new Node(to,Integer.parseInt(st.nextToken()));
			list[from].add(tmp);
		}
		search(start);
		for(int i=0;i<V;i++) {
			if(min[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");				
			}else {
				sb.append(min[i]+"\n");				
			}
		}
		System.out.println(sb);
	}
	private static void search(int edge) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(edge, 0));
		min[edge]=0;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			int to = tmp.to;
			if(check[to]) continue;
			check[to] = true;
			
			for(Node node: list[to]) {
				if(min[node.to] > node.length + min[to]) {
					min[node.to] = node.length + min[to];
					queue.add(new Node(node.to, min[node.to]));
				}
			}
		}
	}

}
class Node implements Comparable<Node>{
	int to;
	int length;
	public Node(int to, int length) {
		this.to = to;
		this.length = length;
	}
	@Override
	public int compareTo(Node o) {
		return this.length-o.length;
	}
	
}