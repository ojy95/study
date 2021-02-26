package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_1039_교환 {
	static int M,result=-1;
	static boolean[][] check = new boolean[1000001][11];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = (int) Math.log10(N);
		
		Queue<Num> q = new LinkedList<>();
		q.add(new Num(N,0));
		while(!q.isEmpty()) {
			if(q.peek().c==K) {
				break;
			}
			Num num = q.poll();
			for(int i=0;i<=M;i++) {
				for(int j=i+1;j<=M;j++) {
					int tmp = swap(num.n,i,j);
					if(tmp!=-1 && !check[tmp][num.c+1]) {
						check[tmp][num.c+1]=true;
						q.add(new Num(tmp,num.c+1));
					}
				}
			}
		}
		while(!q.isEmpty()) {
			Num num = q.poll();
			if(result<num.n) {
				result=num.n;
			}
		}
		System.out.println(result);
		
		
	}
	private static int swap(int n, int i, int j) {
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		if(i==0 && sb.charAt(j)=='0') {
			return -1;
		}
		
		char tmp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, tmp);
		return Integer.parseInt(sb.toString());
	}


}
class Num{
	int n;
	int c;
	public Num(int n, int c) {
		this.n = n;
		this.c = c;
	}
}