/* https://leetcode.com/problems/clone-graph/ */
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CloneGraph
{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	{
		if(node==null)
			return null;
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();
        clone(node, visited);
       // System.out.println(visited);
        return visited.get(node.label);
    }

    public void clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> visited)
    {
    	if(visited.containsKey(node.label))
    		return;
    	visited.put(node.label, new UndirectedGraphNode(node.label));
    	for(UndirectedGraphNode neighbor : node.neighbors)
    	{
    		clone(neighbor, visited);
    		visited.get(node.label).neighbors.add(visited.get(neighbor.label));
    	}
    }

	public static void main(String args[])
	{
		UndirectedGraphNode g0 = new UndirectedGraphNode(0);
		UndirectedGraphNode g1 = new UndirectedGraphNode(1);
		UndirectedGraphNode g2 = new UndirectedGraphNode(2);
		g0.neighbors.add(g1);
		g0.neighbors.add(g2);
		g1.neighbors.add(g0);
		g1.neighbors.add(g2);
		g2.neighbors.add(g0);
		g2.neighbors.add(g1);
		g2.neighbors.add(g2);
		CloneGraph c = new CloneGraph();
		UndirectedGraphNode cloned = c.cloneGraph(g0);
	}
}

class UndirectedGraphNode 
{
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) 
     { 
     	label = x; 
     	neighbors = new ArrayList<UndirectedGraphNode>(); 
     }

     public String toString()
     {
     	return this.label + ":" + this.neighbors;
     }
}