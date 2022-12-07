package bignumbers;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bigInteger = factorial(100_000);
        System.out.println(bigInteger);
    }

    static BigInteger factorial(long n) {
        BigInteger r = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            r = r.multiply(new BigInteger(""+i));
        }
        return r;
    }
}
