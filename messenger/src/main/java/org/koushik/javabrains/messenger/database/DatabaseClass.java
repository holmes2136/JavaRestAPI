package org.koushik.javabrains.messenger.database;

import java.util.*;

import org.koushik.javabrains.messenger.model.*;

public class DatabaseClass {
	
	private static Map<Long,Message> messages = new HashMap<>();
	
	public static Map<Long,Message> getMessages(){
		return messages;
	}
}
