package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_15684_사다리조작 {
	static int N,M,H, result, map[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken())-1;
			int n = Integer.parseInt(st.nextToken())-1;
			map[h][n] = 1;
			map[h][n+1] = 2;
		}

		for(int i=0;i<4;i++) {
			result = i;
			check(0,0);
		}
		System.out.println("-1");
	}
	private static void check(int num, int c) {
		if(c==result) {
			if(check2()) {
				System.out.println(result);
				System.exit(0);
			}
			return;
		}
		if(num >= N*H) {
			return;
		}
		int h = num/N;
		int n = num%N;
		if(n !=N-1 && map[h][n]==0 && map[h][n+1]==0) {
			map[h][n]=1;
			map[h][n+1]=2;
			check(num+2,c+1);
			map[h][n]=0;
			map[h][n+1]=0;
		}
		check(num+1,c);
	}
	private static boolean check2() {
		for(int i=0;i<N;i++) {
			int n=i;
			for(int j=0;j<H;j++) {
				if(map[j][n]==1) {
					n++;
				}else if(map[j][n]==2) {
					n--;
				}
			}
			if(n!=i) {
				return false;
			}
		}
		return true;
		
	}

}
