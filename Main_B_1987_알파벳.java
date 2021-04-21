package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1987_알파벳 {
	static int R,C,map[][],result=0,dy[]= {1,0,-1,0}, dx[]= {0,1,0,-1};
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			String tmp = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = tmp.charAt(j)-'A';
			}
		}
		check = new boolean['Z'-'A'+1];
		check[map[0][0]] = true;
		start(0,0,1);
		System.out.println(result);
	}
	private static void start(int r, int c, int count) {
		if(count>result) {
			result = count;
		}
		for(int i=0;i<4;i++) {
			int moveR = r+dy[i];
			int moveC = c+dx[i];
			if(moveR<0 || moveC<0 || moveR>=R || moveC>=C) {
				continue;
			}
			if(!check[map[moveR][moveC]]) {
				check[map[moveR][moveC]] = true;
				start(moveR,moveC,count+1);
				check[map[moveR][moveC]] = false;
			}
			
		}
	}
}
