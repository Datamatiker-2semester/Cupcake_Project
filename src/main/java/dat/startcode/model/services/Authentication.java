package dat.startcode.model.services;

import dat.startcode.model.entities.User;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Authentication {

    private static ConnectionPool connectionPool;
    private UserMapper userMapper;

    public static boolean isRoleAllowed(String role, HttpServletRequest request)
    {

        // Todo: extract user object from session scope and check role

        HttpSession session = request.getSession();
        session.getAttribute("user");
        UserMapper userMapper = new UserMapper(connectionPool);
        User user = null;
        role = request.getParameter("role");

        if(user.getRole() == "admin"){
            return true;
        } else{
            return false;
        }

    }
}
