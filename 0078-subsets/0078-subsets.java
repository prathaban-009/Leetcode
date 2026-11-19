class Solution {
     List<List<Integer>> result;
     
    private void generate(List<Integer> arr,int[] nums,int i)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(arr) );
            return;
        }

        arr.add(nums[i]);
        // System.out.println(arr);
        generate(arr,nums,i+1);
        arr.remove(arr.size()-1);
        generate(arr,nums,i+1);  

    }
    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();
        generate(new ArrayList<>(),nums,0);
        return result;
        
    }
}