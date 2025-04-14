import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {


    private static int maxProdOfSubArray (int[] array, int n) {

        int forPositiveEndingHere = 1;
        int forNegativeEndingHere = 1;
        int maxResult = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] > 0) {
                forPositiveEndingHere *= array[i];
                forNegativeEndingHere = Math.min (1, forNegativeEndingHere*array[i]);
            }
            else if (array[i] < 0) {
                int temp = forPositiveEndingHere;
                forPositiveEndingHere = Math.max (1, forNegativeEndingHere*array[i]);
                forNegativeEndingHere = temp*array[i];
            }
            else if (array[i] == 0) {
                forPositiveEndingHere = 1;
                forNegativeEndingHere = 0;
            }
            if (maxResult < forPositiveEndingHere) {
                maxResult = forPositiveEndingHere;
            }
        }
        
        return maxResult;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("testcases/1.txt"));
            int numberOfTestCase = sc.nextInt();
            while (numberOfTestCase-- > 0) {
                int N = sc.nextInt();
                int[] array = new int[N];
                System.out.println("N=" + N );
                for (int i = 0; i < N; ++i) {
                    array[i] = sc.nextInt();
                    System.out.print(array[i] + " ");
                }
                System.out.println("\noutput : " + maxProdOfSubArray(array, N));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not exist : " + e);
        }
    }

}