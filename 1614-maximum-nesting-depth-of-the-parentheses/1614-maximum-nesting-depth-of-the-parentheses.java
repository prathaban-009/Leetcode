class Solution {
    public int maxDepth(String s) {

        Stack<Character> st = new Stack<>();

        int max=-1;

        for(char ch : s.toCharArray())
        {
            if(ch=='(')
            st.push(ch);
            else if(!st.isEmpty() && ch==')')
            st.pop();

            max=Math.max(st.size(),max);
        }

        return max;
        
    }
}