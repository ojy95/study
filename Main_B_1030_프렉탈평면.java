package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1030_프렉탈평면 {
	static int s,N,K,R1, R2, C1, C2, depth;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int result;
		for(int i=N/2-K/2; i<N/2+(K+1)/2;i++ ) {
			for(int j=N/2-K/2; j<N/2+(K+1)/2;j++ ) {
				map[i][j] = 1;
			}
		}
		
		int color;
		depth=1;
		int size = (int) Math.pow(N, s);
		int r,c;
		int before[][];
		for(int i=R1;i<=R2;i++) {
			for(int j=C1;j<=C2;j++) {
				result=0;
				if(i>(size-1)/2) {
					r=size-1-i;
				}else {
					r= i;
				}
				if(j>(size-1)/2) {
					c=size-1-j;
				}else {
					c= j;
				}
				int unit = N;
				int count=0;
				
				while(true) {
					if(r>=unit || c>=unit) {
						unit*=N;
						count++;
						continue;
					}
					before = new int[count+1][2];
					for(int k=count;k>0;k--) {
						unit/=N;
						before[k][0] = (r/unit)%N;
						before[k][1] = (c/unit)%N;
					}
					before[0][0] = r%N;
					before[0][1] = c%N;
					break;
				}
				for(int k=0;k<=count;k++) {
					if(map[ before[k][0] ][ before[k][1] ]==1) {
						result=1;
						break;
					}
				}
				sb.append(result);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}


}
