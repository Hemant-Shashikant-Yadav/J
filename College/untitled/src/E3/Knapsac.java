package CollegeDAA.E3;

import java.util.Arrays;

public class Knapsac {
    public static void main(String args[]) {
        int n = 5;
        int v[] = {3, 3, 2, 5, 1};
        int w[] = {10, 15, 10, 12, 8};
        int W = 10, A = W;

        float[][] ValWtRatio = new float[5][2];
        for (int i = 0; i < n; i++) {
            ValWtRatio[i][0] = ((float) w[i] / (float) v[i]);
            ValWtRatio[i][1] = i;
        }

        Arrays.sort(ValWtRatio, (a, b) -> Float.compare(a[0], b[0]));

        int m =n-1;
        int currwt = 0;
        float curval = 0;
        while (A > 0) {
            if (currwt + v[(int) ValWtRatio[m][1]] <= W) {
                currwt += v[(int) ValWtRatio[m][1]];
                curval += w[(int) ValWtRatio[m][1]];
                A -= v[(int) ValWtRatio[m][1]];
            } else {
                int remain = (W - currwt);
                curval +=  w[(int) ValWtRatio[m][1]] *( (float)remain/v[(int) ValWtRatio[m][1]]);
                break;
            }
            m--;
        }
        System.out.println("Maximum value = "+curval);
    }
}
