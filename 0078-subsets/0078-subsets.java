class Solution {
     List<List<Integer>> result;
     
    private void generate(List<Integer> arr,int[] nums,int start)
    {
        
        result.add(new ArrayList<>(arr) );
        for(int i=start;i<nums.length;i++)
        {
             if (i > start && nums[i] == nums[i- 1]) {
                continue;
            }

            arr.add(nums[i]);
            System.out.println(arr);
            generate(arr,nums,i+1);
            arr.remove(arr.size()-1);
            
        }
        

    }
    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();
        generate(new ArrayList<>(),nums,0);
        return result;
        
    }
}