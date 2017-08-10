package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.koushik.javabrains.messenger.service.MessageService;
import org.koushik.javabrains.messenger.model.*;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	//http://localhost:8080/messenger/api/messages?year=25
	@GET
	@Path("parameters")
	public String getMessages2(@QueryParam("year")int year) {
		return "test" + year;
	}
	
	//http://localhost:8080/messenger/api/messages/annotations:params=value
	@GET
	@Path("annotations")
	public String getMessages3(@MatrixParam("param")String param) {
		return param;
	}
	
	//http://localhost:8080/messenger/api/messages/1
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String test(@PathParam("messageId") String messageId) {
		return "test" +  messageId; 
	}
	
	//http://localhost:8080/messenger/api/messages
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message , @Context UriInfo uriInfo)throws URISyntaxException{
		if(message == null) {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		
		Message newMessage = messageService.addMessage(message);
		
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		
		//Create url in header
		return Response.created(uri)
							.entity(newMessage)
							.build();
		
		//Can return properly status code
		//return Response.status(Status.CREATED)
		//			.entity(newMessage)
		//			.build();
	}
	
	//http://localhost:8080/messenger/api/messages/1
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId , Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	//http://localhost:8080/messenger/api/messages/1
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
}
