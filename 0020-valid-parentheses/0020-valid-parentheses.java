class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else {
                if (st.size() == 0) return false;
                Character ch2 = st.pop();
                if (ch == ')' && ch2 != '(') return false;
                else if (ch == '}' && ch2 != '{') return false;
                else if (ch == ']' && ch2 != '[') return false;
            }
        }
        if (st.isEmpty()) return true;
        else return false;
    }
}