package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CreateUserServlet", value = "/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {

    private ConnectionPool connectionPool;
    private UserMapper userMapper;
    private User user;


    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // adding empty user object to session scope


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserMapper userMapper = new UserMapper(connectionPool);
        try {
            userMapper.createUser(username,password,email);
            session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.setAttribute("email",email);
            session.setAttribute("user",user);





            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
