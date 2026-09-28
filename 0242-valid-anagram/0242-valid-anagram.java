class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr=s.toCharArray();
        char[] arr_1=t.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr_1);
        if(Arrays.equals(arr,arr_1)){
            return true;
        }
        return false;
    }
}