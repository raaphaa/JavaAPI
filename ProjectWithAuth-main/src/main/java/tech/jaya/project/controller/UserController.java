package tech.jaya.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.jaya.project.dto.UserAuthenticatedDTO;
import tech.jaya.project.dto.UserResgisterDTO;
import tech.jaya.project.exception.NotFoundException;
import tech.jaya.project.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping("/CreateUser")
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
	
	   @GetMapping("/findUser")
		@ApiOperation(value = "List all", notes = "a list of all users")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "All users returned"),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "authentication error"),
				@ApiResponse(code = 403, message = "access denied"),
				@ApiResponse(code = 404, message = "resource not found"),
				@ApiResponse(code = 500, message = "an exception occurs") })
		public ResponseEntity<List<UserAuthenticatedDTO>> findAll() throws NotFoundException {

			try {
				logger.info("All Transactions returned.");
				List<UserAuthenticatedDTO> userList = userService.findAll();
				return ResponseEntity.ok(userList);	
				
			} catch (NotFoundException notFoundException) {
				logger.error("User were not found in return all Users.");
				return ResponseEntity.notFound().build();
				
			} catch (BadRequest badRequestException) {
				logger.error("Bad request error occurs in return all Users.");
				return ResponseEntity.badRequest().build();
				
			} catch (Unauthorized unauthorizedException) {
				logger.error("Unauthorized requisition occurs in return all Users.");
				return ResponseEntity.status(401).build();
				
			} catch (InternalServerError internalServerErrorException) {
				logger.error("Internal server error occurs in return all Users.");
				return ResponseEntity.internalServerError().build();
				
			}catch (Exception exception) {
				logger.error("A Exception error occurs in return all Users.");
				return ResponseEntity.internalServerError().build();
			}
		}
	   
	   @GetMapping("/{iduser}")
		@ApiOperation(value = "list users by id", notes = "list users by id")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "users returned"),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "authentication error"),
				@ApiResponse(code = 403, message = "access denied"),
				@ApiResponse(code = 404, message = "resource not found"),
				@ApiResponse(code = 500, message = "an exception occurs") })
		public ResponseEntity<?> findById(
				@ApiParam(name = "iduser", type = "Long", value = "User Id", example = "1", required = true) @PathVariable Long iduser)
				throws NotFoundException {

			try {
				logger.info("Information Request for User has been sent.");
				List<UserAuthenticatedDTO> user = userService.findById(iduser);
				return ResponseEntity.ok(user);
				
			} catch (NotFoundException notFoundException) {
				logger.error("User id not founded occurs in list by id.");
				return ResponseEntity.notFound().build();
				
			} catch (BadRequest badRequestException) {
				logger.error("Bad request error for id occurs in list by id.");
				return ResponseEntity.badRequest().build();
				
			} catch (Unauthorized unauthorizedException) {
				logger.error("Unauthorized requisition occurs in list by id.");
				return ResponseEntity.status(401).build();
				
			} catch (InternalServerError internalServerErrorException) {
				logger.error("Internal server error occurs in list by id.");
				return ResponseEntity.internalServerError().build();
			}catch (Exception exception) {
				logger.error("A Exception error occurs in list by id.");
				return ResponseEntity.internalServerError().build();
			}
		}


	    @PutMapping("/updateUser/{id}")
	    @ApiOperation(value = "Update users by id", notes = "Update users by id")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "users returned"),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "authentication error"),
				@ApiResponse(code = 403, message = "access denied"),
				@ApiResponse(code = 404, message = "resource not found"),
				@ApiResponse(code = 500, message = "an exception occurs") })
	    public ResponseEntity<?> updateUser(@RequestBody UserAuthenticatedDTO dto, @PathVariable Long id) throws NotFoundException  {
	        
	    	try {
				logger.info("Update Request for User has been sent.");
				 userService.update(id, dto);
				return ResponseEntity.ok(dto);
				
			} catch (NotFoundException notFoundException) {
				logger.error("A Not Found error occurs in updateUser.");
				return ResponseEntity.notFound().build();
				
			} catch (BadRequest badRequestException) {
				logger.error("Bad request error for id occurs in updateUser.");
				return ResponseEntity.badRequest().build();
				
			} catch (Unauthorized unauthorizedException) {
				logger.error("Unauthorized requisition occurs in updateUser.");
				return ResponseEntity.status(401).build();
				
			} catch (InternalServerError internalServerErrorException) {
				logger.error("Internal server error occurs in updateUser.");
				return ResponseEntity.internalServerError().build();
				
			}catch (Exception exception) {
				logger.error("A Exception error occurs in updateUser.");
				return ResponseEntity.internalServerError().build();
			}
	    }

	    @DeleteMapping("/deleteUser/{id}")
	    @ApiOperation(value = "delete users by id", notes = "delete users by id")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "user deleted"),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "authentication error"),
				@ApiResponse(code = 403, message = "access denied"),
				@ApiResponse(code = 404, message = "resource not found"),
				@ApiResponse(code = 500, message = "an exception occurs") })
	    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {
	    
	    	try {
				logger.info("Delete Request for User has been sent.");
				 userService.delete(id);
				return ResponseEntity.ok(id);
				
			} catch (NotFoundException notFoundException) {
				logger.error("A Not Found error occurs in updateUser.");
				return ResponseEntity.notFound().build();
				
			} catch (BadRequest badRequestException) {
				logger.error("Bad request error for id occurs in updateUser.");
				return ResponseEntity.badRequest().build();
				
			} catch (Unauthorized unauthorizedException) {
				logger.error("Unauthorized requisition occurs in updateUser.");
				return ResponseEntity.status(401).build();
				
			} catch (InternalServerError internalServerErrorException) {
				logger.error("Internal server error occurs in updateUser.");
				return ResponseEntity.internalServerError().build();
				
			}catch (Exception exception) {
				logger.error("A Exception error occurs in updateUser.");
				return ResponseEntity.internalServerError().build();
			}
	    }
	    
	   // @DeleteMapping("/deleteUser/{id}")
	    //public void delete(@PathVariable Long id) {
	    //	 return UserService.delete(id);
	   // }
}