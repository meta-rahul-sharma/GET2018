package com.metacube.undirectedweightedgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeListGraph implements UndirectedWeightedGraph {
	private Map<Integer, Map<Integer, Integer>> adjacencyList;
	private int numberOfVertices;

	public EdgeListGraph(int numberOfVertices) throws GraphException {
		this.numberOfVertices = numberOfVertices;
		if (numberOfVertices <= 0) {
			throw new GraphException("Graph with Zero or Less Vertex not possible");
		}
		adjacencyList = new HashMap<Integer, Map<Integer, Integer>>();
	}

	public void addEdge(int firstVertex, int secondVertex, int edgeWeight) throws GraphException {

		if(!adjacencyList.containsKey(firstVertex)) {
			adjacencyList.put(firstVertex, new HashMap<Integer, Integer>());
		}
		
		if(!adjacencyList.containsKey(secondVertex)) {
			adjacencyList.put(secondVertex, new HashMap<Integer, Integer>());
		}
		
		if(adjacencyList.get(firstVertex).containsKey(secondVertex)) {
			throw new GraphException("");
		}
		
		adjacencyList.get(firstVertex).put(secondVertex, edgeWeight);
		adjacencyList.get(secondVertex).put(firstVertex, edgeWeight);	
	}

	@Override
	public boolean isConnected() {
		boolean isConnected = false;
		Set<Integer> visited = new HashSet<Integer>();

		depthFirstSearch(1, visited);

		if (visited.size() == numberOfVertices) {
			isConnected = true;
		}

		return isConnected;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> reachable(int vertex) {
		Set<Integer> visited = new HashSet<Integer>();

		depthFirstSearch(vertex, visited);

		return (List<Integer>) visited;
	}

	@Override
	public int[][] mst() throws GraphException {
		int[][] mst = new int[numberOfVertices][numberOfVertices];
		Set<Integer> visited = new HashSet<Integer>();
		if (isConnected()) {
			prims(1, mst, visited);
		} else {
			throw new GraphException("Disconnected graph can'nt form Mst");
		}
		return mst;
	}

	@Override
	public List<Integer> shortestPath(int source, int destination) {
		List<Integer> shortestPath = new ArrayList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, Integer> distance = new HashMap<Integer, Integer>();

		distance.put(source, 0);

		for (int i = 1; i < numberOfVertices; i++) {
			int minDistance = Integer.MAX_VALUE;
			int visitedVertex = -1;
			for (int distanceToVertex : distance.keySet()) {
				if (!visited.contains(distanceToVertex) && minDistance > distance.get(distanceToVertex)) {
					minDistance = distance.get(distanceToVertex);
					visitedVertex = distanceToVertex;
				}
			}

			visited.add(visitedVertex);

			if (!visited.contains(destination)) {
				shortestPath.add(visitedVertex);
			}

			for (int visitingVertex : adjacencyList.get(visitedVertex).keySet()) {
				if (!visited.contains(visitingVertex)) {
					if (distance.containsKey(visitingVertex)) {
						if(distance.get(visitingVertex) > distance.get(visitedVertex) 
								+ adjacencyList.get(visitedVertex).get(visitingVertex)) {
							distance.put(visitingVertex, distance.get(visitedVertex)
								+ adjacencyList.get(visitedVertex).get(visitingVertex));
						}
					} else {
						distance.put(visitingVertex, distance.get(visitedVertex)
								+ adjacencyList.get(visitedVertex).get(visitingVertex));
					}
				}
				System.out.print(distance.get(visitingVertex) + " ");
			}
			System.out.println(); 
		}
		shortestPath.add(destination);
		return shortestPath;
	}

	private void depthFirstSearch(int vertex, Set<Integer> visited) {
		visited.add(vertex);
		for (int secondVertex : adjacencyList.get(vertex).keySet()) {
			if (!visited.contains(secondVertex)) {
				depthFirstSearch(secondVertex, visited);
			}
		}
	}

	private void prims(int vertex, int[][] mst, Set<Integer> visited) {
		visited.add(vertex);

		int minimumEdgeWeightFromCurrentVertex = Integer.MAX_VALUE;
		int otherVertex = -1;
		int fromVertex = -1;
		for (int visitedNode : visited) {
			for (int toVertex : adjacencyList.get(visitedNode).keySet()) {
				int distanceToVertex = adjacencyList.get(visitedNode).get(toVertex);
				if (!visited.contains(toVertex) && minimumEdgeWeightFromCurrentVertex > distanceToVertex) {
					minimumEdgeWeightFromCurrentVertex = distanceToVertex;
					fromVertex = visitedNode;
					otherVertex = toVertex;
				}
			}
		}

		if (otherVertex == -1) {
			return;
		} 
		mst[fromVertex - 1][otherVertex - 1] = minimumEdgeWeightFromCurrentVertex;
		mst[otherVertex - 1][fromVertex - 1] = minimumEdgeWeightFromCurrentVertex;

		prims(otherVertex, mst, visited);
	}

}
