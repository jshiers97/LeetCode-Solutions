class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair<Character, Integer>> pq=new PriorityQueue<>( (x, y) -> y.getValue() - x.getValue());
        int[] chars=new int[26];
        for(char c: s.toCharArray()){
            chars[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(chars[i]==0){
                continue;
            }
            char c=(char)(i+'a');
            
            pq.offer(new Pair<>(c, chars[c-'a']));
        }
        System.out.println(chars[0]);
        System.out.println(chars[1]);
        StringBuilder res=new StringBuilder();
        List<Pair<Character, Integer>> temp=new ArrayList<>();
        while(!pq.isEmpty()){
            Pair<Character, Integer> curr=pq.poll();
            char c=curr.getKey();
            int num=curr.getValue();
            if(res.length() > 0 && res.charAt(res.length()-1)==c){
                System.out.println(res.toString()); 
                System.out.println(num);
                return "";
            }
            res.append(c);
            num--;
            Pair<Character, Integer> replacement=new Pair<>(c, num);
            
            if(!pq.isEmpty()){
                Pair<Character, Integer> next=pq.poll();
                char d=next.getKey();
                int num2=next.getValue()-1;
                res.append(d);
                if(num > 0){
                pq.offer(replacement);
            }
                if(num2>0){
                    Pair<Character, Integer> replacement2=new Pair<>(d, num2);
                
                    pq.offer(replacement2);
                }
                
            }
            else{
               if(num > 0){
                    pq.offer(replacement);
                } 
            }
            
            
            
            
        }
        return res.toString();
        
    }
}