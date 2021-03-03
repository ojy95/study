package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main_B_1083_소트 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int S = Integer.parseInt(br.readLine());
		
		int start =0;
		while(S!=0 && start<N-1) {
			
			int max = arr[start];
			int target = start;
			for(int i=start+1;i<=start+S && i<N;i++) {
				if(max<arr[i]) {
					max = arr[i];
					target = i;
				}
			}
			for(int i=target;i>start;i--) {
				arr[i] = arr[i-1];
				S--;
			}
			arr[start]=max;
			start++;
		}
		
		for(int i=0;i<N;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}

}
