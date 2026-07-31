class Solution {
    public int minimumPushes(String word) {

        int freq[]=new int [26];

        for(char ch :word.toCharArray())
        {
            freq[ch-'a']++;
        }
        
        Arrays.sort(freq);

        int ans=0;
        int pos=1;
        int cr=0;
     
        for(int i=freq.length-1;i>=0;i--)
        {
            if(freq[i]!=0)
            {
                ans+=freq[i]*pos;
                // System.out.println(freq[i]*pos);
            }else break;

            cr++;

            if(cr%8==0)
            {
                pos++;
                // System.out.println("Incrt:"+pos);
            }
        }

        return ans;
    }
}