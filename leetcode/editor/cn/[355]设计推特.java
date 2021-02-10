//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表 
// 👍 195 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<Tweet>> tweetMap;
    Integer tweetIdx;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.tweetIdx = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> userTweetList = this.tweetMap.getOrDefault(userId, new ArrayList<>());
        userTweetList.add(new Tweet(tweetId, this.tweetIdx++));
        this.tweetMap.put(userId, userTweetList);
//        System.out.println("postTweet:" + this.tweetMap);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
//        System.out.println("getNewsFeed:tweetMap:" + this.tweetMap);
        List<Integer> newsFeed = new ArrayList<>();
        Queue<Tweet> q = new PriorityQueue<>((a, b) -> b.tweetIdx.compareTo(a.tweetIdx));
        Set<Integer> userFollowers = this.followerMap.getOrDefault(userId, new LinkedHashSet<>());
        Set<Integer> newsFollowers = new HashSet<>(userFollowers);
        newsFollowers.add(userId);
//        System.out.println("getNewsFeed:newsFollowers:" + newsFollowers);
        Map<Integer, Integer> userNewestTweetIdxMap = new HashMap<>();
        Map<Tweet, Integer> tweetUserMap = new HashMap<>();
        for (Integer follower : newsFollowers) {
            List<Tweet> userTweetList = this.tweetMap.getOrDefault(follower, new ArrayList<>());
            int newestTweetIdx = userTweetList.size() - 1;
            if (newestTweetIdx > -1) {
                userNewestTweetIdxMap.put(follower, newestTweetIdx);
                Tweet tweet = userTweetList.get(newestTweetIdx);
                q.offer(tweet);
                tweetUserMap.put(tweet, follower);
            }
        }
//        System.out.println("getNewsFeed:q:" + q);
        while (newsFeed.size() < 10 && !q.isEmpty()) {
            Tweet tweet = q.poll();
            newsFeed.add(tweet.tweetId);
//            System.out.println("getNewsFeed:newsFeed:" + newsFeed);
            Integer followerId = tweetUserMap.get(tweet);
//            System.out.println("getNewsFeed:followerId:" + followerId);
            int newestTweetIdx = userNewestTweetIdxMap.get(followerId) - 1;
//            System.out.println("getNewsFeed:newestTweetIdx:" + newestTweetIdx);
            if (newestTweetIdx > -1) {
                Tweet replaceTweet = this.tweetMap.get(followerId).get(newestTweetIdx);
                q.offer(replaceTweet);
                userNewestTweetIdxMap.put(followerId, newestTweetIdx);
                tweetUserMap.remove(replaceTweet);
                tweetUserMap.put(replaceTweet, followerId);
            }
//            System.out.println("getNewsFeed:new q:" + q);
        }
        return newsFeed;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> userFollowers = this.followerMap.getOrDefault(followerId, new LinkedHashSet<>());
        userFollowers.add(followeeId);
        this.followerMap.put(followerId, userFollowers);
//        System.out.println("follow:" + this.followerMap);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        this.followerMap.getOrDefault(followerId, new LinkedHashSet<>()).remove(followeeId);
//        System.out.println("unfollow:" + this.followerMap);
    }

    private static class Tweet {
        protected Integer tweetId;
        protected Integer tweetIdx;

        public Tweet(Integer tweetId, Integer tweetIdx) {
            this.tweetId = tweetId;
            this.tweetIdx = tweetIdx;
        }

        @Override
        public String toString() {
            return "tweetId:" + this.tweetId + ",tweetIdx:" + this.tweetIdx;
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
//leetcode submit region end(Prohibit modification and deletion)
