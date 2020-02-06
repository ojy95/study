package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_5432_쇠막대기자르기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		Stack<Character> stack = new Stack<Character>();
		int N = Integer.parseInt(st.nextToken());
		char c;
		for (int tc = 1; tc < N+1; tc++) {
			int count=0;
			st = new StringTokenizer(in.readLine());
			String str = st.nextToken();
			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);
				switch (c) {
				case '(':
					if (str.charAt(i+1)==')') {
						count+=stack.size();
						i++;
					}else	stack.push(c);
					break;
				case ')':
					count++;
					stack.pop();
					break;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}

}
