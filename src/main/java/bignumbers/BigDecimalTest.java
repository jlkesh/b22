package bignumbers;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        double a = 2.312312312321321321323243253453434534543;
        double b = 1.2;
        // System.out.println(a - b);
        BigDecimal bigA = new BigDecimal("2.312312312321321321323243253453434534543");// BigDecimal.valueOf(a); // new BigDecimal(a);
        BigDecimal bigB = new BigDecimal("1.2");// BigDecimal.valueOf(b); // new BigDecimal(b);
        BigDecimal add = bigA.subtract(bigB);
        System.out.println("add = " + add);
    }
}
