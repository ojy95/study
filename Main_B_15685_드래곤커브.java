package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B_15685_드래곤커브 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] dy = {0,-1,0,1}, dx= {1,0,-1,0}; //0123
		int[][] map = new int[101][101];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			map[y][x]=1;
			y += dy[d]; x += dx[d];
			map[y][x]=1;
			Stack s = new Stack<Integer>();
			s.push(d);
			while(g-->0) {
				Stack<Integer> tmp = (Stack<Integer>) s.clone();
				while(!tmp.isEmpty()) {
					int m = tmp.pop();
					s.push((m+1)%4);
					y += dy[(m+1)%4]; x += dx[(m+1)%4];
					map[y][x]=1;
					
				}
			}
		}
		int result=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1) {
					result+=1;
				}
			}
		}
		System.out.println(result);
	}

}
