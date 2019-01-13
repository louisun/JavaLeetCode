import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(': stack.add('(');break;
                case '{': stack.add('{');break;
                case '[': stack.add('[');break;
                default: {
                    if(stack.empty()) return false;
                    if(c == ')') c = '(';
                    if(c == ']') c = '[';
                    if(c == '}') c = '{';
                    if(stack.peek() != c) return false;
                    else stack.pop();
                }
            }
        }
        if(stack.empty()) return true;
        else return false;
    }
}