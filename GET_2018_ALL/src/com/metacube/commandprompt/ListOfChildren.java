package com.metacube.commandprompt;
import java.util.Date;

/**
 * This class stores nodeData and their dateOfCreation
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 */
public class ListOfChildren {
	private Date dateOfCreation;
	private String nodeData;

	public ListOfChildren(Date dateOfCreation, String nodeData) {
		this.dateOfCreation = dateOfCreation;
		this.nodeData = nodeData;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public String getNodeData() {
		return nodeData;
	}
}
