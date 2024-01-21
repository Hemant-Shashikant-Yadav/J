package E5;

public class TSproblemDP {
    static int n = 5;
    static int MAX = Integer.MAX_VALUE;

    static int[][] dist = {
            {0, 0, 0, 0, 0, 0}, {0, 0, 2, 9, 10, 4},
            {0, 1, 0, 6, 4, 2},
            {0, 15, 7, 0, 8, 6},
            {0, 6, 3, 2, 0, 1},
            {0, 2, 8, 7, 14, 0}
    };

    static int[][] memo = new int[n + 1][1 << (n + 1)];

    static int fun(int i, int mask) {
        if (mask == ((1 << i) | 1))
            return dist[1][i];
        if (memo[i][mask] != 0)
            return memo[i][mask];

        int res = MAX;

        for (int j = 1; j <= n; j++)
            if ((mask & (1 << j)) != 0 && j != i && j != 1)
                res = Math.min(res,
                        fun(j, mask & (~(1 << i)))
                                + dist[j][i]);

        return memo[i][mask] = res;
    }

    public static void main(String[] args) {
        int ans = MAX;
        for (int i = 1; i <= n; i++)
            ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1) + dist[i][1]);

        System.out.println("The cost of the most efficient tour = " + ans);
    }
}
