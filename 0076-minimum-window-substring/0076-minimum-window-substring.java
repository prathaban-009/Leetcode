class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
        return "";

        HashMap<Character,Integer> map = new HashMap<>();
        int oc=0;
        for(char ch:t.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
            oc++;
        }

        int minLen=Integer.MAX_VALUE;
        String ans=s;

        int j=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char rightChar=s.charAt(i);
            if(map.containsKey(rightChar))
            {
                map.put(rightChar,map.get(rightChar)-1);
                if(map.get(rightChar)==0)
                count++;
            }

            while(j<=i && count==map.size())
            {
                if(i-j+1 <minLen)
                {
                    minLen=i-j+1;
                    ans=s.substring(j,i+1);
                }
                char leftChar = s.charAt(j);

                if(map.containsKey(leftChar))
                {
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(leftChar)>0)count--;
                }

                j++;
            }
        }

        if(minLen==Integer.MAX_VALUE)return "";
        return ans;
    }
}