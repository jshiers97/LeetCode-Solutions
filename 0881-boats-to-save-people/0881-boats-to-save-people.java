class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int boats=0;
        while(right >=0 && people[right]>= limit){
            boats++;
            right--;
        }
        while(left < right){
            int sum=people[left]+ people[right];
            if(sum <= limit){
                boats++;
                left++;
                right--;
            }
            else{
                boats++;
                right--;
            }
        }
        if(left==right){
            boats++;
        }
        return boats;
    }
}