class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n=triangle.size();
        
        for(int i=n-2;i>=0;i--)
        {
            // List<Integer> temp = triangle.get(i+1);
            // List<Integer> cur=triangle.get(i);
            for(int j=0;j<triangle.get(i).size();j++)
            {
                
                int t1=triangle.get(i).get(j)+triangle.get(i+1).get(j);
                int t2=triangle.get(i).get(j)+triangle.get(i+1).get(j+1);
                // System.out.print(t1+" "+t2+"--");
                int f=Math.min(t1,t2);

                 triangle.get(i).set(j, f);
            }

            System.out.println();
        }

        return triangle.get(0).get(0);
        
    }
}