package com.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


@RestController
public class GreetingController {

    @RequestMapping("/getapi")
    public String getMethod(@RequestParam(value="name", defaultValue="World") String name) {
        
        HttpResponse<JsonNode> response = null;
		try {
			response = Unirest.get("http://localhost:9200/dept/emp/_search")
					  .header("content-type", "application/x-www-form-urlencoded")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "9cb25482-4b7e-fac8-1275-4ed14bac170d")
					  .asJson();
			} catch (UnirestException e) {
						e.printStackTrace();
		}

        return response.getBody().getObject().toString(1);
        
       
        
    }
    
    
    @RequestMapping("/postapi")
    public String postMethod(@RequestParam(value="name", defaultValue="World") String name) {
    	HttpResponse<JsonNode> response=null;
		try {
			 response = Unirest.post("http://localhost:9200/dept/emp")
					  .header("content-type", "application/json")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "e4d37790-a01e-744d-ed7c-7b730af4aae7")
				  .body("{\n\t\"name\": \"name\"\n}")
					 .asJson();
			} catch (UnirestException e) {
			e.printStackTrace();
		}

        return response.getBody().getObject().toString(1);
        
       
        
    }
 
}