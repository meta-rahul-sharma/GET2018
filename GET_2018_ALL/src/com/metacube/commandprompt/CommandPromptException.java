package com.metacube.commandprompt;

/**
 * This is custom Exception class for Command Prompt
 * @author Rahul Sharma
 *
 */
@SuppressWarnings("serial")
public class CommandPromptException extends Exception {
	String messageException;

	public CommandPromptException(String messageException) {
		this.messageException = messageException;
	}

	public String getMessage() {
		return messageException;
	}
}