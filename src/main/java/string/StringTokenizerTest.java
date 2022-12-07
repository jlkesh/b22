package string;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    /**
     * @link {https://docs.oracle.com/javase/tutorial/java/data/characters.html}
     * @param args
     */
    public static void main(String[] args) {

        /*StringTokenizer stringTokenizer = new StringTokenizer("Hello Me melll nellle e o", "e" );
        StringTokenizer stringTokenizer = new StringTokenizer("Hello Me melll nellle e o", "e" );
        int tokens = stringTokenizer.countTokens();
        System.out.println("tokens = " + tokens);
        while (stringTokenizer.hasMoreTokens()) {
          System.out.println(stringTokenizer.nextToken());
        }
        */

        String string = new String("Hello Me melll nellle e o");
        String[] es = string.split("e");
        for (String e : es) {
            System.out.println("e = " + e);
        }


    }
}
