class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
               
        int mod = n % 14;
        if(mod == 0) {
            mod = 14;
        }
        while(mod > 0) {
            int[] copy = new int[cells.length];
            copy[0] = copy[cells.length-1] = 0;

            for(int i = 1; i < cells.length-1; i++) {
                if(cells[i-1] == cells[i+1])
                    copy[i] = 1;
                else 
                    copy[i] = 0;
            }
            
            cells = copy;
            mod--;
        }
        
        return cells;
    }
}