package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_1043_거짓말 {
	static int N,M,result;
	static boolean[] know;
	static boolean[][] schedule;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		know = new boolean[N+1];
		schedule = new boolean[M][N+1];
		result=M;
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0;i<K;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			know[tmp] = true;
			q.add(tmp);
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++) {
				schedule[i][Integer.parseInt(st.nextToken())]=true;
			}
		}
		bfs();
		System.out.println(result);

	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i=0;i<M;i++) {
				if(!schedule[i][0] && schedule[i][n]) {
					for(int j=1;j<=N;j++) {
						if(!know[j]&&schedule[i][j]) {
							know[j]=true;
							q.add(j);
						}
					}
					schedule[i][0] = true;
					result--;
				}
			}
		}
	}

}
