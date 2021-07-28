class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> comparator = new Comparator<>() {
            public int compare(String a, String b) {
                String[] log1 = a.split(" ", 2);
                String[] log2 = b.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(log2[1].charAt(0));
                
                // both digit logs
                if(isDigit1 && isDigit2) {
                    return 0;
                }
                
                // both letter logs
                else if(!isDigit1 && !isDigit2) {
                    if(!log1[1].equals(log2[1])) {
                        return log1[1].compareTo(log2[1]);
                    }
                    // letter log with same content
                    return log1[0].compareTo(log2[0]);
                }
                
                // first is letter log and second is digit log
                else if(!isDigit1 && isDigit2) {
                    return -1;
                }
                // first is digit log and second is letter log
                else {
                    return 1;
                }
            }
        };
        
        Arrays.sort(logs, comparator);
        return logs;
    }
} 