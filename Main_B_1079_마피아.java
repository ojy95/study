package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1079_마피아 {
	static int N,me,result=0;
	static int[][] R;
	static boolean success = false;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[] gauge = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			gauge[i] = Integer.parseInt(st.nextToken());
		}
		R = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {				
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		me = Integer.parseInt(br.readLine());
		if(N%2==0) {
			night(gauge, 0);
		}else {			
			daytime(gauge, 0);
		}
		System.out.println(result);
	}
	//홀
	private static void daytime(int[] g, int r) {
		if(r>result) {
			result=r;
		}

		int max = g[0];
		int die = 0;
		for(int j=1;j<N;j++) {
			if(max<g[j]) {
				max = g[j];
				die = j;
			}
		}
		if(die != me) {
			g[die] = Integer.MIN_VALUE;
			night(g, r);
		}
	}
	//짝
	private static void night(int[] g, int r) {
		if(N/2 - r ==1 || success) {
			result = N/2;
			success = true;
			return;
		}
		for(int i=0;i<N;i++) {
			if(i==me || g[i]==Integer.MIN_VALUE) {
				continue;
			}
			int[] tmp = g.clone();
			tmp[i] = Integer.MIN_VALUE;
			for(int j=0;j<N;j++) {
				if(tmp[j] ==Integer.MIN_VALUE) {
					continue;
				}
				tmp[j] += R[i][j];
			}
			daytime(tmp,r+1);
		}
	}

}
