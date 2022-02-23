package tech.jaya.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.jaya.project.dto.UserResgisterDTO;
import tech.jaya.project.exception.NotFoundException;
import tech.jaya.project.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "new user", notes = "insert a new user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "user created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "authentication error"),
			@ApiResponse(code = 403, message = "access denied"),
			@ApiResponse(code = 404, message = "resource not found"),
			@ApiResponse(code = 500, message = "an exception occurs") })
	public ResponseEntity<?> CreateUser(@RequestBody UserResgisterDTO userDTO) throws NotFoundException {
		
		try {
			logger.info("Request for Create User has been sent.");
			ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
			return ResponseEntity.ok(userDTO);
		} catch (NotFoundException notFoundException) {
			logger.error("A Not Found error occurs CreateUser.");
			return ResponseEntity.notFound().build();
			
		} catch (BadRequest badRequestException) {
			logger.error("Bad request error occurs CreateUser.");
			return ResponseEntity.badRequest().build();
			
		} catch (Unauthorized unauthorizedException) {
			logger.error("Unauthorized requisition occurs CreateUser.");
			return ResponseEntity.status(401).build();
			
		} catch (InternalServerError internalServerErrorException) {
			logger.error("Internal server error occurs CreateUser.");
			return ResponseEntity.internalServerError().build();
		}catch (Exception exception) {
			logger.error("A Exception error occurs in CreateUser.");
			return ResponseEntity.internalServerError().build();
		}
	}
}