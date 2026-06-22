class Solution {
    public int maxNumberOfBalloons(String text) {

        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;

        for(int i=0;i<text.length();i++)
        {
            char ch=text.charAt(i);
            if(ch=='b')
            b++;
            else if(ch=='a')
            a++;
            else if(ch=='l')
            l++;
            else if(ch=='o')
            o++;
            else if(ch=='n')
            n++;
        }

        int c=0;

        while(true)
        {
            b--;
            a--;
            l-=2;
            o-=2;
            n--;

            if(b>=0 && a>=0 && l>=0 && o>=0 && n>=0)
            c++;
            else 
            break;
        }

        return c;
        
    }
}