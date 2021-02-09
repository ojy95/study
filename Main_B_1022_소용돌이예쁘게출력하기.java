package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1022_소용돌이예쁘게출력하기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] move = { {0,1}, {-1,0}, {0,-1}, {1,0}  }; //우상좌하
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int map[][] = new int[r2-r1+1][c2-c1+1];
		
		int[] minus = new int[5001];
		int[] plus = new int[5001];
		minus[0] = 1; plus[0] = 1;
		for(int i=1;i<=5000;i++) {
			minus[i] = minus[i-1]+8*i-4;
			plus[i] = (2*i+1)*(2*i+1);
		}
		

		for(int i=0; i<r2-r1+1;i++) {
			int y = r1+i;
			for(int j=0;j<c2-c1+1;j++) {
				int x=c1+j;
				if(y+x<0) {
					if(Math.min(y, x)==y) {
						map[i][j] = minus[-y]-(x-y);
					}else {
						map[i][j] = minus[-x]+(y-x);
					}
				}else {
					if(Math.max(y, x)==y) {
						map[i][j] = plus[y] - (y-x);
					}else {
						map[i][j] = plus[x-1] + (x-y);
					}
				}
				
			}
		}
		int maxLength = (int) Math.log10(Math.max( Math.max(map[0][0], map[0][c2-c1]) , Math.max(map[r2-r1][0], map[r2-r1][c2-c1]) ));
		
		for(int i=0;i<=r2-r1;i++) {
			for(int j=0;j<=c2-c1;j++) {
				for(int k= (int) Math.log10(map[i][j]);k<maxLength;k++) {
					sb.append(" ");
				}
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
