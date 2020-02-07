package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1224_계산기3_오정엽 {
	static String str;
	static int N;
	static Stack<Character> operatorStack = new Stack();
	static Stack<Character> result = new Stack();
	static Stack<String> oper = new Stack();
	static Object[] array;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1;tc<11;tc++) {
			st = new StringTokenizer(in.readLine());
			N= Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			str = st.nextToken();
			back();
			operate();
			System.out.println("#"+tc+" "+oper.pop());
		}
	}
	private static void back() {
		char tmp;
		for(int i=0; i<N;i++) {
			char c= str.charAt(i);		
			switch(c) {
			case '+':
				while(true) {
					tmp = operatorStack.lastElement();
					if(tmp=='*') {
						result.push(operatorStack.pop());
					}else {
						operatorStack.push(c);
						break;
					}
				}
				break;
			case '*':case '(':
				operatorStack.push(c);
				break;
			case ')':
				while(true) {
					tmp = operatorStack.pop();
					if(tmp=='(') {
						break;
					}else {
						result.push(tmp);
					}
				}
				break;
			default:
				result.push(c);
				break;
			}
		}
		
		array = result.toArray();
	}
	private static void operate() {
		String str;
		int a,b;
		for(int i=0; i<array.length;i++) {
			str = String.valueOf(array[i]);
			switch(str) {
			
			case "+":
				b=Integer.parseInt(oper.pop());
				a=Integer.parseInt(oper.pop());
				oper.push(Integer.toString(a+b));
				break;
			case "*":
				b=Integer.parseInt(oper.pop());
				a=Integer.parseInt(oper.pop());
				oper.push(Integer.toString(a*b));
				break;
			default: oper.push(str);
					break;
			}
		}
	}
}
