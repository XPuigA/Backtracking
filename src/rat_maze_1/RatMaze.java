package rat_maze_1;

import java.util.Scanner;

public class RatMaze {

    private static int N = 8;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        char[][] sol = new char[N][N];
        for (int i = 0; i < N; ++i) {
            sol[i] = in.next().toCharArray();
        }
        Solution solution = solve(sol);
        if (solution.ok) {
            print(solution.array);
        }
        else System.out.print("NO");
    }

    private static boolean canMove(char[][] sol, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == '1');
    }

    static Solution solve(char[][] sol) {
        return solveRecursive(sol, 0, 0);
    }

    static Solution solveRecursive(char[][] sol, int x, int y) {
        Solution s;
        if (x == N-1 && y == N-1) {
            sol[x][y] = '2';
            return new Solution(sol);
        }
        if (canMove(sol, x, y)) {
            char old = sol[x][y];
            sol[x][y] = '2';
            s = solveRecursive(sol, x+1, y);
            if (s.ok) return s;
            s = solveRecursive(sol, x, y+1);
            if (s.ok) return s;
            sol[x][y] = old;

        }
        return new Solution();
    }

    private static void print(char[][] sol) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(sol[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}

class Solution {
    boolean ok = false;
    char[][] array;

    Solution() {}
    Solution(char[][] array) {
        ok = true;
        this.array = array;
    }

}