package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1092_배 {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] crain = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] box = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crain);
		Arrays.sort(box);
		int result=0;
		if(box[M-1]>crain[N-1]) {
			System.out.println(-1);
		}else {
			int where[] = new int[N];
			Arrays.fill(where,M-1);
			while(M!=0) {
				for(int i=N-1;i>=0;i--) {
					for(int j=where[i];j>=0;j--) {
						if(box[j]==0 || box[j]>crain[i]) {
							where[i]--;
							continue;
						}
						box[j]=0;
						M--;
						break;
					}
				}
				result++;
			}
			System.out.println(result);
		}
	}

}
