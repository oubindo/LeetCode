import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class WangYi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String seq = in.nextLine();
        System.out.println(compute(seq));

    }

    public static int compute(String seq){
        if (seq == null || seq.equals("")) return 0;
        char[] chars = seq.toCharArray();
        List<Integer> numsList = new LinkedList<>();
        List<Character> operList = new LinkedList<>();
        for (char c : chars){
            if (c == '+' || c == '-' || c == '*'){
                operList.add(c);
            }else {
                numsList.add(c - '0');
            }
        }
        while (!operList.isEmpty()){
            char c = operList.get(0);
            int num1 = numsList.get(0);
            int num2 = numsList.get(1);
            int result = 0;
            switch (c){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                default:
                    break;
            }
            numsList.remove(0);
            numsList.remove(0);
            numsList.add(0, result);
            operList.remove(0);
        }
        return numsList.get(0);
    }

}
