package Leetcode2;

public class ThreeFiveFive {

}
//1, one hashmap to store followerList, one ArrayList to store all the tweets, slow solution for getNewsFeed()
class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap; 
    //HashMap<Integer, HashSet<Integer>> fanMap; 
    ArrayList<Tweet> tweetList;
    
    class Tweet{
        int tw;
        int user; 
        public Tweet(int id, int tw){
            this.tw = tw; 
            this.user = id; 
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<Integer, HashSet<Integer>>();
        //fanMap = new HashMap<Integer, HashSet<Integer>>();
        tweetList = new ArrayList<Tweet>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new Tweet(userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        int idx = tweetList.size()-1;
        while(idx >= 0 && res.size() < 10){
            int writer = tweetList.get(idx).user;
            if(writer == userId || 
               followMap.containsKey(userId) && followMap.get(userId).contains(writer)){
                res.add(tweetList.get(idx).tw);
            }
            idx--;
        }
        return res; 
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<Integer>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId) || !followMap.get(followerId).contains(followeeId)){
            return; 
        }
        followMap.get(followerId).remove(followeeId);
    }
}
///2, zhongdian: 1, Tweet has next field to link all this poster tweets, 
//               2, use PriorityQueue to pop latest tweet  of all followees&self tweets 
class Twitter {
    static int timestamp = 0; 
    HashMap<Integer, HashSet<Integer>> followMap; 
    HashMap<Integer, Tweet> twMap; 
    
    class Tweet{
        int tw;
        int user; 
        int time; 
        Tweet next; 
        public Tweet(int id, int tw){
            this.tw = tw; 
            this.user = id; 
            this.time = timestamp++; 
            this.next = null; 
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<Integer, HashSet<Integer>>();
        twMap = new HashMap<Integer, Tweet>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newt = new Tweet(userId, tweetId); 
        if(!twMap.containsKey(userId)){
            twMap.put(userId, newt);
        }else{
            newt.next = twMap.get(userId);
            twMap.put(userId, newt);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        int followsize = followMap.containsKey(userId)? followMap.get(userId).size() + 1 : 1;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(followsize, (a, b)->(b.time - a.time));
        if(twMap.containsKey(userId)){
            q.add(twMap.get(userId));
        }
        if(followMap.containsKey(userId)){
            for(int user: followMap.get(userId)){
                if(twMap.containsKey(user)){
                    q.add(twMap.get(user));
                }
            }
        }
        
        while(q.size() != 0 && res.size() < 10){
            Tweet cur = q.poll(); 
            res.add(cur.tw);
            if(cur.next != null){
                q.add(cur.next);
            }
        }
        return res; 
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<Integer>());
        }
        if(followerId != followeeId){
            followMap.get(followerId).add(followeeId);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId) || !followMap.get(followerId).contains(followeeId)){
            return; 
        }
        followMap.get(followerId).remove(followeeId);
    }
}
