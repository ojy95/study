package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int[] dy = {0,0,-1,1}, dx = {-1,1,0,0}; //좌우하상
	static int N,M; 
	static int result=-1;
	static int[][] checkmap = new int[100][100]; //이전에 있던곳인지 확인;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] Rposition = new int[2],Bposition = new int[2];
		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			String tmp = st.nextToken();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='B') {
					Bposition[0]=i;
					Bposition[1]=j;
				}else if(map[i][j]=='R') {
					Rposition[0]=i;
					Rposition[1]=j;
				}
			}
		}
		checkmap[Rposition[0]*10 + Rposition[1]][Bposition[0]*10+Bposition[1]]=1;
		
		search(map, Rposition, Bposition,1);
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));			
//		}
//		System.out.println(map[Bposition[0]][Bposition[1]]);
		System.out.println(result);
		
	}
	private static void search(char[][] map, int[] r, int[] b, int c) {
		int[] rsave = new int[2], bsave = new int[2];
		rsave = r.clone();
		bsave = b.clone();
		L: for(int i=0;i<4;i++) {
			r = rsave.clone();
			b = bsave.clone();
			//못움직일때
			if( map[r[0]+dy[i]][r[1]+dx[i]] == '#' &&
					map[b[0]+dy[i]][b[1]+dx[i]] == '#') {
				continue;
			}
			
			char [][] m = new char[N][M];
			for(int j=0;j<N;j++){
				m[j] = map[j].clone();
			}

			//공 움직임
			boolean Rdone=false, Bdone=false;
			boolean rgoal=false;
			while(!Rdone || !Bdone) {
				if(!Rdone) {
					if(m[r[0]+dy[i]][r[1]+dx[i]] == '.') {
						m[r[0]][r[1]] = '.'; //비우고
						r[0]+=dy[i]; //이동
						r[1]+=dx[i];
						m[r[0]][r[1]] = 'R';
						
					}else if(m[r[0]+dy[i]][r[1]+dx[i]] == 'O') {
						rgoal=true;
						m[r[0]][r[1]] = '.'; 
						Rdone=true;
					}else if(m[r[0]+dy[i]][r[1]+dx[i]] == 'B' && !Bdone){
						
					}else {
						Rdone=true;
					}
				}
				if(!Bdone) {
					if(m[b[0]+dy[i]][b[1]+dx[i]] == '.') {
						m[b[0]][b[1]] = '.'; //비우고
						b[0]+=dy[i]; //이동
						b[1]+=dx[i];
						m[b[0]][b[1]] = 'B';
						
					}else if(m[b[0]+dy[i]][b[1]+dx[i]] == 'O') {
						continue L;
					}else if(m[b[0]+dy[i]][b[1]+dx[i]] == 'B' && !Rdone){
						
					}else {
						Bdone=true;
					}
				}
//				System.out.println("-----------------------"+c);
//				for(int k=0;k<N;k++) {
//					System.out.println(Arrays.toString(m[k]));
//				}
//				System.out.println("------------------------");
			}
			
			
			
			if(rgoal) {
				if(result==-1 || result>c) result=c;
				return;
			}else {
				if(checkmap[r[0]*10+r[1]][b[0]*10+b[1]]==0 || 
						checkmap[r[0]*10+r[1]][b[0]*10+b[1]]>c) {
					checkmap[r[0]*10+r[1]][b[0]*10+b[1]]=c+1;
					search(m, r, b, c+1);
				}
				
			}
		}
		return;
	}

}
