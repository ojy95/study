package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {
	static int[] taste;
	static int[] cal;
	static int L;
	static int max=0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream(""));	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int testCase=0; testCase<T;testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			taste = new int[N];
			cal = new int[N];
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(bf.readLine()," ");
				taste[i]=Integer.parseInt(st.nextToken());
				cal[i]=Integer.parseInt(st.nextToken());
			}
			maxTaste(0,0,0);
			System.out.println("#"+(testCase+1)+" "+max);
			max=0;
		}
	}
	private static void maxTaste(int n,int c,int t) {
		if(c>L) return;
		if(n==taste.length) {
			if(max<t) max=t;
			return;
		}

		maxTaste(n+1,c+cal[n],t+taste[n]);
		maxTaste(n+1,c,t);
		
	}
}

