package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B_1167_트리의지름 {
	static int V, map[][], start=0;
	static long result=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		List<Line>[] list = new ArrayList[V+1];
		
		for(int i=1;i<=V;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			list[from] = new ArrayList<Line>();
			
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) {
					break;
				}
				list[from].add( new Line(to, Integer.parseInt(st.nextToken()) ) );
			}
		}

		
		dfs(list, new boolean[V+1], 1, 0);
		dfs(list, new boolean[V+1], start, 0);
		System.out.println(result);
	}
	private static void dfs(List<Line>[] list, boolean[] check, int from, long length) {
		check[from] = true;
		
		if(length>result) {
			result = length;
			start = from;
		}
		
		for(Line next : list[from]) {
			int to = next.getNode();
			long len = next.getLength();
			
			if(!check[to]) {
				dfs(list, check, to, length+len);
				check[to] = false;
			}
		}
	}
}
class Line{
	int node;
	long length;
	public Line(int node, long length) {
		this.node = node;
		this.length = length;
	}
	public int getNode() {
		return node;
	}

	public long getLength() {
		return length;
	}
	
}