package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_10942_팰린드롬 {
	static int array[];
	static boolean result[][];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		result = new boolean[N+1][N+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
			result[i][i] = true;
		}
		
		for(int i=1;i<N;i++) {
			if(array[i] ==array[i+1]) {
				result[i][i+1]=true;
			}
		}
		check();
		
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			if(result[S][E]) {
				sb.append(1+"\n");
			}else {
				sb.append(0+"\n");
			}
		}
		System.out.println(sb);
	}
	private static void check() {
		for(int i=2;i<N;i++) { //길이
			for(int j=1;j<=N-i;j++) { //거리
				if(array[j] == array[j+i] && result[j+1][j+i-1]) {
					result[j][j+i] = true;
				}
			}
		}
	}

}
