/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    public int findCelebrity(int n) {
        
        List<Integer> candidates=new ArrayList<>();
        for(int i=0; i<n; i++){
            candidates.add(i);
            
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if( i!=j && knows(i, j) ){
                    int ind=candidates.indexOf(i);
                   
                    if(ind > -1){
                        candidates.remove(ind);
                        break;
                    }
                    
                }
            }
        }
        
        List<Integer> output=new ArrayList<>();
        
        for(int candidate: candidates){
            output.add(candidate);
           
            for(int i=0; i<n; i++){
                if(i==candidate){
                    continue;
                }
                if(!knows(i, candidate)){
                    int indx=output.indexOf(candidate);
                    if(indx > -1){
                        output.remove(indx);
                        
                    }
                }
            }
            
        }
        if(output.size() > 0){
            return output.get(0);
        }
        return -1;
        
        
    }
}