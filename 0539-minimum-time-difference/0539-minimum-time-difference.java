class Solution {
    List<String> timePoints;
    int minimum; 
    public int findMinDifference(List<String> timePoints) {
        this.timePoints=timePoints;
        Collections.sort(timePoints, new Comparator<String>(){
            @Override
            public int compare(String x, String y){
                Integer h1=Integer.parseInt(x.split(":")[0]);
                Integer h2=Integer.parseInt(y.split(":")[0]);
                int hour=h1.compareTo(h2); 
           
                if(hour!=0){
                    return hour;
                }
                else{
                    Integer m1=Integer.parseInt(x.split(":")[1]);
                    Integer m2=Integer.parseInt(y.split(":")[1]);
                    int min=m1.compareTo(m2); 
                    return min;
                }
                
            }
            
        });
      
        this.minimum=Integer.MAX_VALUE;
        for(int i=1; i<timePoints.size(); i++){
            
              check(i-1, i);   
            
            
        }
        check(0, timePoints.size()-1); 
        
        return minimum;
    }
    public void check(int i, int j){
        String str1=timePoints.get(i);
                String str2=timePoints.get(j);
                int h1=Integer.parseInt(str1.split(":")[0]);
                int h2=Integer.parseInt(str2.split(":")[0]);
                
                int m1=Integer.parseInt(str1.split(":")[1]);
                int m2=Integer.parseInt(str2.split(":")[1]);
                int hourDiff;
                int minDiff;
                if((h2-h1)%24  <   24 -(h2-h1)){
                    
                    hourDiff=(h2-h1)%24 ;
                    
                    if(m2>=m1){
                        minDiff=m2-m1;
                    }
                    else{
                        hourDiff--;
                        minDiff=60- (m1-m2);
                    }
                }
                else if((h2-h1) == 24-(h2-h1)){
                    hourDiff=12;
                    if(m1>m2){
                        hourDiff--;
                        minDiff=60-(m1-m2);
                    }
                    else{
                        minDiff=m2-m1;
                    }
                }
                else{
                   
                    hourDiff= 24 -(h2-h1);
                  
                    if(m2>m1){
                        hourDiff--;
                        minDiff=60-(m2-m1);
                    }
                    else{
                       
                        minDiff=m1-m2;
                    }
                }

             
                minDiff+= (hourDiff*60);
                minimum=Math.min(minimum, minDiff); 
    }
}