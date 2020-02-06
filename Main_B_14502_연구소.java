package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_14502_연구소 {
	static int[][] array;
	static int[][] tmpArray;
	static int N;
	static int M;
	static int max=Integer.MIN_VALUE;
	static int dy[] = new int[] {1,0,-1,0};
	static int dx[] = new int[] {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		array = new int[N+2][M+2];
		tmpArray = new int[N+2][M+2];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=1;j<M+1;j++) {
				array[i][j]=Integer.parseInt(st.nextToken())-1;//바이러스1,벽0,빈곳 -1
			}	
		}

		build(0);
		System.out.println(max);
	}
	private static void build(int index) {
		if(index==3) {
			virus();
			return;
		}
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				if(array[i][j]==-1)	{
					array[i][j]=0;
					build(index+1);
					array[i][j]=-1;
				}
				
			}
		}
	}
	private static void virus() {
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				tmpArray[i][j]=array[i][j];
			}
		}
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				if(array[i][j]==1) {
					virusMove(i,j);
				}
			}
		}
		int tmp=0;
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				if(array[i][j]==-1) {
					tmp++;
				}
			}
		}
		if(tmp>max) {
			max=tmp;
		}
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				array[i][j]=tmpArray[i][j];
			}
		}
		return;

	}
	private static void virusMove(int y, int x) {
		for(int k=0; k<4;k++) {
			if(array[y+dy[k]][x+dx[k]]==-1) {
				array[y+dy[k]][x+dx[k]]=1;
				virusMove(y+dy[k],x+dx[k]);
			}
		}
		return;
		
	}
}
