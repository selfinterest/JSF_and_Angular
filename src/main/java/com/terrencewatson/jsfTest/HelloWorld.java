package com.terrencewatson.jsfTest;

import java.io.IOException;

import javax.faces.bean.ManagedBean;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
	String name = "Terrence";
	String json = "";
	
	public HelloWorld(){
		System.out.println("HelloWorld started!");
	}
	
	public String getMessage(){
		return "Hello world";
	}
	
	public String getName(){
		return name;
	}
	
	public void setJson(String json){
		this.json = json;
	}
	
	//The annotation is important because it prevents Jackson from getting caught in a loop.
	@JsonIgnore public String getJson(){
		if(json.isEmpty()){
			ObjectMapper mapper = new ObjectMapper(); 
			 
			try {
				json = mapper.writeValueAsString(this);
				return json;
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		return json;
	}
}
