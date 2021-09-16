/**
 * 
 */
package com.nexos.model.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nexos.model.dao.IUserDao;
import com.nexos.model.dto.UserDto;

/**
 * @author Soluciones
 *
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao muserDao;

	/**
	 * Method to get all the merchandise
	 * 
	 * @return
	 */
	@Override
	public List<UserDto> getAllUser() {
		List<UserDto> listUser = new ArrayList<>();
		muserDao.findAll().forEach(user -> {
			listUser.add(new UserDto(user.getIdUser(), user.getName()));
		});
		return listUser;
	}

}
