class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxWidth = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);
        int maxHeight = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
        
        for(int i = 1; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        
        for(int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i]-verticalCuts[i-1]);
        }
        
        return (int)((long)maxHeight * maxWidth % 1000000007); 
    }
}