import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class asdasd {

    static int dir [][] = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    static class Point{
        int i;
        int j;
        int day;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
            this.day = 0;
        }

        public Point(int i, int j, int day) {
            this.i = i;
            this.j = j;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        Deque<Point> dq = new LinkedList<>();


        // 2차원 배열 생성
        int[][] map = new int[M + 2][N + 2];

        for (int i = 1; i <= M; i++) {
            int cnt = 1;
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N ; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 1)
                    dq.add(new Point(i,j));
            }
        }

        for (int i = 0; i < M+2; i++) {
            map[i][N+1] = 9;
            map[i][0] = 9;
        }
        for (int j = 0; j < N+2; j++) {
            map[0][j] = 9;
            map[M+1][j] = 9;
        }


        // 첫빠따로
        // 1인거 전수조사해서 큐에 넣자
        // visited 하나 만들어서 체크해서 넣을려고했는데
        // 사실 0인거만 넣으면 될거 같아서 visited 없어도 될듯

        // 1. 하나 꺼냄
        // 2. 양방향 0인거 다 넣음
        // 3. 끝

        int count = 0;
        while(!dq.isEmpty()) {
            Point pop = dq.pop();
            count = pop.day;
            for (int n = 0; n < 4; n++) {
                int i = pop.i + dir[n][0];
                int j = pop.j + dir[n][1];

                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dq.add(new Point(i, j, pop.day + 1));
                }
            }
        }
        // 만약 남아있으면 0
bp1:     for (int i = 1; i <= M ; i++) {
            for (int j = 1; j <= N ; j++) {
                if(map[i][j] == 0) {
                    count = -1;
                    break bp1;
                }
            }
        }
        System.out.println(count);

        // 1인거 다 큐에 넣고
        // 양방향 다 큐에 넣고 다 1로 만들기 (넣고 1, 1하고 넣) 생각해보기

    }
}
