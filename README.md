# JavaRestAPI

# Summary : 
```
  There are serveral way can lead us to write REST style api , 
  i adopt Jersey library to write the following sample which can 
  support some feature which we already use in our .Net projects,
  and we need to consider these feature in when we choose framework 
```

# JAX-RS Summary : 
https://www.dropbox.com/s/e3qjv1bgbyh4wl1/jersey.png?dl=0

```
JAX-RS already be include within javax.ws.rs.* namespace in JAVA , 
the two library (Jersey and RESTEasy) implement it 
and create a basic template for us to easily to write REST style api
```

# Features : 

1.Http verb attribute support
```
//http://localhost:8080/api/messages
  
@GET
public List<Message> getMessages() {
   return messageService.getAllMessages();
}
```

2.Route determine
```
//http://localhost:8080/api/messages/test?year=25

@Path("/messages")
public class MessageResource {

	@GET
	@Path("test")
	public String getMessages(@QueryParam("year")int year) {
	   return "test" + year;
	}

}

```

3. Can returning XML , JSON , plain text etc..
```

@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Message> getMessages() {
   return messageService.getAllMessages();
}
```

4. Accessing Path params
```
//http://localhost:8080/messenger/api/messages/1
  
@GET
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
public String test(@PathParam("messageId") String messageId) {
    return "test" +  messageId; 
}
```


5. Sending status code and locaition headers
```
  //http://localhost:8080/api/messages

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response addMessage(Message message){		
	Message newMessage = messageService.addMessage(message);

	//Create url in header
	//return Response.created(uri)
	//	  .entity(newMessage)
	//	  .build();

	//Can return properly status code
	return Response.status(Status.CREATED)
		  .entity(newMessage)
		  .build();
	}
```

6. Get cookied params or header params from request
```

@GET
public Response addMessage(@HeaderParams("authSessionID") String header,
		           @CookiedParams("name") String cookie){	
}	
	
```


# Other topics : 
1. Async http request
>> Java provide like ClientBuilder api  to do this
https://stackoverflow.com/questions/3142915/how-do-you-create-an-asynchronous-http-request-in-java



2. Integration with swagger
>> Can support
http://jmchung.github.io/blog/2013/12/14/integrating-swagger-into-jax-rs-with-java-ee-6-specification/



3. Task (multi thread)
>>  The closest  class is Future<T> or CompletableFuture<T>. CompletableFuture has some extra chaining methods similar to those in Task<T> in C#.





