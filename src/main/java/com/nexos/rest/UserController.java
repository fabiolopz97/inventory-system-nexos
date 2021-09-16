/**
 * 
 */
package com.nexos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nexos.model.dto.UserDto;
import com.nexos.model.services.IUserService;

/**
 * @author Soluciones
 *
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@RequestMapping(value = "api/v1/users")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping(value = "/")
	public List<UserDto> getAllUser() {
		return userService.getAllUser();
	}
}
