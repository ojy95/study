package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_1027_고층건물 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] tower = new int[N+1];
		for(int i=1;i<=N;i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		int[] result = new int[N+1];
		boolean check;
		int max =0;
		for(int i=1;i<N;i++) {
			for(int j=i+1;j<=N;j++) {
				check = true;
				double gradient = (double) (tower[i]-tower[j])/(i-j);
				double constant = tower[i] - gradient*i;
				for(int k=i+1;k<j;k++) {
					if(tower[k]>= gradient*k+constant) {
						check=false;
						break;
					}
				}
				if(check) {
					result[i]++;
					result[j]++;
				}
			}
			max = Math.max(max, result[i]);
		}
		max = Math.max(max, result[N]);
		System.out.println(max);
	}

}
