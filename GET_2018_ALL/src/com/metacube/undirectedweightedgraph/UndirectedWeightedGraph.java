package com.metacube.undirectedweightedgraph;

import java.util.List;

public interface UndirectedWeightedGraph {
	public boolean isConnected();

	public List<Integer> reachable(int vertex);

	public int[][] mst() throws GraphException;

	public List<Integer> shortestPath(int source, int destination);
}
