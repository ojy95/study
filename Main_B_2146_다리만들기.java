package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_2146_다리만들기 {
	static int N, map[][], dy[]= {1,0,-1,0},dx[]= {0,1,0,-1};
	static Queue<Point> queue = new LinkedList<Point>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int mapIndex=2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					map[i][j]=mapIndex;
					setMap(i,j,mapIndex++);									
				}
			}
		}
		int result =0;
		L : while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				Point tmp = queue.poll();
//				System.out.println(tmp.y+" "+tmp.x);
//				for(int j=0;j<N;j++) {
//					System.out.println(Arrays.toString(map[j]));
//				}
//				System.out.println("----------------------------------------------------");
				for(int k=0;k<4;k++) {
					int moveY= tmp.y + dy[k];
					int moveX= tmp.x + dx[k];
					if(moveY<0 || moveY>=N || moveX<0 || moveX>=N) {
						continue;
					}
					if(map[moveY][moveX]==0 ) {
						queue.add(new Point(moveY,moveX,tmp.mapIndex));
						map[moveY][moveX] = tmp.mapIndex;
					}else if(map[moveY][moveX]!=tmp.mapIndex) {
						if(map[moveY][moveX]<tmp.mapIndex) {
							result = result*2+1;
						}else {
							result = result*2;
						}
						break L;
					}
				}
			}
			result++;				
			for(int j=0;j<N;j++) {
				System.out.println(Arrays.toString(map[j]));
			}
			System.out.println("----------------------------------------------------");
		}
		System.out.println(result);
	}
	private static void setMap(int y, int x, int mapIndex) {
		boolean contain = false;
		for(int k=0;k<4;k++) {
			int moveY= y + dy[k];
			int moveX= x + dx[k];
			if(moveY<0 || moveY>=N || moveX<0 || moveX>=N) {
				continue;
			}
			if(map[moveY][moveX]==1) {
				map[moveY][moveX] = mapIndex;
				setMap(moveY,moveX,mapIndex);
			}else if(!contain && map[moveY][moveX]==0 ){
				queue.add(new Point(y,x,mapIndex));
				contain = true;
			}
		}
	}

}

class Point{
	int y,x,mapIndex;

	public Point(int y, int x,int mapIndex) {
		this.y = y;
		this.x = x;
		this.mapIndex = mapIndex;
	}
	
}