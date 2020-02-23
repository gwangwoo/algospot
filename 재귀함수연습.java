package chap06;

import java.util.*;

public class 재귀함수연습 {
	
	static boolean visited[] = new boolean[6];
	
	static void pick(String str, int cnt) {
		if(cnt == 5) {
			System.out.println(str);
			return;
		}
		
		for(int i = 1 ; i <= 5 ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			pick(str+ i+ " " , cnt + 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		// 중복 순열
		pick("",0);
		
			
	}

}
