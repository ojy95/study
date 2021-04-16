package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_17143_낚시왕 {
	static int R,C;
	static boolean death[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[R+1][C+1];
		Shark shark[] = new Shark[M];
		death = new boolean[M];
		int dy[]= {0, -1, 0, 1}, dx[] = {-1,0,1,0};
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			shark[i] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
		}
		Arrays.sort(shark);
		for(int i=0;i<M;i++) {
			map[shark[i].r][shark[i].c] = i+1;
			if(shark[i].d%2==0) { //좌우
				shark[i].setS(shark[i].s%(C*2-2));				
			}else {
				shark[i].setS(shark[i].s%(R*2-2));								
			}
		}
		int result = 0;
		
		for(int col=1;col<=C;col++) {
			for(int row=1;row<=R;row++) {
				int num = map[row][col];
				if(num!=0) {
					result += shark[num-1].z;
					death[num-1]=true;
					map[row][col]=0;
					break;
				}
			}
			for(int i=0;i<M;i++) {
				if(death[i]) continue;
				int r = shark[i].r, c = shark[i].c, d = shark[i].d;
				if(map[r][c]==i+1) map[r][c] = 0;
				int move,max;
				if(d%2==0) {//좌우
					move = c + dx[shark[i].d]*shark[i].s;
					max = C;
				}else {
					move = r + dy[shark[i].d]*shark[i].s;
					max = R;
				}
				while(move<1 || move>max) {
					if(move<1) {
						move = -move+2;
					}else {
						move = max*2 - move;
					}
					d = (d+2)%4;
				}
				if(d%2==0) {
					shark[i].setC(move);
					Fight(map[r][move],i);
					map[r][move] = i+1;
				}else {
					shark[i].setR(move);
					Fight(map[move][c],i);
					map[move][c] = i+1;
				}
				shark[i].setD(d);
			}
		}
		System.out.println(result);
	}
	private static void Fight(int destination,int i) {
		if(destination>0 && destination<=i) {
			death[destination-1] = true;
		}
	}
}
class Shark implements Comparable<Shark>{
	int r;
	int c;
	int s;
	int d; //상하우좌1234 -> 좌상우하0123
	int z;
	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		if(d==2) {
			d=3;
		}else if(d==3) {
			d=2;
		}
		this.d = d%4;
		this.s = s;
		this.z = z;
	}
	public void setR(int r) {
		this.r = r;
	}
	public void setC(int c) {
		this.c = c;
	}
	public void setS(int s) {
		this.s = s;
	}
	public void setD(int d) {
		this.d = d;
	}
	@Override
	public int compareTo(Shark o) {
		return this.z-o.z;
	}
}