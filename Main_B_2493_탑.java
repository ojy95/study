package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_2493_탑 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int building[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			building[i]=Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Top> pq = new PriorityQueue<Top>();
		int result;
		for(int i=1;i<=N;i++) {
			result=0;
			while(!pq.isEmpty()) {
				Top tmp = pq.poll();
				if(tmp.height>=building[i]) {
					result = tmp.index;
					if(tmp.height>building[i]) {
						pq.add(tmp);
					}
					break;
				}
			}
			pq.add(new Top(building[i],i));
			sb.append(result+" ");
		}
		System.out.println(sb);
	}

}
class Top implements Comparable<Top>{
	int height;
	int index;
	public Top(int height, int index) {
		this.height = height;
		this.index = index;
	}
	@Override
	public int compareTo(Top o) {
		return this.height - o.height;
	}
	 
}