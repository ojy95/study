

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Point{
	public int pointY;
	public int pointX;
	Point(){}
	Point(int y,int x){
		this.pointY=y;
		this.pointX=x;
	}
}
public class Main_B_2667_단지번호붙이기_오정엽_bfs {
	
	
	static int N;
	static int array[][];
	static boolean boolArray[][];
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String str;
		N = Integer.parseInt(st.nextToken());
		array = new int[N + 2][N + 2];
		boolArray = new boolean[N + 2][N + 2];
		Queue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine());
			str = st.nextToken();
			for (int j = 1; j < N + 1; j++) {
				if (str.charAt(j - 1) == '1') {
					array[i][j] = 1;
					boolArray[i][j] = true;
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (boolArray[i][j]) {
					Queue<Point> q = new LinkedList<Point>();
					Point yx = new Point(i,j);
					q.offer(yx);
					boolArray[i][j] = false;
					queue.offer(bfs(q));
				}
			}
		}
		System.out.println(queue.size());
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

	private static int bfs(Queue<Point> q) {
		
		int count=1;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				if (tmp.pointY + dy[i] == 0 || tmp.pointY + dy[i] == N + 1 || tmp.pointX + dx[i] == 0 || tmp.pointX + dx[i] == N + 1)
					continue;
				if (array[tmp.pointY + dy[i]][tmp.pointX + dx[i]] == 1 && boolArray[tmp.pointY + dy[i]][tmp.pointX + dx[i]]) {
					boolArray[tmp.pointY + dy[i]][tmp.pointX + dx[i]] = false;
					Point tmp2 = new Point(tmp.pointY + dy[i], tmp.pointX + dx[i]);
					count++;
					q.offer(tmp2);
				}
			}
		}
		return count;
	}
	
}
