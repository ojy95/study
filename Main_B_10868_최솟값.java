package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_10868_최솟값 {
	static int N,M,arr[],tree[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		tree = new int[N*4];
		Arrays.fill(tree, Integer.MAX_VALUE);
		setTree(0,N-1,1);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			sb.append(search(0,N-1,s,e,1)+"\n" );
		}
		System.out.println(sb);
	}
	private static int search(int start, int end, int s, int e, int index) {
		if(s<=start && e>=end) {
			return tree[index];
		}
		if(start>e || end<s) {
			return Integer.MAX_VALUE;
		}
		int mid = (start+end)/2;
		return Math.min(search(start,mid,s,e,index*2),search(mid+1,end,s,e,index*2+1));
	}
	private static int setTree(int start, int end, int index) {
		if(start==end) {
			return tree[index]=arr[start];
		}
		int mid = (start+end)/2;
		return tree[index] = Math.min(setTree(start,mid,index*2), setTree(mid+1,end,index*2+1));
		
	}
}
