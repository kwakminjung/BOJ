/*
백준 30023번 : 전구 상태 바꾸기 (골드5)
알고리즘 분류 : 구현, 그리디 알고리즘
풀이 : 
결과 : 메모리초과
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        String light;
        int cnt;

        Node(String light, int cnt) {
            this.light = light;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        light = br.readLine();
        origin = light;
        
        BFS(light, 0);
        
        System.out.println(ans - 1);
    }
    
    static String origin;
    static String light;
    static int ans = 0;
    static int n;
    
    public static void BFS(String pre, int cnt) {
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new Node(pre, cnt));
        visited.add(pre);
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            String light = current.light;
            cnt = current.cnt + 1;
            
            boolean allSame = true;
            for (int i = 0; i < light.length() - 1; i++) {
                if (light.charAt(i) != light.charAt(i + 1)) {
                    allSame = false;
                    break;
                }
            }

            if (allSame) {
                ans = cnt;
                return;
            }
            
            for (int i = 0; i <= light.length() - 3; i++) {
                String next = change(light, i);
                if (!visited.contains(next)) {
                    q.add(new Node(next, cnt));
                    visited.add(next);
                }
            }
        }
    }
    
    public static String change(String light, int idx) {
        char[] arr = light.toCharArray();
        for (int i = idx; i < idx + 3; i++) {
            switch (arr[i]) {
                case 'R':
                    arr[i] = 'G';
                    break;
                case 'G':
                    arr[i] = 'B';
                    break;
                case 'B':
                    arr[i] = 'R';
                    break;
            }
        }
        return new String(arr);
    }
}
