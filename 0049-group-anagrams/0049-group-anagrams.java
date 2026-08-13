class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();

        for(String word : strs )
        {
            char ch[] = word.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(word);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> pair: map.entrySet())
        {
            List<String> group=pair.getValue();
            ans.add(group);
        }

        return ans;
        
    }
}