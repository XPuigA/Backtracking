package knight_tour_1;

class KnightTour {

    private static int N = 8;

    private final static int[] xMove = {  2, 1, -1, -2, -2, -1,  1,  2 };
    private final static int[] yMove = {  1, 2,  2,  1, -1, -2, -2, -1 };

    public static void main(String args[]) {
        N = Integer.parseInt(args[0]);
        int[][] sol = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sol[i][j] = -1;
            }
        }
        if (solve(sol)) System.out.print("YES");
        else System.out.print("NO");
    }

    private static boolean solve(int[][] sol) {
        sol[0][0] = 0;
        return solveRecursive(sol, 0, 0, 1);
    }

    private static boolean solveRecursive(int[][] sol, int x, int y, int numberOfMoves) {
        if (numberOfMoves == N * N) return true;
        for (int movesIterator = 0; movesIterator < N; ++movesIterator) {
            int newX = x + xMove[movesIterator];
            int newY = y + yMove[movesIterator];
            if (canMove(sol, newX, newY)) {
                sol[newX][newY] = numberOfMoves;
                if (solveRecursive(sol, newX, newY, numberOfMoves+1)) {
                    return true;
                } else {
                    sol[newX][newY] = -1;
                }
            }
        }
        return false;
    }

    private static boolean canMove(int[][] sol, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    private static void print(int[][] sol) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(sol[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}