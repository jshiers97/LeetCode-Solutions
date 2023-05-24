class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        //Stack<Integer> leftMoving=new Stack<>(); 
        List<Integer> output=new ArrayList<>();
        
        for(int i=0; i<asteroids.length; i++){
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
                
            }
            else{
                if(stack.isEmpty()){
                    output.add(asteroids[i]);
                }
                else{
                    while(!stack.isEmpty()){
                        int right=stack.pop();
                        if(Math.abs(asteroids[i])<right){
                            stack.push(right);
                            break;
                        }
                        else if(Math.abs(asteroids[i])==right){
                            break;
                        }
                        else{
                            if(stack.isEmpty()){
                                output.add(asteroids[i]);
                            }
                        }
                    }
                }
            }
        }
        List<Integer> temp=new ArrayList<>(); 
        while(!stack.isEmpty()){
            temp.add(stack.pop()); 
        }
        for(int i=temp.size()-1; i>=0; i--){
            output.add(temp.get(i)); 
        }
        int[] out=new int[output.size()];
        for(int i=out.length-1; i>=0; i--){
            out[i]=output.get(i); 
        }
        return out; 
    }
}