class Solution {
    List<String> result ;
    int l;

    private boolean isValid(StringBuilder sb)
    {
        char arr[]=sb.toString().toCharArray();
        Stack<Character> st = new Stack<>();

        for(char ch :arr)
        {
            if(ch=='(')
            st.push(ch);
            else{
                if(st.isEmpty())return false;
                
                char pop=st.pop();
                if(pop!='(' && ch==')')
                return false;
            }
        }

        return st.isEmpty();
    }
    private void generate(StringBuilder sb)
    {
        if(sb.length()==l*2)
        {
            // System.out.println(sb.toString());
            if(isValid(sb))
            result.add(sb.toString());
            return;
        }

        sb.append(")");
        generate(sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("(");
        generate(sb);
        sb.deleteCharAt(sb.length()-1);

    }
    public List<String> generateParenthesis(int n) {
        l=n;
        result= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        generate(sb);
        return result;
    }
}