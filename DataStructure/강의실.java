/*
백준 1374번 : 강의실 (골드5)
알고리즘 분류 : 자료 구조, 그리디 알고리즘, 정렬, 우선순위 큐
풀이 : https://cuckoobird.tistory.com/89

결과 : 맞았습니다 (메모리 63712KB | 시간 768ms | 코드 길이 1206B)

메모 :
java.util.PriorityQueue - 우선순위 큐 사용 방법 숙지하기
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] N_arr;

        int[][] lecture = new int[N][3];

        // 강의 정보 입력
        for (int i = 0; i < N; i++) {
            N_arr = br.readLine().split(" ");

            lecture[i][0] = Integer.parseInt(N_arr[0]);
            lecture[i][1] = Integer.parseInt(N_arr[1]);
            lecture[i][2] = Integer.parseInt(N_arr[2]);
        }

        Arrays.sort(lecture, Comparator.comparingInt(o1 -> o1[1]));

        PriorityQueue<Integer> room = new PriorityQueue<>();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            if (!room.isEmpty() && room.peek() <= lecture[i][1]) {
                room.poll();
            } else {
                ans++;
            }
            room.offer(lecture[i][2]);
        }

        bw.write(Integer.toString(ans));

        bw.flush();
        br.close();
        bw.close();
    }
}
