import java.util.ArrayList;

import bc.*;
public class AStarNode {
	public MapLocation mapLoc;
	public double f;
	public double g;
	public double h;
	public ArrayList<AStarNode> parents;
	public AStarNode parent;
	public boolean hasParent;
	
	public AStarNode(MapLocation current) {
		mapLoc = current;
		hasParent = false;
	}
	
	public AStarNode(MapLocation current, AStarNode parent) {
		mapLoc = current;
		hasParent = true;
		this.parent = parent;
		parents.add(parent);
		parents.addAll(parent.parents);
		g = getG();
	}
	
	public void setParent(AStarNode parent) {
		hasParent = true;
		this.parent = parent;
		parents.clear();
		parents.add(parent);
		parents.addAll(parent.parents);
		g = getG();
	}
	
	public double getG() {
		g = parents.size()-1;
		return g;
	}
	
}