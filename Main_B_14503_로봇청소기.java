package study;

import java.util.Scanner;

public class Main_B_14503_로봇청소기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int area[][] = new int[N][M];
		int wayY[] = { -1, 0, 1, 0 };
		int wayX[] = { 0, 1, 0, -1 };
		int r = sc.nextInt();// 세로
		int c = sc.nextInt();// 가로
		int d = sc.nextInt();// 방향 0:북 1:동 2:남 3:서{-1,0},{0,1},{1,0},{0,-1}
		boolean back = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				area[i][j] = sc.nextInt();
			}
		}
		int result = 0, moveX, moveY, count = 0;
		while (true) {
			if (area[r][c] == 0 && !back) {
				area[r][c] = 2;
				result++;
			}

			back = false;

			if (count == 4) {// 4방향 다 청소시
				moveY = wayY[(d + 2) % 4] + r;
				moveX = wayX[(d + 2) % 4] + c;
				if (area[moveY][moveX] != 1) {
					r = moveY;
					c = moveX;
					back = true;
					count = 0;
				} else
					break;
			}

			d = (d + 3) % 4;
			moveY = wayY[d] + r;
			moveX = wayX[d] + c;
			if (area[moveY][moveX] == 0) {
				r = moveY;
				c = moveX;
				count = 0;
				continue;
			} else {
				count++;
				continue;
			}

		}

		System.out.println(result);

	}

}
