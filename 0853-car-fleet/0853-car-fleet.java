class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack=new Stack<>(); 
        
        //first is position, second is speed
        List<int[]> list=new ArrayList<int[]>( );
        
        for(int i=0 ;i<speed.length; i++){
            list.add(new int[]{position[i], speed[i]});
            
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int[] y){
                Integer f=x[0];
                Integer g=y[0];
                return g.compareTo(f);
            }
        });
        
        int fleet=0;
        for(int i=0; i<list.size(); i++){
            int[] curr=list.get(i); 
            int currPos=curr[0];
            int currSpeed=curr[1];
            int remain=target - currPos; 
            double sec=(double)remain / currSpeed;
            System.out.println(sec);
            if(stack.isEmpty()){
                stack.push(sec);
                fleet++;
            }
            else if(sec > stack.peek()){
                stack.push(sec); 
                fleet++;
            }
            else{
                continue;
            }
        }
        return fleet;
        
    }
}