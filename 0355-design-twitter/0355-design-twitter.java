class Twitter {
    class Tweet{
        int userId;
        int tweetId;
        int time;
        public Tweet(int userId, int tweetId){
            this.userId=userId;
            this.tweetId=tweetId; 
            
        }
    }
    int time=0;
    //this users followers
    Map<Integer, Set<Integer>> followers=new HashMap<>();
    
    //the users this user is following
    Map<Integer, Set<Integer>> following=new HashMap<>();
    
    //
    Map<Integer, PriorityQueue<Tweet>> userFeed=new HashMap<>();
    //Comparator<Tweet> tweetComparator= Comparator.comparingInt()
    
    Map<Integer, Queue<Tweet>> userTweets=new HashMap<>();
    
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        
        
        
        
        
        ////////
        if(!userTweets.containsKey(userId)){
            userTweets.put(userId, new LinkedList<Tweet>());
        }
        Tweet insert=new Tweet(userId, tweetId);
        insert.time=time;
        time++;
        userTweets.get(userId).offer(insert);
        if(userTweets.get(userId).size() > 10){
            userTweets.get(userId).poll();
        }
        
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>( (x,y ) -> x.time - y.time);
        if(following.containsKey(userId) && following.get(userId).size()> 0){
            for(Integer follows: following.get(userId)){
                if(userTweets.containsKey(follows)){
                    Queue<Tweet> q=new LinkedList<>(userTweets.get(follows));
                    while(!q.isEmpty()){
                        pq.offer(q.poll());
                        if(pq.size() >10){
                            pq.poll();
                        }
                    }
                }
                
            }
        }
        if(userTweets.containsKey(userId) && userTweets.get(userId).size() > 0){
            Queue<Tweet> q=new LinkedList<>(userTweets.get(userId));
        while(!q.isEmpty()){
            pq.offer(q.poll());
            if(pq.size() >10){
                pq.poll();
            }
        }
        }
        
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0, pq.poll().tweetId);
        }
        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
        
        if(!followers.containsKey(followeeId)){
            followers.put(followeeId, new HashSet<>());
        }
        followers.get(followeeId).add(followerId);
        
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId) && following.get(followerId).contains(followeeId)){
            following.get(followerId).remove(followeeId);
            followers.get(followeeId).remove(followerId);
        }
        
        
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */