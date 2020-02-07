	package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기_오정엽 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Queue<Integer> q= new LinkedList();
		for(int i=1; i<11;i++) {
			st = new StringTokenizer(bf.readLine());
			st = new StringTokenizer(bf.readLine()," ");
			
			for(int j=0;j<8;j++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			for(int j=1;;j++) {
				if(q.peek()-j>0) {
					q.offer(q.poll()-j);
				}else {
					q.poll();
					q.offer(0);
					break;
				}
				
				if(j==5) {
					j=0;
				}
			}
			System.out.print("#"+i);
			while(!q.isEmpty()) {
				System.out.print(" "+q.poll());
			}
			System.out.println();
		}
	}

}
