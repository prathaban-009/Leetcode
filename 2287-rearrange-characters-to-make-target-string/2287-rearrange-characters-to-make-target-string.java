class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        HashMap<Character,Integer> ct= new HashMap<>();

        for(char ch : target.toCharArray())
        {
            ct.put(ch,ct.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> st= new HashMap<>();

        for(char ch:s.toCharArray())
        {
            st.put(ch,st.getOrDefault(ch,0)+1);
        }

        int ans=Integer.MAX_VALUE;

         for (char ch : ct.keySet()) {
            ans = Math.min(ans,
                    st.getOrDefault(ch, 0) / ct.get(ch));
        }
        

        return ans;
    }
}