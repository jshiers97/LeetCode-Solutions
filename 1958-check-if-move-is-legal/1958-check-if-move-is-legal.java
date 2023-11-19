class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int m=board.length;
        int n=board[0].length; 
        boolean end=false;
        boolean middle=false;
        //check up
        int iter=rMove-1;
        
        while(iter >=0 && board[iter][cMove]!='.'){
            char currColor=board[iter][cMove];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter--;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter--;
                }
            }
        }
        end=false;
        middle=false;
        iter=rMove+1;
        
        
        //check down
        while(iter < m && board[iter][cMove]!='.'){
            char currColor=board[iter][cMove];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter++;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter++;
                }
            }
        }
        
        
        //check left
        end=false;
        middle=false;
        iter=cMove-1;
        while(iter >=0 && board[rMove][iter]!='.'){
            char currColor=board[rMove][iter];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter--;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter--;
                }
            }
        }
        
        //check right
        end=false;
        middle=false;
        iter=cMove+1;
        while(iter < n && board[rMove][iter]!='.'){
            char currColor=board[rMove][iter];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter++;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iter++;
                }
            }
        }
        
        
        //upper Right
        end=false;
        middle=false;
        int iterC=cMove+1;
        int iterR=rMove-1;
        while(iterR >=0 && iterC < n && board[iterR][iterC]!='.'){
            char currColor=board[iterR][iterC];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC++;
                    iterR--;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC++;
                    iterR--;
                }
            }
        }
        
        //uper left
        end=false;
        middle=false;
        iterC=cMove-1;
        iterR=rMove+1;
        while(iterC >=0 && iterR < m && board[iterR][iterC]!='.'){
            char currColor=board[iterR][iterC];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC--;
                    iterR++;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC--;
                    iterR++;
                }
            }
        }
        
        // bottom right
        end=false;
        middle=false;
        iterC=cMove+1;
        iterR=rMove+1;
        while(iterC < n && iterR < m && board[iterR][iterC]!='.'){
            char currColor=board[iterR][iterC];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC++;
                    iterR++;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC++;
                    iterR++;
                }
            }
        }
        
        //bottom left
        end=false;
        middle=false;
        iterC=cMove-1;
        iterR=rMove-1;
        while(iterC >=0 && iterR >=0 && board[iterR][iterC]!='.'){
            char currColor=board[iterR][iterC];
            if(color=='B'){
                if(currColor=='B'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC--;
                    iterR--;
                }
            }
            else{
                if(currColor=='W'){
                    if(!middle){
                        break;
                    }
                    else{
                        return true;
                    }
                }
                else{
                    middle=true;
                    iterC--;
                    iterR--;
                }
            }
        }
        return false;
        
        
    }
}