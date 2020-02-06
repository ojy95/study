package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_14501_퇴사 {
	static int N;
	static int T[];
	static int P[];
	static int max=Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		T = new int[N+1];
		P = new int[N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			T[i+1] = Integer.parseInt(st.nextToken());
			P[i+1] = Integer.parseInt(st.nextToken());
		}
		
		searchMax(1,0);
		System.out.println(max);
	}
	
	private static void searchMax(int index,int money) {
		
		for(int i=index;i<N+1;i++) {
			if(i+T[i]>N+1) continue;
			
			System.out.println((i+T[i])+"로간다 "+i+" "+(money+P[i]));
			searchMax(i+T[i],money+P[i]);
		}
		if(max<money) {
			max=money;
		}
	}

}
