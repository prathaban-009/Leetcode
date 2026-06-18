class Solution {
    public double angleClock(int hour, int minutes) {
        
        
        double hrs=30*hour+0.5*minutes;
        double mins=6*minutes;

        double angle=Math.abs(hrs-mins);
        return Math.min(angle,360-angle);
    }
}