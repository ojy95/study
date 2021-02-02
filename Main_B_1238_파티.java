package Solution_B_1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Town implements Comparable<Town>{
	int end;
	int weight;
	
	Town(int end, int weight){
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Town t){
		return weight - t.weight;
	}
}
public class Main_B_1238_파티 {
	static ArrayList<ArrayList<Town>> arrList, reverse_arrList;
	static int N, X;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arrList = new ArrayList<>();
		reverse_arrList = new ArrayList<>();
		
		for(int i=0; i<=N;i++) {
			arrList.add(new ArrayList<>());
			reverse_arrList.add(new ArrayList<>());
		}
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			arrList.get(start).add(new Town(end, weight));
			reverse_arrList.get(end).add(new Town(start, weight));
		}
		int[] dist1 = dijkstra(arrList);
		int[] dist2 = dijkstra(reverse_arrList);
		
		int answer = 0;
		for(int i=1;i<=N;i++) {
			answer = Math.max(answer, dist1[i]+dist2[i]);
		}
		System.out.println(answer);
		
	}
	public static int[] dijkstra(ArrayList<ArrayList<Town>> t) {
		PriorityQueue<Town> pq = new PriorityQueue<Town>();
		pq.offer(new Town(X,0));
		
		boolean[] check = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			Town curTown = pq.poll();
			int cur = curTown.end;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Town town : t.get(cur)) {
					if(!check[town.end] && dist[town.end] > dist[cur] + town.weight) {
						dist[town.end] = dist[cur]+ town.weight;
						pq.add(new Town(town.end, dist[town.end]));
					}
				}
			}
		}
		return dist;
	}

}
