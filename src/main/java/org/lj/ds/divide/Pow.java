package org.lj.ds.divide;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 50. Pow(x, n)
 * <p>
 * https://leetcode.com/problems/powx-n/ <br>
 * 
 * 1 ==> x=2, n=10, myPow(x * x, n / 2) ==> 1024 <br>
 * 2 ==> x=4, n=5, x * myPow(x, n - 1); 4 * 256 ==> 1024 <br>
 * 3 ==> x=4, n=4, myPow(x * x, n / 2) ==> 256 <br>
 * 4 ==> x=16, n=2, x * myPow(x, n - 1); 16 * 16 ==> 256 <br>
 * 5 ==> x=16, n=1, return 16 <br>
 */
@Slf4j
public class Pow {
    // for (int i = 0; i < 100_000; i++) {
    // log.info("{}", new Pow().myPowForce(x, 10));
    // }
    // log.info("cost:{}", System.currentTimeMillis() - start);

    // start = System.currentTimeMillis();
    // for (int i = 0; i < 100_000; i++) {
    // log.info("{}", new Pow().myPow(x, 10));
    // }
    // log.info("cost:{}", System.currentTimeMillis() - start);
    public static void main(String[] args) {
        // double x = new Random().nextDouble() * 10;
        double x = 2;
        log.info("{}", new Pow().myPowForce(x, 10));
        log.info("{}", new Pow().myPow(x, -15));
    }

    /**
     * 暴力法 时间复杂度O(N)
     */
    public double myPowForce(double x, int n) {
        double result = x;
        for (int i = 0; i < n - 1; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * 分治
     */
    private int level;

    public double myPow(double x, int n) {
        log.info("level:{}, x:{}, n:{}", ++level, x, n);

        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }

        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x * x, n / 2);
        }

    }
}
