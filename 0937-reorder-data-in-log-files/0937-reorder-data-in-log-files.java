class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letters=new ArrayList<>(); 
        List<String> digits=new ArrayList<>(); 
        String[] output=new String[logs.length];
        int i=0; 
        for(String log: logs){
            String[] arr=log.split("\\s+");
            
            if(Character.isDigit(arr[1].charAt(0))){
                digits.add(log); 
                
            }
            else{
                letters.add(log.split(" ",2)); 
            }
        }
       
        Collections.sort(letters, new Comparator<String[]>() {  
            @Override  
            public int compare(String[] arr1, String[] arr2) {  
                int sizeCmp = arr1[1].compareTo(arr2[1]);  
                if (sizeCmp != 0) {  
                    return sizeCmp;  
                }  
                int second = arr1[0].compareTo(arr2[0]);   
                if (second != 0) {  
                    return second;  
                }  
                return arr1[0].compareTo(arr2[0]);  
            }  
        });  
        for(String[] temp : letters){
            output[i++]=temp[0] + " " + temp[1];
        }
        for(String dig: digits){
            output[i++]=dig;
        }
        return output; 
    }
}