package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_9963_NQueen {
	static int result =0,N, position[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		position = new int[N];
		
		search(0);
		System.out.println(result);
	}
	private static void search(int p) {
		if(p==N) {
			result++;
			return;
		}
		L: for(int i=0;i<N;i++) {
			for(int j=0;j<p;j++) {
				if(position[j]==i || p-j == Math.abs(position[j]-i)) {
					continue L;
				}
			}
			position[p]=i;
			search(p+1);
		}
	}

}
