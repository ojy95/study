package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1034_램프 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String map[] = new String[N];
		boolean check[] = new boolean[N];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine();
		}
		
		int K = Integer.parseInt(br.readLine());
		if(K>M) {
			K=M-(K-M)%2;
		}
		int result=0;
		for(int i=0;i<N;i++) {
			if(check[i]) {
				continue;
			}
			String tmp = map[i];
			int count=0;
			for(int j=0;j<M;j++) {
				if(tmp.charAt(j)=='0') {
					count++;
				}
			}
			if(count%2 !=K%2 || count>K) {
				continue;
			}
			
			int same=0;
			for(int j=0;j<N;j++) {
				if(tmp.equals(map[j])) {
					check[j]=true;
					same++;
				}
			}
			
			if(same>result) {
				result = same;		
			}
			
		}
		System.out.println(result);
		
	}

}
