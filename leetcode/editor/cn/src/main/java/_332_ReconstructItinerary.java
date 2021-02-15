//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 
//
// 提示： 
//
// 
// 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序
//更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 所有的机票必须都用一次 且 只能用一次。 
// 
//
// 
//
// 示例 1： 
//
// 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2： 
//
// 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图 
// 👍 355 👎 0


import com.caomu.util.Utils;

import java.util.*;

public class _332_ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new _332_ReconstructItinerary().new Solution();
        System.out.println(solution.findItinerary(Utils.stringTo2DStringList("[[\"EZE\",\"AXA\"],[\"TIA\",\"ANU\"],[\"ANU\",\"JFK\"],[\"JFK\",\"ANU\"],[\"ANU\",\"EZE\"],[\"TIA\",\"ANU\"],[\"AXA\",\"TIA\"],[\"TIA\",\"JFK\"],[\"ANU\",\"TIA\"],[\"JFK\",\"TIA\"]]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, List<String>> itineraryMap = new HashMap<>();
            for (List<String> ticket : tickets) {
                List<String> destinations = itineraryMap.getOrDefault(ticket.get(0), new LinkedList<>());
                destinations.add(ticket.get(1));
                itineraryMap.put(ticket.get(0), destinations);
            }
            itineraryMap.forEach((departs, destinations) -> Collections.sort(destinations));
            List<String> itineraries = new ArrayList<>();
            itineraries.add("JFK");
            return this.findItinerary(itineraryMap, new ArrayList<>(), tickets.size(), itineraries);
        }

        private List<String> findItinerary(Map<String, List<String>> itineraryMap, List<Map.Entry<String, String>> visited,
                                           int ticketCount, List<String> itineraries) {
            if (visited.size() == ticketCount) {
                return itineraries;
            }
            String depart = itineraries.get(itineraries.size() - 1);
            if (!itineraryMap.containsKey(depart)) {
                return null;
            }
            List<String> destinations = itineraryMap.get(depart);
            for (String destination : destinations) {
                Map.Entry<String, String> ticket = Map.entry(depart, destination);
                if (this.validateTicket(itineraryMap, visited, ticket)) {
                    List<String> newItineraries = new ArrayList<>(itineraries);
                    newItineraries.add(destination);
                    List<Map.Entry<String, String>> newVisited = new ArrayList<>(visited);
                    newVisited.add(Map.entry(depart, destination));
                    List<String> result = this.findItinerary(itineraryMap, newVisited, ticketCount, newItineraries);
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        private boolean validateTicket(Map<String, List<String>> itineraryMap, List<Map.Entry<String, String>> visited,
                                       Map.Entry<String, String> ticket) {
            long ticketCount = itineraryMap.get(ticket.getKey()).stream().filter(destination -> Objects.equals(ticket.getValue(), destination)).count();
            long usedTicketCount = visited.stream().filter(ticket::equals).count();
            return usedTicketCount < ticketCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}