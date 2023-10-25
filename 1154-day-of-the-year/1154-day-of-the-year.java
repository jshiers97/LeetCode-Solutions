class Solution {
    public int dayOfYear(String date) {
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dates = date.split("-");
        int year = Integer.valueOf(dates[0]);
        int month = Integer.valueOf(dates[1]);
        int days = Integer.valueOf(dates[2]);
        int res = 0;

        for (int i = 0; i < month; i++) {
            res += months[i];
            if(i == 2 && isLeap(year)) res++;
        }
        res += days;

        return res;
    }

    private boolean isLeap(int year) {
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false; 
        }
            
    }
}