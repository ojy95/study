package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_1153_네개의소수 {
	static int[] result = new int[4];
	static boolean[] prime;
	static boolean success = false;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		prime = new boolean[N+1];
		L: for(int i=2;i<=N;i++) {
			for(int j=2;j*j<=i;j++) {
				if(i%j==0) {
					continue L;
				}
			}
			prime[i]=true;
		}
		
		search(N, 4);
		if(success) {
			for(int i=0;i<4;i++) {
				System.out.print(result[i]+" ");
			}
		}else {
			System.out.println(-1);
		}
	}

	private static void search(int n, int c) {
		if( c==0 && n==0) {
			success = true;
			return;
		}
		for(int i=n;i>1;i--) {
			if(success) {
				return;
			}
			if(prime[i] && n-i>=(c-1)*2) {
				result[c-1] = i;
				search(n-i, c-1);
			}
		}
	}

}
