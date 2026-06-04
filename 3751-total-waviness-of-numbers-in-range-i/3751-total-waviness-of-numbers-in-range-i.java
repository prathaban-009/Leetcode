class Solution {
    private int str;
    private int ans = 0;
    private int MAX_VALUE = 1_00_000;
    // private int dp[] = new int[MAX_VALUE];
    // private int prefix[] = new int[MAX_VALUE];

    void find() {

        int j = MAX_VALUE;

        for (int i = str; i <= MAX_VALUE; i++) {
            int wave = 0;

            if (i >= 100 && i < 1000) {
                int d1 = i / 100;
                int d2 = (i / 10) % 10;
                int d3 = (i % 10);

                if (d2 > d1 && d2 > d3)
                    wave++;
                if (d2 < d1 && d2 < d3)
                    wave++;

                ans += wave;
                // prefix[MAX_VALUE-100-i]=wave;

            } else if (i >= 1000 && i < 10_000) {
                int d1 = i / 1000;
                int d2 = (i / 100) % 10;
                int d3 = (i / 10) % 10;
                int d4 = (i % 10);

                if (d2 > d1 && d2 > d3)
                    wave++;
                if (d2 < d1 && d2 < d3)
                    wave++;

                if (d3 > d2 && d3 > d4)
                    wave++;
                if (d3 < d2 && d3 < d4)
                    wave++;

                ans += wave;
                // prefix[MAX_VALUE-100-i]=wave;

            } else if (i >= 10_000 && i < 1_00_000) {
                int d1 = i / 10_000;
                int d2 = (i / 1000) % 10;
                int d3 = (i / 100) % 10;
                int d4 = (i / 10) % 10;
                int d5 = (i % 10);

                if (d2 > d1 && d2 > d3)
                    wave++;
                if (d2 < d1 && d2 < d3)
                    wave++;

                if (d3 > d2 && d3 > d4)
                    wave++;
                if (d3 < d2 && d3 < d4)
                    wave++;

                if (d4 > d3 && d4 > d5)
                    wave++;
                if (d4 < d3 && d4 < d5)
                    wave++;

                ans += wave;
                // prefix[MAX_VALUE-100-i]=wave;

            } else if (i >= 1_00_000 && i <= MAX_VALUE) {
                int d1 = (i / 1_00_000);
                int d2 = (i / 10_000) % 10;
                int d3 = (i / 1000) % 10;
                int d4 = (i / 100) % 10;
                int d5 = (i / 10) % 10;
                int d6 = (i % 10);

                if (d2 > d1 && d2 > d3)
                    wave++;
                if (d2 < d1 && d2 < d3)
                    wave++;

                if (d3 > d2 && d3 > d4)
                    wave++;
                if (d3 < d2 && d3 < d4)
                    wave++;

                if (d4 > d3 && d4 > d5)
                    wave++;
                if (d4 < d3 && d4 < d5)
                    wave++;

                if (d5 > d4 && d5 > d6)
                    wave++;
                if (d5 < d4 && d5 < d6)
                    wave++;

                ans += wave;

            }
        }
    }

    public int totalWaviness(int num1, int num2) {

        if (num2 <= 99)
            return 0;
        str = num1;
        MAX_VALUE = num2;
        find();
        return ans;

    }
}