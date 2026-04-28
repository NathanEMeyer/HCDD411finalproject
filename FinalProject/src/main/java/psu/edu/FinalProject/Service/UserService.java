package psu.edu.FinalProject.Service;

import psu.edu.FinalProject.Entity.User;
import psu.edu.FinalProject.user.WebUser;

public interface UserService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}