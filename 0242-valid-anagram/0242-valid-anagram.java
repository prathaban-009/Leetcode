class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m){
            return false;
        }
        int[] arr=new int[126];
        int[] arr_1=new int[126];
        for(int i=0;i<n;i++){
            int num=s.charAt(i)-'A';
            arr[num]++;
        }
        for(int j=0;j<m;j++){
            int num=t.charAt(j)-'A';
            arr_1[num]++;

        }
        if(Arrays.equals(arr,arr_1)){
            return true;
        }
        return false;

    }
}