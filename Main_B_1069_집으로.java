package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1069_집으로 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X= Integer.parseInt(st.nextToken());
		int Y= Integer.parseInt(st.nextToken());
		int D= Integer.parseInt(st.nextToken());
		int T= Integer.parseInt(st.nextToken());
		double length = Math.sqrt(X*X+Y*Y);
		int intLength = (int)length;
		length -= intLength;
		double result;
		int share = intLength/D;
		result = Math.min(intLength+length, share*T+intLength%D+length);
		if(share==0) {
			result = Math.min(result, 2*T);
			result = Math.min(result, T+D-intLength-length);
		}else {
			result = Math.min(result, (share+1)*T);			
		}

		
		System.out.println(result);
	}

}
