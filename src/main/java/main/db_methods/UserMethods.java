package main.db_methods;

import main.User;
import main.UserRepository;
import main.utils.Utils;

import java.util.List;

public class UserMethods {

    UserRepository userRepo;

    public UserMethods(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean userInfoValid(User user) {
        return !(Utils.isNull(user.getEmail()) ||
            Utils.isNull(user.getName()) ||
                Utils.isNull(user.getPassword()) ||
                Utils.isNull(user.getSurname()) ||
                Utils.isNull(user.getAvatar()));
    }

    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    public User getUserByID(String id) {
        for (User user : this.getAllUsers()) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }


    public String getUserNameByID(String id) {
        User user = this.getUserByID(id);
        return String.format("%s %s", user.getName(), user.getSurname());
    }

    public User userExists(String email) {
        for (User user : this.getAllUsers()) {
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public void deleteUser(String id) {
        User deletedUser = this.getUserByID(id);
        this.userRepo.delete(deletedUser);
    }

    public void updateUser(User user) {
        this.userRepo.save(user);
    }

    public User changeAvatar(String id, String avatar) {
        User updatedUser = this.getUserByID(id);
        updatedUser.setAvatar(avatar);
        this.userRepo.save(updatedUser);
        return updatedUser;
    }
}
