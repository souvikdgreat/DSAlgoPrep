package gsPractice;

public class KnightProbability {
    public static double knightProbability(int N, int K, int r, int c) {
        return probability(N, K, r, c);
    }

    public static double probability(int N, int K, int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) return 0;
        if (K == 0) return 1;

        double prob = 0;

        int[] row = new int[]{2,1,-1,-2,-2,-1,1,2};
        int[] col = new int[]{1,2,2,1,-1,-2,-2,-1};

        for (int i=0;i<row.length;i++){
            prob += 0.125 * probability(N,K-1,r + row[i],c + col[i]);
        }

//        prob += 0.125 * probability(N, K - 1, r + 2, c + 1);
//        prob += 0.125 * probability(N, K - 1, r + 1, c + 2);
//        prob += 0.125 * probability(N, K - 1, r - 1, c + 2);
//        prob += 0.125 * probability(N, K - 1, r - 2, c + 1);
//        prob += 0.125 * probability(N, K - 1, r - 2, c - 1);
//        prob += 0.125 * probability(N, K - 1, r - 1, c - 2);
//        prob += 0.125 * probability(N, K - 1, r + 1, c - 2);
//        prob += 0.125 * probability(N, K - 1, r + 2, c - 1);
        return prob;
    }

    public static void main(String[] args) {
        int N = 5;
        int K = 2;
        int r = 2;
        int c = 2;

        double probability = knightProbability(N, K, r, c);
        System.out.println("Probability: " + probability);
    }


}

