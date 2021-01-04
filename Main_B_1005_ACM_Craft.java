package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_B_1005_ACM_Craft {
	private static Object L;

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		for(int tc=0;tc<TC;tc++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int time[] = new int[N];
			List<Integer>[] graph = new ArrayList[N];
			
			st = new StringTokenizer(bf.readLine());
			for(int n=0;n<N;n++) {
				time[n] =  Integer.parseInt(st.nextToken());
				graph[n] = new ArrayList<Integer>();
			}
			
			
			int indegree[] = new int[N];
			
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(bf.readLine());
				int X = Integer.parseInt(st.nextToken())-1;
				int Y = Integer.parseInt(st.nextToken())-1;
				
				graph[X].add(Y);
				indegree[Y]++;
			}
			
			st = new StringTokenizer(bf.readLine());
			int W = Integer.parseInt(st.nextToken())-1;
			
			Queue<Integer> q = new LinkedList<Integer>();
			int sumTime[] = new int[N];
			for(int n=0;n<N;n++) {
				if(indegree[n]==0) {
					sumTime[n] = time[n];
					q.add(n);
				}
			}
			
			L: while(!q.isEmpty()) {
				int a = q.poll();
				
				for(int n : graph[a]) {
					sumTime[n] = Math.max(sumTime[n], sumTime[a]+time[n]);
					if(--indegree[n] ==0) {
						q.add(n);
					}
				}
			}
			
			System.out.println(sumTime[W]);
			
		}

	}
}

