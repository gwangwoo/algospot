package chap06;

import java.io.*;
import java.util.*;
public class _6_4_소풍 {
	static int arr[][];
	static int N,M;
	static boolean visited[];
	static boolean check(int[] sel) {

		for(int i = 0 ; i < N ; i+=2) {
			if(arr[sel[i]][sel[i+1]] != 1) return false;
			if(arr[sel[i+1]][sel[i]] != 1) return false;
		}
		return true;
	}


	static int go(int idx, int sel[],int cnt) {
		int val = 0;
		if(cnt == N) {
			if(check(sel)) return 1;
			return 0;
		}
		if(idx >= N) return 0; 
		for(int i = 1 ; i < N ; i++) {
			if(visited[i]) continue;
			if(idx % 2 == 1) {
				if(sel[idx-1] > i) continue;
				visited[i] = true;
				sel[idx] = i;
				val += go(idx+1,sel,cnt+1);
				visited[i] = false;
			}else {
				if(sel[idx-2] > i) continue;
				visited[i] = true;
				sel[idx] = i;
				val += go(idx+1,sel,cnt+1);
				visited[i] = false;
			}
		}

		return val;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[u][v] = 1;
				arr[v][u] = 1;
			}
			int sel[] = new int[N];
			sel[0] = 0;
			int div = 1;
			System.out.println(go(1,sel,1));
		}
	}
}