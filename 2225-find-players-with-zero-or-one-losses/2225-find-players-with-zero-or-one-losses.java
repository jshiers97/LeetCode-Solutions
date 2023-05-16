class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> output=new ArrayList<>();
        output.add(new ArrayList<>());
        output.add(new ArrayList<>()); 
        int[] players=new int[100002];
        Arrays.fill(players, -1);
        for(int[] match: matches){
            int winner=match[0];
            int loser=match[1];
            if(players[winner]==-1){
                players[winner]=0;
            }
            if(players[loser]==-1){
                players[loser]=1;
            }
            else{
                players[loser]++;
            }
        }
        for(int i=0; i<players.length; i++){
            if(players[i]==0){
                output.get(0).add(i);
            }
            else if(players[i]==1){
                output.get(1).add(i); 
            }
        }
        return output; 
    }
}