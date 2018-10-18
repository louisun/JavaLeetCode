import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Solution {


    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        char[] charArray = digits.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            while (list.getFirst().length() == i) {
                String pop = list.removeFirst();
                for (char v : map[c - '2'].toCharArray()) {
                    list.add(pop + v);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("234567"));
    }
}
