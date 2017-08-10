package org.koushik.javabrains.messenger.service;

import java.util.*;
import org.koushik.javabrains.messenger.model.*;
import org.koushik.javabrains.messenger.database.*;

public class MessageService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L,new Message(1,"Hellow World","holmes"));
		messages.put(2L,new Message(2,"Hellow World2","sherlock"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <=0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
		
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
