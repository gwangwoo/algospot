package chap06;

import java.io.*;
import java.util.*;

public class _6_3_보글게임 {
	static int M;
	static final int N = 5;
	static char map[][];
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	
	static boolean bfs(int sr,int sc, String str) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr,sc,1));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int idx = p.idx;

			if(idx == str.length()) return true;
			if(idx > str.length()) continue;
			
			
			for(int k = 0 ; k < 8 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != str.charAt(idx)) continue;
				q.add(new Point(nr,nc,idx+1));
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M ; i++) {
			String str = br.readLine();
			boolean flag = false;
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0; c < N ; c++) {
					if(map[r][c] != str.charAt(0)) continue;
					flag = bfs(r,c,str);
					if(flag) break;
				}
				if(flag) break;
			}
			if(flag) System.out.println(str + " YES");
			else System.out.println(str + " NO");
		}
	}
	static class Point {
		int r,c,idx;
		Point(int r,int c,int idx) {
			this.r = r;
			this.c = c;
			this.idx = idx;
		}
	}
}
