package com.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController
{
   @GetMapping("/data")
   @CircuitBreaker(fallbackMethod = "getDataFromDB", name ="Avinash")
   public String getData() 
   {
	   System.out.println("redis method called...");
	   
	   int i =10/0;
	   
	   return "Redis Data sent to your email";
   }
   
   public String getDataFromDB(Throwable t)
   {
	   System.out.println("DB method called...");
	   return "DB Data send to your email";
   }
}
