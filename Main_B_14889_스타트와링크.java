package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_14889_스타트와링크 {
	static boolean[] checkArray;
	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] array;
	static int[] team1;
	static int[] team2;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		team1 = new int[N / 2];
		team2 = new int[N / 2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				if (i <= j) {
					array[i][j] = Integer.parseInt(st.nextToken());
				} else {
					array[j][i] += Integer.parseInt(st.nextToken());
				}
			}
		}

		checkArray = new boolean[N];

		search(0, 0);
		System.out.println(min);
	}

	private static void search(int index, int count) {
		if (count == N / 2) {
			searchMin();
			return;
		}
		if (min == 0 || index == N)	return;


		checkArray[index] = true;
		search(index + 1, count + 1);
		checkArray[index] = false;
		search(index + 1, count);

	}

	private static void searchMin() {
		int tmp1 = 0, tmp2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (checkArray[i] && checkArray[j]) {
					tmp1 += array[i][j];
				} else if (!checkArray[i] && !checkArray[j]) {
					tmp2 += array[i][j];
				}
			}
		}
		tmp1 = Math.abs(tmp1 - tmp2);
		if (min > tmp1) {
			min = tmp1;
		}
	}
}
