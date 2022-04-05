package dat.startcode.model.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Authentication {

    static boolean admin = false;

    public static boolean isRoleAllowed(String role, HttpServletRequest request)
    {

        // Todo: extract user object from session scope and check role

        HttpSession httpSession = request.getSession();
        httpSession.getAttribute("role");
        if(role == "admin"){
            admin = true;
        }
        return admin;
    }
}
