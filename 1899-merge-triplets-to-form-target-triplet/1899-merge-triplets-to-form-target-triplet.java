class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        if(triplets.length==1){
           boolean same=true;
            for(int x=0; x<3; x++){
                if(triplets[0][x]!=target[x]){
                    same=false;
                }
            }
            return same;
        }
        List<int[] > list=new ArrayList<>();
        for(int[] triplet: triplets){
            boolean use=true;
            for(int i=0; i<3; i++){
                if(triplet[i] > target[i]){
                    use=false;
                }
            }
            if(use){
                list.add(triplet); 
            }
        }
        for(int i=0; i<list.size(); i++){
            int[] first=list.get(i);
            for(int j=i+1; j<list.size(); j++){
                int[] second=list.get(j);
                first=mult(first, second); 
                boolean same=true;
                for(int x=0; x<3; x++){
                    if(first[x]!=target[x]){
                        same=false;
                    }
                }
                if(same){
                    return true; 
                }
                
            }
            
        }
        return false;
        
    }
    public int[] mult(int[] arr1, int[] arr2){
        for(int i=0; i<3; i++){
            arr1[i]=Math.max(arr1[i], arr2[i]);
        }
        return arr1; 
    }
}