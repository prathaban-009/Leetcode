class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        ArrayList<Integer> smaller=new ArrayList<>();
        ArrayList<Integer> equal=new ArrayList<>();
        ArrayList<Integer> greater=new ArrayList<>();

        for(int num:nums)
        {
            if(num<pivot)
            {
                smaller.add(num);
            }else if(num==pivot)
            {
                equal.add(num);
            }else
            {
                greater.add(num);
            }
        }

        int j=0;
        for(int i=0;i<smaller.size();i++)
        {
            nums[j++]=smaller.get(i);
        }
         for(int i=0;i<equal.size();i++)
        {
            nums[j++]=equal.get(i);

        } for(int i=0;i<greater.size();i++)
        {
            nums[j++]=greater.get(i);
        }

        return nums;
        
        
    }
}