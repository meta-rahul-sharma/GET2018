package com.metacube.undirectedweightedgraph;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestEdgeListGraph {
	EdgeListGraph graph;

	@Before
	public void initializeUndirectedWeightedGraph() throws GraphException {
		graph = new EdgeListGraph(4);
		graph.addEdge(1, 4, 8);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 10);
		graph.addEdge(1, 3, 5);
		graph.addEdge(4, 2, 1);
		graph.addEdge(4, 3, 3);

	}

	@Test
	public void test() {
		assertTrue(graph.isConnected());
	}

	@Test
	public void shortestPath() {
		List<Integer> shortestPath = graph.shortestPath(2, 4);

		for (int i = 0; i < shortestPath.size(); i++) {
			System.out.println(shortestPath.get(i));
		}
	}

	@Test
	public void testMst() throws GraphException {
		int[][] mst = graph.mst();
		int[][] expected = { { 0, 0, 5, 0 }, { 0, 0, 0, 1 }, { 5, 0, 0, 3 }, { 0, 1, 3, 0 } };
		assertArrayEquals(expected, mst);
	}

	@Test
	public void test1() throws GraphException {
		Graph graph = new Graph(7);
		graph.addEdge(1, 4, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(2, 3, 8);
		graph.addEdge(2, 4, 8);
		List<Integer> reachableVertices = graph.reachable(7);
	}
}
