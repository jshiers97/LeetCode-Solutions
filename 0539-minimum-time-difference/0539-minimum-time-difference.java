class Solution {
    List<String> timePoints;
    int minimum; 
    public int findMinDifference(List<String> timePoints) {
        this.timePoints=timePoints;
        //sort the List by hour. If same hour, sort by minute
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
        
        //compare two values next to each other in the sorted list
        for(int i=1; i<timePoints.size(); i++){
              check(i-1, i);   

        }
        //We compared all possible minimum differences EXCEPT the first and last values. They could possibly
        // have the minimum difference time between them. 
        check(0, timePoints.size()-1); 
        
        return minimum;
    }
    //This method checks the differences between the times
    public void check(int i, int j){
        String str1=timePoints.get(i);
        String str2=timePoints.get(j);
        //get the value of the hours
        int h1=Integer.parseInt(str1.split(":")[0]);
        int h2=Integer.parseInt(str2.split(":")[0]);
        //get the value of the minutes
        int m1=Integer.parseInt(str1.split(":")[1]);
        int m2=Integer.parseInt(str2.split(":")[1]);
        int hourDiff;
        int minDiff;
        
        //if they are closer in time by going from the first time's hour up to the second time's hour,
        //enter this if block
        if((h2-h1)%24  <   24 -(h2-h1)){ //BLOCK 1: Count forward block

            hourDiff=(h2-h1)%24 ;
            //if second time's minutes is larger than first, just subtract to get the difference.
            if(m2>=m1){
                minDiff=m2-m1;
            }
            //otherwise, we have an extra hour between the two that needs to be subtracted. Then find the difference
            // in minutes. for example, 1:13 to 3:12 doesn't have 2 full hours between them, so we would subtract an hour
            // that we previously calculated as 2. Then we calculate the difference in minutes. In the example case, it 
            // would be a difference of 59 minutes, so we would have a difference of 1 hour and 59 minutes vs 2 hours and 59
            // minutes. NOTE: This logic is reversed in Block 3. In Block 3, we are essentially counting backwards, so
            // if m2>m1, THEN we would subtract an hour from what we calculated, then calculate the differnce in minutes.
            else{
                hourDiff--;
                minDiff=60- (m1-m2);
            }
        }
        //if the difference between the two times' hours are even (i.e., 12 hour difference) enter this block
        else if((h2-h1) == 24-(h2-h1)){ // BLOCK 2: Could count forward or backward, not sure yet
            hourDiff=12;
            
            if(m1>m2){
                hourDiff--;
                minDiff=60-(m1-m2);
            }
            else{
                minDiff=m2-m1;
            }
        }
        //if the difference between the hours is minimized by looping from the second time's hour to the first time's hour,
        // (e.g. from 23 to 0 rather than 0 to 23), then enter this block
        else{ // BLOCK 3: Count backward block. It is faster to get to time 1 by incrementing time 2

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