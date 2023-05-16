class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> output=new ArrayList<>();
        Set<Integer> champs=new HashSet<>();
        Set<Integer> runner=new HashSet<>();
        Set<Integer> losers=new HashSet<>();
        for(int[] match: matches){
            int winner=match[0];
            int loser=match[1];
            if(champs.contains(loser)){
                champs.remove(loser);
                runner.add(loser);
            }
            else if(runner.contains(loser)){
                runner.remove(loser);
                losers.add(loser); 
            }
            else if(!losers.contains(loser)){
                runner.add(loser);
            }
            else{
                losers.add(loser);
            }
            if(!losers.contains(winner) && !runner.contains(winner)){
                champs.add(winner); 
            }
        }
        output.add(new ArrayList<>());
        output.add(new ArrayList<>()); 
        for(Integer x: champs){
            output.get(0).add(x); 
        }
        for(Integer x: runner){
            output.get(1).add(x); 
        }
        Collections.sort(output.get(0));
        Collections.sort(output.get(1));
        return output; 
    }
}