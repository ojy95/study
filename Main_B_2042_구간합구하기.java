package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_2042_구간합구하기 {
	static long[] array,tree;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //개수
		int M = Integer.parseInt(st.nextToken()); //변경 횟수
		int K = Integer.parseInt(st.nextToken());// 구간합 횟수
		tree = new long[N*4+1];
		array = new long[N+1];
		for(int i=1;i<N+1;i++) {
			st= new StringTokenizer(bf.readLine());
			array[i]= Long.parseLong(st.nextToken());
		}
		
		setting(1,N, 1);
		
		for(int i=0;i<M+K;i++) {
			st= new StringTokenizer(bf.readLine());
			int type = Integer.parseInt(st.nextToken());
			if(type==1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long dif = c - array[b];
				change(1, N, 1, b, dif);
			}else {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				System.out.println(search(1, N, 1, start, end));
			}
		}
	}

	private static long search(int start, int end, int node, int startsearch, int endsearch) {
		if(startsearch>end || endsearch<start) {
			return 0;
		}
		if(startsearch<=start && endsearch>=end ) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return search(start, mid, node*2, startsearch, endsearch) + search(mid+1, end, node*2+1, startsearch, endsearch);
	}

	private static void change(int start, int end, int node, int position, long dif) {
		
		if(position<start || position>end) {
			return;
		}
		
		tree[node]+=dif;
		if(start == end) {
			array[position]+=dif;
			return;
		}
		int mid = (start+end)/2;
			
		change(start, mid, node*2, position, dif);
		change(mid+1, end, node*2+1, position, dif); 
		
	}

	private static long setting(int start, int end, int node) {
		if(start==end) {
			return tree[node]= array[start];
		}
		int mid = (start+end)/2;
			return tree[node] = setting(start, mid, node*2) + setting(mid+1, end, node*2+1); 
		
	}
	
	

}
