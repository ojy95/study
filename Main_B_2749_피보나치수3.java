package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_2749_피보나치수3 {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		String num = st.nextToken();
		int len = num.length();
		long a=1,b=1;
		long n =4;
		while(true) {
			if(n%2==1) {
				a=(a+b)%1000000;
			}else {
				b=(a+b)%1000000;
				if(b==1) { //1500003번쨰 1,1 F(3) = F(1500003) 1500000텀 대신 F(1500000)=999999
					break;
				}
			}
			n++;
		}
		int[] array = new int[len];
		for(int i=0;i<len;i++) {
			array[i] =num.charAt(i)-'0';
		}
		long divide;
		if(len>8) {
			String tmp = num.substring(0, 8);
			divide = Long.parseLong(tmp);
			for(int i=0;i<len-8;i++) {
				divide*=10;
				divide+=num.charAt(8+i)-'0';
				divide = divide%1500000;	
			}	
		}else {
			divide = Long.parseLong(num)%1500000;
		}
		int result;
		if(divide==0) {
			if(len>6) {
				result=999999;
			}else {
				result =0;
			}
		}else if(divide==1) {
			result=1;
		}else {
			a=0; 
			b=1;
			for(int i=2;i<=(int)divide;i++) {
				if(i%2==0) {
					a=(a+b)%1000000;
				}else {
					b=(a+b)%1000000;
				}
			}
			if(divide%2==0) {
				result=(int)a;
			}else {
				result=(int)b;
			}
		}

		System.out.println(result);
	}

}
