package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_9019_DSLR {
	static int A,B;
	static boolean check[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(;tc>0;tc--) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			check = new boolean[10000];
			System.out.println(bfs(A));
		}
	}
	private static String bfs(int n) {
		Queue<Register> queue = new LinkedList<Register>();
		queue.add(new Register("",n));
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size!=0) {
				size--;
				Register tmp = queue.poll();
				if(check[tmp.n]) {
					continue;
				}else {
					check[tmp.n] = true;
				}
				if(tmp.n == B) {
					return tmp.commend;
				}
				queue.add(new Register(tmp.commend+"D", tmp.n*2%10000));
				queue.add(new Register(tmp.commend+"S", (tmp.n+9999)%10000));
				queue.add(new Register(tmp.commend+"L", tmp.n%1000*10+tmp.n/1000));
				queue.add(new Register(tmp.commend+"R", tmp.n/10%1000+tmp.n%10*1000));				
			}
		}
		return "-1";
	}

}
class Register{
	String commend;
	int n;
	public Register(String commend, int n) {
		super();
		this.commend = commend;
		this.n = n;
	}
	
}