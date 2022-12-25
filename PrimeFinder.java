import java.util.ArrayList;

public class PrimeFinder {
    public static void main(String[] args) {
        int limit = 100000;
        primeFinder(limit);
    }

    private static void primeFinder(int limit) {
        ArrayList<Integer>  primes = new ArrayList<Integer>();
        long start = System.nanoTime();
        int numberOfPrimes = 1;
        for (int idx = 0; idx < limit; idx++) {
            if ((idx == 0) || (idx == 1)) {
                continue;
            } else if (idx == 2) {
                continue;
            } else if (idx % 2 == 0) {
                continue;
            }

            if (candidateChecker(idx) > 0) {
                primes.add(idx);
                numberOfPrimes++;
            }
        }
        long end = System.nanoTime();
        System.out.println("\n---------------------------------------------------------------------");
        System.out.format("Number of Primes under %d: %d\n", limit, numberOfPrimes);
        double elapsedTimeInSeconds = (double) (end-start) / 1_000_000_000;
        System.out.format("Elpased Time %f seconds.\n", elapsedTimeInSeconds);
        System.out.format("Highest Prime %d\n", primes.get(primes.size() - 1));
        System.out.println("Number are:\n" + primes);
        System.out.println("---------------------------------------------------------------------\n");
    }

    private static int candidateChecker(int candidate) {
        for (int idxInner = 0; idxInner < candidate; idxInner++) {
            if (idxInner == 0 || idxInner == 1) {
                continue;
            } else if (candidate % idxInner == 0) {
                return 0;
            }
        }

        return candidate;
    }
}
