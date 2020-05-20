class Solution {
    
    public String removeKdigits(String num, int k) {
        if(k == 0) {
            return num;
        }
        if(num.length() <= k) {
            return "0";
        } 
        
        int offSet = 0;
        StringBuilder str = new StringBuilder("");
        
        int min = minIndex(num, k);
        while(min != -1 && k > 0) {
            if(min != 0) {
                k -= min;
                if(k == 0) {
                    str.append(num.substring(min+offSet));
                    break;
                }
            }
            min += offSet;
            offSet = min+1;
            str.append(num.charAt(min));
            min = minIndex(num.substring(min+1), k);
        }
        
        while(str.length() > 1 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }
        return str.toString();
    }
    
    private int minIndex(String s, int k) {
        if(s.length() <= k) {
            return -1;
        }
        int min = 0;
        for(int i = 1; i <= k; i++) {
            if(s.charAt(i) < s.charAt(min)) {
                min = i;
            }    
        }
        return min;
    }
}
