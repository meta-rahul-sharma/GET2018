package com.metacube.commandprompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a node in Directory Structure which contains
 * ListOfChildren ,Parent node, Data, and dateOfCreation of node Here, Node
 * means folder
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 * @param <T>
 */
public class Node<T> {
	private List<Node<T>> children = new ArrayList<Node<T>>();
	private Node<T> parent = null;
	private T data = null;
	private Date dateOfCreation;

	public Node(T data, Node<T> parent) {
		this.data = data;
		this.parent = parent;
		dateOfCreation = new Date();
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public List<Node<T>> getChildren() {
		return children;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void addChild(Node<T> child) {
		this.children.add(child);
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}

	public boolean isLeaf() {
		return this.children.size() == 0;
	}

	public void removeParent() {
		this.parent = null;
	}
}