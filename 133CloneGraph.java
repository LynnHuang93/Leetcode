/*
133. Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        q.offer(node);
        while(!q.isEmpty()){
            UndirectedGraphNode curr = q.poll();
            // 将curr旧节点的邻居节点都加入curr的新节点
            for(UndirectedGraphNode oldNeighbor : curr.neighbors){
                // 判断是否已经生成过该邻居节点的新节点
                if(!map.containsKey(oldNeighbor)){
                    // 如果是第一次生成该新节点，将其加入队列中
                    map.put(oldNeighbor, new UndirectedGraphNode(oldNeighbor.label));
                    q.offer(oldNeighbor);
                }
                // 将新邻居加入新curr节点的neighbors中
                map.get(curr).neighbors.add(map.get(oldNeighbor));
            }
        }
        return root;
    }
}