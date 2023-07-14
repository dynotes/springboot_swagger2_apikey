/**
 * 
 */
package com.dynotes.webservices.springbootswagger2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynotes.webservices.springbootswagger2.model.Hello;
import com.dynotes.webservices.springbootswagger2.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

//import io.swagger.annotations.ApiOperation;

/**
 * @author Yufeng Chen
 */
@RestController
@RequestMapping("/api")
public class SampleController {

	@Value(value = "${api.auth.secret}")
	private String defaultKey;
	
    @Operation(summary = "Say Hello!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hello World :)",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Hello.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Hello :D", content = @Content),
            @ApiResponse(responseCode = "404", description = "Hello not found :(", content = @Content)}) // @formatter:on
    @GetMapping("/hello")
    public ResponseEntity<Hello> hello(@RequestHeader(name = "${api.auth.header.name}", defaultValue = "", required = false) String apiKey) {
    	System.out.println("defaultKey = " + defaultKey);
    	System.out.println("apiKey = " + apiKey);
    	
    	if (StringUtils.hasLength(apiKey)) {
    		if (apiKey.equals(defaultKey)) {
    			Hello h = new Hello("Hello, Dynotes API!");
    	        return ResponseEntity.ok(h);
    		} else {
    			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    		}
    	} else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @Operation(summary = "Get a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get a User",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid User :D", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found :(", content = @Content)}) // @formatter:on
    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestHeader(name = "${api.auth.header.name}", defaultValue = "", required = false) String apiKey) {
    	System.out.println("defaultKey = " + defaultKey);
    	System.out.println("apiKey = " + apiKey);
    	
    	if (StringUtils.hasLength(apiKey)) {
    		if (apiKey.equals(defaultKey)) {
    	    	User user = new User();

    	    	user.setName("John Doe");
    	    	user.setAge(30);
    	    	user.setEmail("johndoe@dynotes.com");
    	        
    	        return ResponseEntity.ok(user);
    		} else {
    			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    		}
    	} else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
}
