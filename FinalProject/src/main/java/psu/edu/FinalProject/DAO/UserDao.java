package psu.edu.FinalProject.DAO;

import psu.edu.FinalProject.Entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}