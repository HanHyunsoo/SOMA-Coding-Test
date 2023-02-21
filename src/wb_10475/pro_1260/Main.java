package pro_1260;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int n) {
        visited[n] = true;
        sb.append(n).append(' ');

        for (int i = 1; i <= N; i++) {
            if (graph[n][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;

        q.add(n);

        while (!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp).append(' ');

            for (int i = 1; i <= N; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[N + 1];

        dfs(V);
        sb.append('\n');

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }
}
