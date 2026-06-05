class Solution {
    private static List<Integer> patterns = new ArrayList<>();
    
    static {
         
        
        for(int i=0;i<1000;i++)
        {
            int r=i%10;
            int c=(i/10)%10;
            int l=(i/100);

            if(c>Math.max(r,l) || c<Math.min(r,l))
            patterns.add(i);
        }
    }
    private long count(long num)
    {
        long count=0;

        for(int pattern:patterns)
        {
            count+=countPatternOccurrences(num,pattern);
        }

        return count;
    }

    private long countPatternOccurrences(long limit,int pattern)
    {
        long count=0;
        long mult=1;
        long type = (pattern < 100) ? 1 : 0;

        for(int i=0;i<16;i++)
        {
            if(mult * 100 > limit)
            break;

            long first=(limit)/(mult*1000);
            long center=(limit/mult)%1000;
            long edje=(limit % mult);
            
            long ways = 0;
            long edgeContribution = 0;

            if(center>pattern)
            {
                ways=first-type+1;

            }else if(center==pattern)
            {
                 ways = Math.max(0L, first- type);

                if (first >= type) {
                    edgeContribution = edje+ 1;
                }

            }else
            {
                ways = Math.max(0L, first - type);
            }

            long contribution = ways * mult + edgeContribution;
            count+=contribution;
            mult*=10;
        }

        return count;
    }
    public long totalWaviness(long num1, long num2) {
        return count(num2)-count(num1-1);
    }
}