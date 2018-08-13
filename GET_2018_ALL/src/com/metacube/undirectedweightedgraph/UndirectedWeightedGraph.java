package com.metacube.undirectedweightedgraph;

import java.util.List;

/**
 * Interface Undirected Weighted Graph methods declaration
 * @author Rahul Sharma
 * Creation Date: 13/08/2018
 */
public interface UndirectedWeightedGraph {
	public boolean isConnected();

	public List<Integer> reachable(int vertex) throws GraphException;

	public int[][] mst() throws GraphException;

	public int shortestPath(int source, int destination) throws GraphException;
}
