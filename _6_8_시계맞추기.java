package chap06;

import java.io.*;
import java.util.*;
public class _6_8_시계맞추기 {
	static final int N = 16;
	static int map[];
	static int res;
	static int arr[][] = {
			//			0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5
			{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0},
			{0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1},
			{1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,1,1,0,1,0,1,0,0,0},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
			{0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1},
			{0,0,0,0,1,1,0,1,0,0,0,0,0,0,1,1},
			{0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0}
	};

	static void copy(int now[], int target[]) {
		for(int i = 0 ; i < N ; i++) {
			target[i] = now[i];
		}
	}


	static boolean isAnswer(int arr[]) {
		for(int i = 0 ; i < N ; i++) {
			if(arr[i] != 12) return false;
		}
		return true;
	}

	static void game(int map[], int cnt,int idx) {
		if(isAnswer(map)) {
			res = Math.min(cnt, res);
			return;
		}
		if(cnt > res) return;
		if(idx >= 10) return;
		int tmp[] = new int[N];
		copy(map,tmp);
		boolean flag = false;
		for(int j = 1 ; j <= 4 ; j++) {
			for(int k = 0 ; k < N ; k++) {
				tmp[k] += (arr[idx][k]*3);
				if(tmp[k] == 15) tmp[k] = 3;
			}
			if(j == 4) {
				game(tmp,cnt,idx+1);
			}else game(tmp,cnt+j,idx+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			res = (int)1e9;
			map = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			game(map,0,0);
			if(res == (int)1e9) System.out.println(-1);
			else System.out.println(res);
		}

	}

}
