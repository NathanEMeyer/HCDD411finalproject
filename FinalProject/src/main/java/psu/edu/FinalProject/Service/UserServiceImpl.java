package psu.edu.FinalProject.Service;

import psu.edu.FinalProject.DAO.RoleDao;
import psu.edu.FinalProject.DAO.UserDao;
import psu.edu.FinalProject.Entity.Role;
import psu.edu.FinalProject.Entity.User;
import psu.edu.FinalProject.user.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	private RoleDao roleDao;

	//private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
		//this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User findByUserName(String userName) {
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	public void save(WebUser webUser) {
		User user = new User();

		// assign user details to the user object
		user.setUsername(webUser.getUserName());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(webUser.getPassword()));
		//user.setFirstName(webUser.getFirstName());
		//user.setLastName(webUser.getLastName());
		//user.setEmail(webUser.getEmail());
		user.setIsActive(true);

		
		user.setRole(roleDao.findRoleByName("ROLE_EMPLOYEE"));


		userDao.save(user);
	}

	private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Role role) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

			SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(role.getRoleName());
			authorities.add(tempAuthority);
		

		return authorities;
	}
}