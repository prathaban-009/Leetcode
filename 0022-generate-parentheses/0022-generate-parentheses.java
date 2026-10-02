class Solution {
    List<String> result=new ArrayList<>();
    int n;

    public boolean isValid(String s) {

        Stack<Character > st = new Stack<>();

        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='(' || ch[i]=='{' || ch[i]=='[')
            st.push(ch[i]);
            else 
            {
                if(st.isEmpty())return false;
                char tc=ch[i];
                char sc=st.pop();
                if( (tc==')' && sc!='(')   ||  
                    (tc==']' && sc!='[')   || 
                    (tc=='}' && sc!='{')  )
                        return false;
 
            }
        }
        
        return st.isEmpty();
    }
    public void generate(StringBuilder sb) 
    {
        
        if(sb.length()==2*n)
        {
            System.out.println(sb.toString());
            String temp=sb.toString();
            //is valid logic need build
            if(isValid(sb.toString()))
            result.add(temp);
            return;
        }

       
            // st.push(')');
            sb.append(")");
            // System.out.println(sb.toString());
            generate(sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append("(");
            // st.push('(');
            generate(sb);
             sb.deleteCharAt(sb.length() - 1);
    }
    public List<String> generateParenthesis(int l) {

        n=l;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        generate(sb);
        return result;        
    }
}