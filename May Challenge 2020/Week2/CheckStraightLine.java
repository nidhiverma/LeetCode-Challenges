class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) {
            return true;
        }
        double m1 = slope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        
        for(int i = 2; i < coordinates.length; i++) {
            double m2 = slope(coordinates[i-1][0], coordinates[i-1][1], coordinates[i][0], coordinates[i][1]);
            if(m2 != m1) {
                return false;
            }
            m1 = m2;
        }
        return true;
    }
    
    private double slope(int x1, int y1, int x2, int y2) {
        if(x2 - x1 == 0) {
            return Integer.MIN_VALUE;
        }
        return (y2-y1)/(double)(x2-x1);
    }
}
