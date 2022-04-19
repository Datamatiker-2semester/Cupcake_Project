package dat.startcode.control;

import dat.startcode.model.entities.Orderline;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderlineMapper;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    ConnectionPool connectionPool = new ConnectionPool();


    @Override
    public void init() throws ServletException {
        ConnectionPool connectionPool = new ConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("orderline", null); // adding empty user object to session scope
        OrderlineMapper orderlineMapper = new OrderlineMapper(connectionPool);
        Orderline orderline = null;






        request.getAttribute("OrderCupcake.jsp");




        request.getRequestDispatcher("purchase.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        OrderlineMapper orderlineMapper = new OrderlineMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        request.getAttribute("OrderCupcake.jsp");

        //orderlineMapper.createOrderline();
    }
}
