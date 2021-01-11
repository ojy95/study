package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_B_6549_히스토그램에서가장큰직사각형_분할정복 {
	static int[] tree, array;
	static long result;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) {
				break;
			}
			result=0;
			array = new int[N+1];
			for(int i=1;i<=N;i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			int h = (int) Math.ceil( Math.log(N) / Math.log(2) );
			tree = new int[(int) Math.pow(2, h+1)];
			
			init(1, 1, N);
			search(1, N);
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}

	private static void search(int start, int end) {
		int minNode = searchMin(start, end, 1, N, 1); //최소높이 노드
		
		if(result < (end-start+1)*(long)array[minNode] ) {
			result = (end-start+1)*(long)array[minNode];
		}
		
		if(minNode > start) {
			search(start,minNode-1); //왼쪽탐색
		}
		if(minNode < end) {
			search(minNode+1,end); //오른쪽탐색
		}
	}

	private static int searchMin(int start, int end, int arrayStart, int arrayEnd, int node) {
		if(start <= arrayStart && end >= arrayEnd) {
			return tree[node];
		}
		
		if(arrayStart > end || arrayEnd < start) {
			return -1;
		}

		
		int mid = (arrayStart + arrayEnd) /2;
		int L = searchMin(start, end, arrayStart, mid, node*2);
		int R = searchMin(start, end, mid+1, arrayEnd, node*2+1);
		
		if(L==-1){
			return R;
		}else if(R==-1) {
			return L;
		}
		if(array[L]<=array[R]) {
			return L;
		}else {
			return R;
		}
		
	}

	private static int init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = start;
		}
		
		int mid = (start+end)/2;
		
		int L = init(node*2,start,mid);
		int R = init(node*2+1,mid+1,end);
		
		if(array[L]<=array[R]) {
			return tree[node] = L;
		}else {
			return tree[node] = R;
		}
	}

}
