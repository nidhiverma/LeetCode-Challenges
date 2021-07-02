/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/*
    @author: Nidhi
    
    Approach: 
        to check if i is a celebrity or not, check if there exists any person whom i knows
        eg know(0, 1) == true, it implies
            0 is definitely not a celebrity since he knows 1 
            but can we say the same about 1? No, so 1 has become the next possible celebrity
            
            we'll know our possible celebrity in a single pass
            
            next we need to check if 
            1) our possible celebrity is known by any of the n-1 people 
            2) possible celebrity  knows any of the n-1 people
            
            if any of the two conditions is satisfied, then there's no celebrity
            otherwise, celebrity = possbleCelebrity
            
            Time Complexity: O(n)
            Space Complexity: O(1)
*/


public class Solution extends Relation {
    public int findCelebrity(int n) {
        int possibleCelebrity = 0;
        
        for(int i = 1; i < n; i++) {
            if(knows(possibleCelebrity, i)) {
                possibleCelebrity = i;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(possibleCelebrity == i) continue;
            
            if(!knows(i, possibleCelebrity) || knows(possibleCelebrity, i)) return -1;
        }
        return possibleCelebrity;
    }
}