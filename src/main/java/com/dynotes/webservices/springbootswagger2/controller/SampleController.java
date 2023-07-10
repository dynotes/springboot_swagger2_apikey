/**
 * 
 */
package com.dynotes.webservices.springbootswagger2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynotes.webservices.springbootswagger2.model.User;

/**
 * @author Yufeng Chen
 */
@RestController
@RequestMapping("/api")
public class SampleController {

	/**
	 * Original from ChatGPT
	 */
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Dynotes API!";
    }
    
    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
    	User user = new User();

    	user.setName("John Doe");
    	user.setAge(30);
    	user.setEmail("johndoe@dynotes.com");
        
        return ResponseEntity.ok(user);
    }
}
