package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B_17472_다리만들기2 {
	static int N,M,min=Integer.MAX_VALUE,num;
	static int[][] map, islandStart, distance;
	static boolean[][] boolMap ;	
	static int[] dy= new int[] {-1,1,0,0};
	static int[] dx= new int[] {0,0,1,-1};
	static boolean[] boolDistance;
	static boolean linked=false;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		boolMap = new boolean[N+2][M+2];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=1;j<M+1;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		islandStart = new int[6][2];
		num=1;
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				if(map[i][j]==1 && !boolMap[i][j]) {
					islandStart[num-1][0]=i;
					islandStart[num-1][1]=j;
					boolMap[i][j]=true;
					map[i][j]=num;
					numberingIsland(i,j,num++);
				}
			}
		}
		for(int i=1;i<N+1;i++) {
			System.out.println(Arrays.toString(map[i]));
		}

		distance = new int[num-1][num-1];
		boolDistance = new boolean[num-1];
		int tmp,d;
		
		// 가로 거리 검색
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				if(map[i][j]!=0) {
					tmp=map[i][j];
					d=0;
					while(true) {
						j++;
						if(j>M) break;
						if(map[i][j]!=0) {
							if(map[i][j]==tmp) {
								d=0;
								continue;
							}else {
								if(d>1) {
									if(distance[tmp-1][map[i][j]-1] ==0) {
										distance[tmp-1][map[i][j]-1]=d;
										distance[map[i][j]-1][tmp-1]=d;
									}else if(distance[tmp-1][map[i][j]-1]>d ) {
										distance[tmp-1][map[i][j]-1]=d;
										distance[map[i][j]-1][tmp-1]=d;
									}	
								}
								tmp=map[i][j];
								d=0;
								continue;
							}
						}
						d++;
					}
					break;
				}
			}
		}
		//세로 거리검색
		for(int j=1;j<M+1;j++) {
			for(int i=1;i<N+1;i++) {
				if(map[i][j]!=0) {
					tmp=map[i][j];
					d=0;
					while(true) {
						i++;
						if(i>N) break;
						if(map[i][j]!=0) {
							if(map[i][j]==tmp) {
								d=0;
								continue;
							}else {
								if(d>1) {
									if(distance[tmp-1][map[i][j]-1] ==0) {
										distance[tmp-1][map[i][j]-1]=d;
										distance[map[i][j]-1][tmp-1]=d;
									}else if(distance[tmp-1][map[i][j]-1]>d ) {
										distance[tmp-1][map[i][j]-1]=d;
										distance[map[i][j]-1][tmp-1]=d;
									}
								}
								tmp=map[i][j];
								d=0;
								continue;
							}
						}
						d++;
					}
					break;
				}
			}
		}
		for(int i=0;i<num-1;i++) {
			System.out.println(Arrays.toString(distance[i]));
		}
		boolDistance[0]=true;
		searchMin(1,0);

		if(!linked) {
			min=-1;
		}
		
		
		System.out.println(min);
		

	}
	private static void numberingIsland(int y,int x, int code) { //dfs
		for(int i=0;i<4;i++) {
			if(map[y+dy[i]][x+dx[i]]!=0 && !boolMap[y+dy[i]][x+dx[i]]) {
				boolMap[y+dy[i]][x+dx[i]]=true;
				map[y+dy[i]][x+dx[i]]=code;
				numberingIsland(y+dy[i],x+dx[i],code);
			}
		}
	}
	private static void searchMin(int count,int sum) { 
		if(count==num-1) {
			linked=true;
			if(min>sum) min=sum;
			return;
		}

		for(int i=0;i<num-1;i++) {
			if(!boolDistance[i]) continue;
			for(int j=0;j<num-1;j++) {
				if(distance[i][j]==0 || boolDistance[j])continue;
				boolDistance[j]=true;
				searchMin(count+1,sum+distance[i][j]);
				boolDistance[j]=false;
			}
		}
	}
	
}
