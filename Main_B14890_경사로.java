package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B14890_경사로 {
	static int N,L,map[][], result=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		L: for(int i=0;i<N;i++) {
			int count =1;
			int lastNum = map[i][0];
			for(int j=1;j<N;j++) {
				if(map[i][j]==lastNum) {
					count++;
				}else if(map[i][j]==lastNum+1 && count>=L) {
					count = 1;
					lastNum +=1;
				}else if(map[i][j]==lastNum-1 && j+L-1<N){
					lastNum-=1;
					for(int k=L-1;k>0;k--) {
						if(map[i][++j]!=lastNum) {
							continue L;
						}
					}
					count=0;
				}else {
					continue L;
				}
			}
			result++;
		}
		L: for(int j=0;j<N;j++) {
			int count =1;
			int lastNum = map[0][j];
			for(int i=1;i<N;i++) {
				if(map[i][j]==lastNum) {
					count++;
				}else if(map[i][j]==lastNum+1 && count>=L) {
					count = 1;
					lastNum +=1;
				}else if(map[i][j]==lastNum-1 && i+L-1<N){
					lastNum-=1;
					for(int k=L-1;k>0;k--) {
						if(map[++i][j]!=lastNum) {
							continue L;
						}
					}
					count=0;
				}else {
					continue L;
				}
			}
			result++;
		}
		System.out.println(result);
	}

}
