package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1111_IQTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int a=0,b;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] term = new int[N-1];
		if(N<3) {
			System.out.println("A");
		}else {
			boolean possible = false;
			L: for(int i=arr.length-1;i>1;i--) {
				for(int j=i-1;j>0;j--) {
					if(arr[i-1]-arr[j-1]!=0) {
						if( (arr[i]-arr[j])%(arr[i-1]-arr[j-1])==0 ) {
							possible = true;
						}
						a = (arr[i]-arr[j])/(arr[i-1]-arr[j-1]);
						break L;
					}
				}
			}
			boolean check= true;
			if(possible) {
				b = arr[1]-a*arr[0];
				for(int i=1;i<arr.length-1;i++) {
					if(arr[i] !=arr[i-1]*a+b) {
						check = false;
						break;
					}
				}
				if(check) {
					System.out.println(arr[arr.length-1]*a+b);
				}else {
					System.out.println("B");
				}
			}else {
				for(int i=arr.length-2;i>0;i--) {
					if(arr[i]!=arr[arr.length-1]) {
						check = false;
					}
				}
				if(check) {
					System.out.println(arr[arr.length-1]);					
				}else {
					System.out.println("B");
				}
			}
		}
	}

}
