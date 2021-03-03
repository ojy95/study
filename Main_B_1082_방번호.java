package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1082_방번호 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] price = new int[N];
		for(int i=0;i<N;i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		int total = Integer.parseInt(br.readLine());
		
		if(N>1) {
			int min = price[1];
			int minn=1;
			for(int i=2;i<N;i++) {
				if(min>=price[i]) {
					min=price[i];
					minn=i;
				}
			}
			if(total>=min) {
				total-=min;
				sb.append(minn);
			}
			if(min>price[0] && sb.length()>0) {
				min = price[0];
				minn = 0;
			}
			while(total>=min) {
				sb.append(minn);
				total-=min;
			}
			for(int i=0;i<sb.length();i++) {
				int n = sb.charAt(i)-'0'; 
				for(int j=N-1;j>n;j--) {
					if(total - price[j] + price[n]>=0) {
						total = total - price[j] + price[n];
						sb.setCharAt(i, (char)(j+'0'));
						continue;
					}
				}
			}
		}
		if(sb.length()>0) {			
			System.out.println(sb);
		}else {
			System.out.println(0);
		}
	}


}
