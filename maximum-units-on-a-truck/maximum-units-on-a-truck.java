class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if(truckSize == 0) return 0;
        
        Arrays.sort(boxTypes, (a,b)-> b[1]-a[1]);
        
        int totalUnits = 0;
        
        for(int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int boxes = boxTypes[i][0];
            int units = boxTypes[i][1];
            
            totalUnits += Math.min(boxes, truckSize) * units;
            truckSize -= boxes;
        }
        
        return totalUnits;
    }
}  