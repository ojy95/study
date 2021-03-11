package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1091_카드섞기 {
	static int N, result=0;
	static int[] P,S,tmp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = new int[N];
		S = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			P[i] = Integer.parseInt(st.nextToken());
			tmp[i] = P[i];
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		L: while(!success()) {
			result++;
			int[] tmp2 = tmp.clone();
			for(int i=0;i<N;i++) {
				tmp[S[i]] = tmp2[i]; 
			}
			
			for(int i=0;i<N;i++) {
				if(tmp[i] != P[i]) {
					continue L;
				}
			}
			result=-1;
			break;
		}
		System.out.println(result);


	}
	private static boolean success() {
		for(int i=0;i<N;i++) {
			if(tmp[i] != i%3) {
				return false;
			}
		}
		return true;
	}

}
