package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main_B_1007_백터매칭 {
	static Point[] p;
	static boolean[] start;
	static int N;
	static double result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=0;tc<T;tc++) {
			result = Double.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			p = new Point[N];
			start = new boolean[N];
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[n] = new Point(x,y); 
			}
			
			choice(0,0);
			System.out.println(result);
		}
	}
	private static void choice(int n, int c) {
		if(c==N/2) {
			search();
			return;
		}
		if(n==N) {
			return;
		}
		start[n] = true;
		choice(n+1, c+1);
		start[n] = false;
		choice(n+1,c);
		
		
	}
	private static void search() {
		double x=0,y=0;
		for(int i=0;i<N;i++) {
			if(start[i]) {
				x -= p[i].x;
				y -= p[i].y;
			}else {
				x += p[i].x;
				y += p[i].y;
			}
		}
		result = Math.min(result, Math.sqrt(x*x+y*y));
		
	}
}
