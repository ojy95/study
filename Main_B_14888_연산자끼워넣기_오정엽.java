package study;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B_14888_연산자끼워넣기_오정엽 {
	static int A[]; // 숫자
	static int arithmetic[]; // 사칙연산 배열
	static int tmpArithmetic[]; // 사칙연산 수열저장소
	static int max=-10000, min=100000;
	static boolean useArithmetic[];// 사용여부

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int tmp = 0, tmp2 = 0;
		A = new int[N];
		arithmetic = new int[N - 1];
		tmpArithmetic = new int[N - 1];
		useArithmetic = new boolean[N - 1];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			tmp += sc.nextInt();
			for (; tmp2 < tmp; tmp2++) {
				arithmetic[tmp2] = i; //덧셈 뺄셈 곱셈 나눗셈
			}
		}
		// System.out.println(Arrays.toString(arithmetic));
		search(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void search(int position) {
		if (position == tmpArithmetic.length) {
			//System.out.println(Arrays.toString(tmpArithmetic));
			calculation();
			return;
		}

		for (int i = 0; i < tmpArithmetic.length; i++) {
			if (useArithmetic[i])
				continue;
			tmpArithmetic[position] = arithmetic[i];
			useArithmetic[i] = true;
			search(position + 1);
			useArithmetic[i] = false;

		}
	}
	private static void  calculation() {
		int tmp=A[0];
		for(int i=0; i<tmpArithmetic.length;i++) {
			if(tmpArithmetic[i]==0) {
				tmp += A[i+1];
			}else if(tmpArithmetic[i]==1) {
				tmp -= A[i+1];
			}else if(tmpArithmetic[i]==2) {
				tmp *= A[i+1];
			}else if(tmpArithmetic[i]==3) {
				tmp /= A[i+1];
			}
		}
		if(max<tmp) {
			max=tmp;
		}
		if(min>tmp) {
			min=tmp;
		}
		return;
	}
}
