class Solution {
    public boolean checkValidString(String s) {
        int leftCount = 0, rightCount = 0;
     
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') leftCount++;
            else leftCount--;
            
            if(c != ')') rightCount++;
            else rightCount--;
          
            if(rightCount < 0) break;
            leftCount = Math.max(leftCount, 0);
        }
        
        return leftCount == 0;
    } 
}