class Solution {
    public int numberOfSubstrings(String s) {
        int a=0;
        int b=0;
        int c=0;
        int n=s.length();
        int j=0;
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='a')a++;
            if(ch=='b')b++;
            if(ch=='c')c++;

            while (a > 0 && b > 0 && c > 0)
            {
                ans+=(n-i);
                char left = s.charAt(j);

                if (left == 'a') a--;
                else if (left == 'b') b--;
                else c--;

                j++;
            }

        }

        return ans;
        
    }
}