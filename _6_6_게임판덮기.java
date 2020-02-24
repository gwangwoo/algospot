package chap06;

import java.io.*;
import java.util.*;

public class _6_6_게임판덮기 {
	static int N,M;
	static int dr[][] = {{0,0,1},{0,1,1},{0,0,1},{0,1,1}};
	static int dc[][] = {{0,1,0},{0,0,-1},{0,1,1},{0,0,1}};
	static int res;

	static void print(char map[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


	static void go(char map[][], int pane) {
		// 4가지 case 되는지 확인해야함.
		if(pane == 0) {
//			print(map);
			res++;
			return;
		}
		char tmp[][] = new char[N][M];
		boolean flag = false;
		int r = -1, c = -1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] != '.') continue;
				r = i;
				c = j;
				flag = true;
				break;
			}
			if(flag) break;
		}

		if(flag) {
			NEXT:
			for(int k = 0 ; k < 4 ; k++) {
				for(int l = 0 ; l < 3 ; l++) {
					int nr = r + dr[k][l];
					int nc = c + dc[k][l];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != '.') continue NEXT; 
				}
				copy(map,tmp);
				for(int l = 0 ; l < 3 ; l++) {
					int nr = r + dr[k][l];
					int nc = c + dc[k][l];
					tmp[nr][nc] = '1';
				}
//				print(tmp);
				go(tmp,pane-1);
			}
		}
	}


	static void copy(char now[][] , char target[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j =0  ; j < M ; j++) {
				target[i][j] = now[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			res = 0;
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char map[][] = new char[N][M];
			int r = -1,c = -1;
			boolean flag = false;
			for(int i = 0 ; i < N ; i++) {
				String str = br.readLine();
				for(int j = 0 ; j < M ; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '.') {
						cnt++;
						if(!flag) {
							flag = true;
							r = i;
							c = j;
						}
					}
				}
			}
			if(cnt % 3 != 0) {
				System.out.println(0);
				continue;
			}
			int pane = cnt / 3;
			go(map,pane);
			System.out.println(res);
		}
	}
}

