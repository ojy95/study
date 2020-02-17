package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_10971_외판원순회2 {
	static int N,min=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			visited[i]=true;
			search(i,i,0,0);
			visited[i]=false;
		}
		System.out.println(min);
	}
	private static void search(int start,int now, int money,int count) {
		if(count==N-1) {
			if(map[now][start]!=0) {
				money+=map[now][start];
				if(min>money) {
					min=money;
				}
			}
			return;
		}
		for(int i=0; i<N;i++) {
			if(visited[i] || map[now][i]==0) continue;
			visited[i]=true;
			search(start,i,money+map[now][i],count+1);
			visited[i]=false;
			
		}
	}
}
