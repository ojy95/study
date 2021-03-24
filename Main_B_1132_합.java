package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B_1132_합 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[10];
		boolean[] notZero = new boolean[10];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			notZero[tmp.charAt(0)-'A']=true;
			for(int j=0;j<tmp.length();j++) {
				num[tmp.charAt(j)-'A']+= Math.pow(10, tmp.length()-1-j);
			}
		}
		long zero = Long.MAX_VALUE;
		for(int i=0;i<10;i++) {
			if(!notZero[i] && num[i]<zero) {
				zero = num[i];
			}
		}
		Arrays.sort(num);
		for(int i=0;i<10;i++) {
			if(num[i] ==zero) {
				for(int j=i;j>0;j--) {
					num[j] = num[j-1];
				}
				num[0]=zero;
				break;
			}
		}
		long result = 0;
		for(int i=1;i<10;i++) {
			result += num[i]*i;
		}
		System.out.println(result);
	}

}
