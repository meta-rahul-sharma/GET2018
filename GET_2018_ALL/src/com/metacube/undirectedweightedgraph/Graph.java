package com.metacube.undirectedweightedgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Graph implements UndirectedWeightedGraph {
	private int[][] undirectedWeightedGraph;
	private int numberOfVertices;

	public Graph(int numberOfVertices) throws GraphException {
		if (numberOfVertices <= 0) {
			throw new GraphException("Graph with 0 Vertex not possible");
		}
		this.numberOfVertices = numberOfVertices;
		undirectedWeightedGraph = new int[numberOfVertices][numberOfVertices];
	}

	public void addEdge(int firstVertex, int secondVertex, int edgeWeight) throws GraphException {
		if (undirectedWeightedGraph[firstVertex - 1][secondVertex - 1] == 0) {
			undirectedWeightedGraph[firstVertex - 1][secondVertex - 1] = edgeWeight;
			undirectedWeightedGraph[secondVertex - 1][firstVertex - 1] = edgeWeight;
		} else {
			throw new GraphException("Can't add edge again");
		}
	}

	@Override
	public boolean isConnected() {
		boolean isConnected = false;
		boolean[] visited = new boolean[numberOfVertices];

		depthFirstSearch(1, visited);

		int i;
		for (i = 0; i < numberOfVertices && visited[i]; i++)
			;
		if (i == numberOfVertices) {
			isConnected = true;
		}
		return isConnected;
	}

	@Override
	public List<Integer> reachable(int vertex) {
		List<Integer> reachable = new ArrayList<Integer>();
		boolean[] visited = new boolean[numberOfVertices];

		depthFirstSearch(vertex, visited);

		for (int i = 0; i < numberOfVertices; i++) {
			if (visited[i]) {
				reachable.add(i + 1);
			}
		}
		return reachable;
	}

	@Override
	public int[][] mst() throws GraphException {
		int[][] mst = new int[numberOfVertices][numberOfVertices];
		boolean[] visited = new boolean[numberOfVertices];
		if (isConnected()) {
			prims(4, mst, visited);
		} else {
			throw new GraphException("Disconnected graph can'nt form Mst");
		}
		return mst;
	}

	@Override
	public List<Integer> shortestPath(int source, int destination) {
		List<Integer> shortestPath = new ArrayList<Integer>();
		boolean[] visited = new boolean[numberOfVertices];
		int[] distance = new int[numberOfVertices];

		for (int i = 0; i < numberOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		distance[source - 1] = 0;

		for (int i = 0; i < numberOfVertices - 1; i++) {
			int minDistance = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < numberOfVertices; j++) {
				if (!visited[j] && minDistance > distance[j]) {
					minDistance = distance[j];
					index = j;
				}
			}
			
			visited[index] = true;
			
			if(distance[index] != Integer.MAX_VALUE && !visited[destination - 1]) {
				shortestPath.add(index + 1);
			}

			for (int j = 0; j < numberOfVertices; j++) {
				if (!visited[j] && undirectedWeightedGraph[index][j] != 0 
						&& distance[index] != Integer.MAX_VALUE
						&& distance[index] + undirectedWeightedGraph[index][j] < distance[j]) {
					distance[j] = distance[index] + undirectedWeightedGraph[index][j];
					/*System.out.print(distance[j] + " ");*/
				}
			}
			/*System.out.println();*/
		}
		shortestPath.add(destination);
		return shortestPath;
	}

	private void depthFirstSearch(int vertex, boolean[] visited) {
		visited[vertex - 1] = true;

		for (int i = 0; i < numberOfVertices; i++) {
			if (undirectedWeightedGraph[vertex - 1][i] != 0 && !visited[i]) {
				depthFirstSearch(i + 1, visited);
			}
		}
	}

	private void prims(int vertex, int[][] mst, boolean[] visited) {
		visited[vertex - 1] = true;

		int minimumEdgeWeightFromCurrentVertex = Integer.MAX_VALUE;
		int otherVertexIndex = -1;
		int fromVertex = -1;
		for (int i = 0; i < numberOfVertices; i++) {
			for(int j = 0; j < numberOfVertices; j++) {
				if (visited[j] && undirectedWeightedGraph[j][i] != 0 && !visited[i]) {
					if (minimumEdgeWeightFromCurrentVertex > undirectedWeightedGraph[j][i]) {
						minimumEdgeWeightFromCurrentVertex = undirectedWeightedGraph[j][i];
						fromVertex = j;
						otherVertexIndex = i;
					}
				}
			}
		}

		if (otherVertexIndex == -1) {
			return;
		}
		/*System.out.println(vertex + " " + (otherVertexIndex + 1));*/
		mst[fromVertex][otherVertexIndex] = minimumEdgeWeightFromCurrentVertex;
		mst[otherVertexIndex][fromVertex] = minimumEdgeWeightFromCurrentVertex;

		prims(otherVertexIndex + 1, mst, visited);
	}

}
