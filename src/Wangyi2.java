import java.util.Scanner;

/**
 * Created by oubin on 17-3-25.
 */
public class Wangyi2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean first = true;
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String[] nums = str1.split(" ");
        int numSize = Integer.valueOf(nums[0]);
        int time = Integer.valueOf(nums[1]);
        String[] initStrs = str2.split(" ");
        int[] initNums = new int[numSize];
        for (int i = 0; i < initStrs.length; i++){
            initNums[i] = Integer.valueOf(initStrs[i]);
        }
        System.out.println(compute(time, initNums));
    }

    public static int[] compute(int time, int[] initNums){
        int next = 0;
        for (int i = 0; i < time; i++){
            for (int j = 0; j < initNums.length; j++){
                if (j == initNums.length - 1) next = 0;
                else next = j + 1;
                initNums[j] = initNums[j] + initNums[next];
                if (initNums[j] >= 100) initNums[j] = initNums[j] % 100;
            }
        }
        return initNums;
    }

}
