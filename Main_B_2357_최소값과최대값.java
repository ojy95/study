package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_2357_최소값과최대값 {
	static int N,M, arr[], maxTree[],minTree[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		maxTree = new int[N*4];
		minTree = new int[N*4];
		setMaxTree(0,N-1,1);
		setMinTree(0,N-1,1);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken())-1;
			int right = Integer.parseInt(st.nextToken())-1;
			sb.append(searchMin(0, N-1, left, right, 1)+" "+ searchMax(0, N-1, left, right, 1)+"\n");
		}
		System.out.println(sb);
	}
	private static int searchMax(int start, int end, int left, int right, int node) {
		if(start>right || end<left) {
			return 0;
		}
		if(left<=start && right>=end) {
			return maxTree[node];
		}
		int mid = (start+end)/2;
		return Math.max(searchMax(start, mid, left, right, node*2), searchMax(mid+1, end, left, right, node*2+1));
		
	}
	private static int searchMin(int start, int end, int left, int right, int node) {
		if(start>right || end<left) {
			return Integer.MAX_VALUE;
		}
		if(left<=start && right>=end) {
			return minTree[node];
		}
		int mid = (start+end)/2;
		return Math.min(searchMin(start, mid, left, right, node*2), searchMin(mid+1, end, left, right, node*2+1));
		
	}
	private static int setMaxTree(int start, int end, int node) {
		if(start == end) {
			return maxTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return maxTree[node] = Math.max(setMaxTree(start, mid,node*2),	setMaxTree(mid+1, end,node*2+1));
	}
	private static int setMinTree(int start, int end, int node) {
		if(start == end) {
			return minTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return minTree[node] = Math.min(setMinTree(start, mid,node*2),	setMinTree(mid+1, end,node*2+1));
	}

}
