package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_12100_2048easy {
	static int N, result=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(result<map[i][j]) {
					result = map[i][j];
				}
			}
		}
		start(0, map);
		System.out.println(result);
	}
	private static void start(int turn, int[][] map) {
		if(turn==5) {
			return;
		}
		int tmpMap[][] = new int[N][N];
		int lastNum,count;
		for(int i=0;i<N;i++) { //좌
			lastNum=0;count=0;
			for(int j=0;j<N;j++) {
				if(map[i][j]==0) {
					continue;
				}
				if(lastNum==map[i][j]) {
					if(result==lastNum) {
						result*=2;
					}
					tmpMap[i][count-1]*=2;
					lastNum=0;
				}else {
					tmpMap[i][count++]=map[i][j];
					lastNum=map[i][j];
				}
			}
		}
		start(turn+1,tmpMap);
		
		tmpMap = new int[N][N];
		for(int i=0;i<N;i++) { //우
			lastNum=0;count=N-1;
			for(int j=N-1;j>=0;j--) {
				if(map[i][j]==0) {
					continue;
				}
				if(lastNum==map[i][j]) {
					if(result==lastNum) {
						result*=2;
					}
					tmpMap[i][count+1]*=2;
					lastNum=0;
				}else {
					tmpMap[i][count--]=map[i][j];
					lastNum=map[i][j];
				}
			}
		}
		start(turn+1,tmpMap);
		
		tmpMap = new int[N][N];
		for(int i=0;i<N;i++) { // 상
			lastNum=0;count=0;
			for(int j=0;j<N;j++) {
				if(map[j][i]==0) {
					continue;
				}
				if(lastNum==map[j][i]) {
					if(result==lastNum) {
						result*=2;
					}
					tmpMap[count-1][i]*=2;
					lastNum=0;
				}else {
					tmpMap[count++][i]=map[j][i];
					lastNum=map[j][i];
				}
			}
		}
		start(turn+1,tmpMap);
		
		tmpMap = new int[N][N];
		for(int i=0;i<N;i++) { //하
			lastNum=0;count=N-1;
			for(int j=N-1;j>=0;j--) {
				if(map[j][i]==0) {
					continue;
				}
				if(lastNum==map[j][i]) {
					if(result==lastNum) {
						result*=2;
					}
					tmpMap[count+1][i]*=2;
					lastNum=0;
				}else {
					tmpMap[count--][i]=map[j][i];
					lastNum=map[j][i];
				}
			}
		}
		start(turn+1,tmpMap);		
	}

}
