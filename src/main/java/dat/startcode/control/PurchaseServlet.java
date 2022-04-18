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
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int topping_id = Integer.parseInt(request.getParameter("topping_id"));
        int bottom_id = Integer.parseInt(request.getParameter("bottom_id"));
        int price = Integer.parseInt(request.getParameter("price"));


        request.getAttribute("OrderCupcake.jsp");

        try {

            orderline = orderlineMapper.createOrderline(order_id,quantity,topping_id,bottom_id,price);
            session.setAttribute("order_id",order_id);
            session.setAttribute("quantity",quantity);
            session.setAttribute("topping_id",topping_id);
            session.setAttribute("bottom_id",bottom_id);
            session.setAttribute("price",price);




            request.getRequestDispatcher("purchase.jsp").forward(request, response);



            } catch(DatabaseException e){
                e.printStackTrace();
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        OrderlineMapper orderlineMapper = new OrderlineMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        request.getAttribute("OrderCupcake.jsp");

        /*try{
            //orderlineMapper.createOrderline();
        }catch (DatabaseException e){
            e.printStackTrace();
        }*/
    }
}
