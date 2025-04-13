import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    public static void main (String[] args) {
                    
        File file = new File("testcase/2.txt");
        if (file.exists()) {
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            }    
            catch (FileNotFoundException e) {
                sc.close();
                System.out.println("File Not Found");
                return;
            }
            int t = sc.nextInt();
            point[] coor = new point[t];
            int idxOfCoor = 0;
            while (t-- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                coor[idxOfCoor++] = new point(x, y);
            }
            sc.close();
            long result = Solution.closestPair(coor, idxOfCoor);
            System.out.println("Output: " + result);
        }    
    }

}
