class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        
        StringBuilder ans = new StringBuilder();
        for(String word: words)
        {
            int s=0;
            for(int i=0;i<word.length();i++)
            {
                s=s+(weights[word.charAt(i)-'a']);
                // System.out.print(weights[word.charAt(i)-'a']+"+");
            }
            s=s%26;
            // System.out.print("="+s);

            // System.out.println("--->"+('z'-s) );
            ans.append(""+(char)('z'-s));
        }

        return ans.toString();
    }
}