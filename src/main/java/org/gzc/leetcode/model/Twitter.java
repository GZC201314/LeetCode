package org.gzc.leetcode.model;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {
    private class Node{
        /*关注的userid 集合*/
        public Set<Integer> followee;
        /*twitter id集合*/
        public LinkedList<Integer> tweet;

        Node(){
            followee = new HashSet<>();

            tweet = new LinkedList<>();
        }

    }

    private int recentMax,time;
    /*tweetid 对应发送的时间*/
    private Map<Integer, Integer> tweetTime;
    /*每个用户存储的信息*/
    private Map<Integer,Node> user;
    public Twitter() {
        int time =0;
        recentMax = 10;
        tweetTime = new HashMap<>();
        user = new HashMap<>();

    }

    public void init(int userId){
        user.put(userId,new Node());
    }

    public void postTweet(int userId, int tweetId) {
        if(!user.containsKey(userId)){
            init(userId);
        }
        if(user.get(userId).tweet.size() == recentMax){
            user.get(userId).tweet.remove(recentMax-1);
        }
        user.get(userId).tweet.addFirst(tweetId);
        tweetTime.put(tweetId,++time);
    }

    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        for (int it : user.getOrDefault(userId, new Node()).tweet) {
            ans.addLast(it);
        }
        for (int followeeId : user.getOrDefault(userId, new Node()).followee) {
            if (followeeId == userId) { // 可能出现自己关注自己的情况
                continue;
            }
            LinkedList<Integer> res = new LinkedList<Integer>();
            int tweetSize = user.get(followeeId).tweet.size();
            Iterator<Integer> it = user.get(followeeId).tweet.iterator();
            int i = 0;
            int j = 0;
            int curr = -1;
            // 线性归并
            if (j < tweetSize) {
                curr = it.next();
                while (i < ans.size() && j < tweetSize) {
                    if (tweetTime.get(curr) > tweetTime.get(ans.get(i))) {
                        res.addLast(curr);
                        ++j;
                        if (it.hasNext()) {
                            curr = it.next();
                        }
                    } else {
                        res.addLast(ans.get(i));
                        ++i;
                    }
                    // 已经找到这两个链表合起来后最近的 recentMax 条推文
                    if (res.size() == recentMax) {
                        break;
                    }
                }
            }
            for (; i < ans.size() && res.size() < recentMax; ++i) {
                res.addLast(ans.get(i));
            }
            if (j < tweetSize && res.size() < recentMax) {
                res.addLast(curr);
                for (; it.hasNext() && res.size() < recentMax;) {
                    res.addLast(it.next());
                }
            }
            ans = new LinkedList<Integer>(res);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!user.containsKey(followerId)) {
            init(followerId);
        }
        if (!user.containsKey(followeeId)) {
            init(followeeId);
        }
        user.get(followerId).followee.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        user.getOrDefault(followerId, new Node()).followee.remove(followeeId);
    }
}