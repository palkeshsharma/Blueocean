package com.register.service;

import com.register.dao.RoleDao;
import com.register.dao.UserDao;
import com.register.entity.Role;
import com.register.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();				//userRole
        userRole.setRoleName("Retailer"); 			//userRole    "User"
        userRole.setRoleDescription("Default role for newly created retailer");   //userRole
        roleDao.save(userRole);          		//userRole
        
        Role distributorRole = new Role();				//Distributor setting
        distributorRole.setRoleName("Distributor"); 			
        distributorRole.setRoleDescription("Default role for newly created distributor");   
        roleDao.save(distributorRole);            

        User adminUser = new User();
        adminUser.setUserName("admin@gmail.com");
        adminUser.setUserPassword(getEncodedPassword("admin@123"));
        adminUser.setname("Sam");
        adminUser.setaddress("Palasia");
        adminUser.setPhone("9256312345");
        adminUser.setAdhar("872342312124");
        adminUser.setCity("Indore");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

    }

    public User registerNewUser(User user) {         
        Role role = roleDao.findById("Retailer").get();      //"USer"
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);   
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }
    
    public User registerDistributor(User user) {         
        Role role = roleDao.findById("Distributor").get();      //Distributor
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);   
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }
    

    
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
