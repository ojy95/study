package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark {
	public int y;
	public int x;

	Shark(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main_B_16236_아기상어 {
	static int array[][];
	static boolean check[][];
	static int N;
	static int fishY, fishX;
	static int sharkSize = 2;
	static boolean canEat;
	static int[] dy = { -1, 0, 0, 1 };
	static int[] dx = { 0, -1, 1, 0 };
	static Queue<Shark> queue = new LinkedList<Shark>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		array = new int[N + 2][N + 2];
		check = new boolean[N + 2][N + 2];
		Shark shark;

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 9) {
					shark = new Shark(i, j);
					queue.offer(shark);
					check[i][j] = true;
					array[i][j] = 0;
				}
			}
		}

		searchFish();

	}

	private static void searchFish() {
		Shark tmpShark;
		int size;
		int count=0;
		int time=0,tmpTime=0;
		
		while (!queue.isEmpty()) {
			size = queue.size();
			tmpTime++;
			for (int j = 0; j < size; j++) {
				tmpShark = queue.poll();
				
				for (int i = 0; i < 4; i++) { // 4방탐색
					int y = tmpShark.y + dy[i];
					int x = tmpShark.x + dx[i];
					if (!check[y][x] && y > 0 && y < N + 1 && x > 0 && x < N + 1) {
						if (array[y][x] <= sharkSize && !check[y][x]) { // 이동가능경로
							queue.offer(new Shark(y, x));
							check[y][x] = true;
							if(array[y][x] < sharkSize && array[y][x]!=0) {
								canEat = true;
							}
						}
					}
				}
			}
			
			if (canEat) {
				time = tmpTime;
				fishY = Integer.MAX_VALUE; // 물고기 위치 변수 초기화
				fishX = Integer.MAX_VALUE;
				while (!queue.isEmpty()) {
					tmpShark = queue.poll();
					if(array[tmpShark.y][tmpShark.x]<sharkSize && array[tmpShark.y][tmpShark.x]!=0) {
						if (tmpShark.y < fishY) {
							fishY = tmpShark.y;
							fishX = tmpShark.x;
						}else if(tmpShark.y == fishY && tmpShark.x < fishX) {
							fishX = tmpShark.x;
						}
					}
				}
				array[fishY][fishX]=0;
				if(++count==sharkSize) {
					sharkSize++;
					count=0;
				}
				check = new boolean[N + 2][N + 2];
				canEat = false;
				queue.offer(new Shark(fishY, fishX));
				check[fishY][fishX] = true;
				
			}

		}
		System.out.println(time);

	}

}
