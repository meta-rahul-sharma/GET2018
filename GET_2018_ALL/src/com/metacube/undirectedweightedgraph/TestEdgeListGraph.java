package com.metacube.undirectedweightedgraph;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Used for Testing Purpose of Undirected Weighted Graph using adjacency List
 * @author Rahul Sharma
 * Creation Date: 13/08/2018
 */
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
		int shortestPath = graph.shortestPath(4, 1);
		assertEquals(8, shortestPath);
	}

	@Test
	public void testMst() throws GraphException {
		int[][] mst = graph.mst();
		int[][] expected = { { 0, 0, 5, 0 }, { 0, 0, 0, 1 }, { 5, 0, 0, 3 }, { 0, 1, 3, 0 } };
		assertArrayEquals(expected, mst);
	}

	@Test
	public void test1() throws GraphException {
		MatrixGraph graph = new MatrixGraph(7);
		graph.addEdge(1, 4, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(2, 3, 8);
		graph.addEdge(2, 4, 8);
		List<Integer> reachableVertices = graph.reachable(1);
		List<Integer> expected = Arrays.asList(1, 2, 3, 4);
		Assert.assertEquals(expected, reachableVertices);
	}
}
