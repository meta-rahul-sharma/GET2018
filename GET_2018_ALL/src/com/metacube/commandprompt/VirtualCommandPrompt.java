package com.metacube.commandprompt;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements Virtual Command Prompt
 * @author Rahul Sharma Creation Date: 7/8/2018
 */
public class VirtualCommandPrompt {
	Node<String> root = new Node<String>("R:\\", null);
	Node<String> currentNode = root;
	String path = "R:\\";
	List<String> pathSearch = new ArrayList<String>();

	/**
	 * Create a new directory
	 * @param folderName
	 * @return
	 * @throws CommandPromptException
	 */
	public boolean mkdir(String folderName) throws CommandPromptException {
		for (Node<String> node : currentNode.getChildren()) {
			if (node.getData().equals(folderName)) {
				throw new CommandPromptException("folderName already Exists");
			}
		}
		currentNode.addChild(new Node<String>(folderName, currentNode));
		return true;
	}

	/**
	 * Change Directories 
	 * @param path
	 * @return
	 */
	public String cd(String path) {
		for (int i = 0; i < currentNode.getChildren().size(); i++) {
			if (currentNode.getChildren().get(i).getData().equals(path)) {
				if (currentNode.getData().equals("R:\\")) {
					currentNode = currentNode.getChildren().get(i);
					this.path += path;
					break;
				}
				currentNode = currentNode.getChildren().get(i);
				this.path += "\\" + path;
				break;
			}
		}
		return this.path;
	}

	/**
	 * Move to parent directory
	 * @return path after back command
	 * @throws CommandPromptException
	 */
	public String bk() throws CommandPromptException {
		if (currentNode.getParent() == null) {
			throw new CommandPromptException("Can't go to Parent Directory, already in Root");
		}
		currentNode = currentNode.getParent();
		String tokens[] = path.toString().split("\\\\");
		path = "";
		int i = 0;

		// Appending tokens to the path
		for (; i < tokens.length - 2; i++) {
			path += tokens[i] + "\\";
		}
		if (path.equals("")) {
			path += tokens[i] + "\\";
			return path;
		}
		path += tokens[i];
		return path;
	}

	/**
	 * Display list of all folders in the current folder along with their date-time
	 * of creation.
	 * @return
	 */
	public List<ListOfChildren> ls() {
		List<ListOfChildren> listOfSubNodes = new ArrayList<ListOfChildren>();
		List<Node<String>> childrenOfNode = new ArrayList<Node<String>>();
		childrenOfNode = currentNode.getChildren();
		for (int i = 0; i < childrenOfNode.size(); i++) {
			listOfSubNodes.add(
					new ListOfChildren(childrenOfNode.get(i).getDateOfCreation(), childrenOfNode.get(i).getData()));
		}
		return listOfSubNodes;
	}

	/**
	 * Find a folder in current or subfolders
	 * @param folderName
	 * @param node
	 * @param pathToSearch
	 */
	public List<String> find(String folderName, Node<String> node, String pathToSearch) {
		if (node == null) {
			throw new NullPointerException("Node can't be empty in find");
		}

		if (pathToSearch == null) {
			throw new NullPointerException("pathToSearch can't be Empty");
		}

		if (pathToSearch == "") {
			pathSearch.clear();
		}

		List<Node<String>> childrenOfNode = new ArrayList<Node<String>>();
		childrenOfNode = node.getChildren();
		for (int i = 0; i < childrenOfNode.size(); i++) {
			if (childrenOfNode.get(i).getData().equals(folderName)) {
				if (path.equals("R:\\")) {
					pathSearch.add(path + pathToSearch + folderName);
					find(folderName, childrenOfNode.get(i), childrenOfNode.get(i).getData() + "\\");
					continue;
				}
				pathSearch.add(path + "\\" + pathToSearch + folderName);
				find(folderName, childrenOfNode.get(i), childrenOfNode.get(i).getData() + "\\");
			} else if (childrenOfNode.get(i).getChildren().size() > 0) {
				find(folderName, childrenOfNode.get(i), childrenOfNode.get(i).getData() + "\\");
			}
		}
		return pathSearch;
	}

	/**
	 * To display the complete directory structure
	 * @param current
	 * @param countLevels
	 */
	public void tree(Node<String> current, int countLevels) {
		if (current == null) {
			throw new NullPointerException("Current Node can't be empty in tree");
		}
		for (int i = 0; i < countLevels; i++) {
			System.out.print("\t");
		}
		System.out.println("|_____ " + current.getData());
		for (int j = 0; j < current.getChildren().size(); j++) {
			tree(current.getChildren().get(j), countLevels + 1);
		}
		return;
	}

	/**
	 * To Exit the VCP
	 */
	public void exit() {
		System.exit(1);
	}
}
