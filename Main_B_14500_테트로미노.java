package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Block {
	public int y;
	public int x;
	public int sum;

	Block() {
	}

	Block(int y, int x, int sum) {
		this.y = y;
		this.x = x;
		this.sum = sum;
	}
}

public class Main_B_14500_테트로미노 {

	static int N;
	static int M;
	static int array[][];
	static boolean boolArray[][];
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, -1, 0, 1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N + 2][M + 2];
		boolArray = new boolean[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				boolArray[i][j] = true;
				
				choice(i, j, 1, array[i][j]);
				boolArray[i][j] = false;
			}
		}
		System.out.println(max);
	}

	private static void choice(int y, int x, int index, int sum) {
		int moveY, moveX;
		
		if (index == 4) {
			if (max < sum) {
				max = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			moveY = y + dy[i];
			moveX = x + dx[i];
			if (moveY > 0 && moveY < (N + 1) && moveX > 0 && moveX < (M + 1)) {
				if (!boolArray[moveY][moveX]) {
					boolArray[moveY][moveX] = true;
					choice(moveY, moveX, index + 1, sum + array[moveY][moveX]);
					boolArray[moveY][moveX] = false;
				}
				
			}
			if(index==1) {
				int sum4 = sum + array[y-1][x] + array[y+1][x] + array[y][x-1] + array[y][x+1];
				if(sum4-array[moveY][moveX]>max) {
					max = sum4-array[moveY][moveX];
				}
			}
		}

	}
}
