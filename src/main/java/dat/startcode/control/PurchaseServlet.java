package dat.startcode.control;

import dat.startcode.model.entities.Orderline;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderlineMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ConnectionPool connectionPool = new ConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConnectionPool connectionPool = new ConnectionPool();
        OrderlineMapper orderlineMapper = new OrderlineMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        request.getAttribute("OrderCupcake.jsp");

        try {
            ArrayList<Orderline> orderlineList = orderlineMapper.getOrderline();
                session.setAttribute("listOrderline", orderlineList);

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

        try{
            //orderlineMapper.createOrderline();
        }catch (DatabaseException e){
            e.printStackTrace();
        }
    }
}
