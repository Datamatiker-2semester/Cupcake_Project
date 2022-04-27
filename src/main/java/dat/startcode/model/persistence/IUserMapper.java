package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.util.ArrayList;

public interface IUserMapper
{
    public User login(String username, String password) throws DatabaseException;
    public User createUser(String username, String password, String email) throws DatabaseException;
    public ArrayList<User> getUser() throws DatabaseException;
}