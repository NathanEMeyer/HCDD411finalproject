package psu.edu.FinalProject.DAO;

import psu.edu.FinalProject.Entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}