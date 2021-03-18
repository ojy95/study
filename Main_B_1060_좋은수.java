package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1060_좋은수 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] S = new int[L+1];
		for(int i=1;i<L+1;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(S); //S정렬
		int n = Integer.parseInt(br.readLine());
		int over = n-S[L];
		n = Math.min(n, S[L]);
		int[] arr = new int[L];
		int[] middle = new int[L];
		middle[0] = S[0]/2;
		for(int i=1;i<L+1;i++,n--) { // S원소 먼저 출력
			if(n==0) {
				break;
			}
			if(S[i]-S[i-1]==2) {
				sb.append(S[i]-1+" ");
				if(--n==0) break;
			}
			sb.append(S[i]+" ");
			arr[i-1] = S[i-1]+1;
			middle[i-1] = (S[i-1]+S[i])/2;
		}
		while(n!=0) {
			long minCount = Long.MAX_VALUE;
			int minValue = 0;
			for(int i=0;i<L;i++) {
				if(arr[i]>middle[i]) {
					continue;
				}
				long count = (long)(arr[i] - S[i])*(S[i+1] - arr[i]);
				if(count==1) {
					arr[i]++;
					continue;
				}
				if(minCount>count) {
					minCount = count;
					minValue = i;
				}
			}
			if(minValue!=Long.MAX_VALUE) {
				sb.append(arr[minValue]+" ");
				n--;
				if(n>0 && S[minValue+1] + S[minValue] != arr[minValue]*2) {
					sb.append(S[minValue+1] + S[minValue] - arr[minValue] + " ");
					n--;
				}
				
				arr[minValue]++;
			}else {
				break;
			}
			
			
		}
		for(int i=1;i<=over;i++) {
			sb.append(S[L]+i+" ");
		}
		System.out.print(sb);

		
	}

}
