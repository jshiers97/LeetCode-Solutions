class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>(); 
        int left=0; 
        int right=0; 
        int max=0; 
        int curr=0; 
        while(right < fruits.length){
            int fruit=fruits[right];
            if(!set.contains(fruit) && set.size() < 2){
                set.add(fruit);
                curr++; 
                int num=map.getOrDefault(fruit, 0); 
                map.put(fruit, num+1); 
            }
            else if(!set.contains(fruit)){
                //delete left until count for that is 0, then remove from set
                while(set.size() == 2){
                    int delFruit=fruits[left];
                    int num=map.get(delFruit);
                    map.put(delFruit, num-1); 
                    curr--; 
                    if(num-1 ==0){
                        set.remove(delFruit);
                    }
                    left++;
                } 
                map.put(fruit, 1);
                set.add(fruit); 
                curr++; 
            }
            else{
                int num=map.get(fruit);
                map.put(fruit, num+1); 
                curr++; 
                
            }
            max=Math.max(curr, max); 
            right++; 
        }
        return max; 
    }
}