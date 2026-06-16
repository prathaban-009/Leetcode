class Solution {
    public String processStr(String s) {
        
        char arr[]=s.toCharArray();
        StringBuilder result = new StringBuilder();

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='#')
            {
                result.append(result.toString());

            }else if(arr[i]=='*')
            {
                if(result.length()>0)
                result.deleteCharAt(result.length()-1);
            }
            else if(arr[i]=='%')
            {
                result=result.reverse();
            }else
            {
                result.append(arr[i]);
            }
        }

        return result.toString();
    }
}