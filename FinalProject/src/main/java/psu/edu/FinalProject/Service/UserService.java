package psu.edu.FinalProject.Service;

import psu.edu.FinalProject.Entity.User;
import psu.edu.FinalProject.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}