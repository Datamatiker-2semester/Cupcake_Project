package dat.startcode.control;

import dat.startcode.model.entities.Bottom;
import dat.startcode.model.entities.Topping;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;
import dat.startcode.model.persistence.OrderMapper;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    HttpSession session;
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        connectionPool = new ConnectionPool();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();
        OrderMapper orderMapper = new OrderMapper(connectionPool);

        if( (int) session.getAttribute("orderId") == 0){
            User user = (User) session.getAttribute("user");
            int orderId = 0;
            try {
                orderId = orderMapper.createOrder(user.getUserId());
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
            session.setAttribute("orderId", orderId);
        }

        CupcakeMapper cupcakeMapper = new CupcakeMapper(connectionPool);
        ArrayList<Bottom> bottomArrayList = null;
        ArrayList<Topping> toppingArrayList = null;

        try {
            bottomArrayList = cupcakeMapper.getBottom();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        try {
            toppingArrayList = cupcakeMapper.getToppings();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("bottoms", bottomArrayList);
        servletContext.setAttribute("topping", toppingArrayList);
        System.out.println(bottomArrayList);
        System.out.println(toppingArrayList);


        request.getRequestDispatcher("ordercupcake.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int bottom = Integer.parseInt(request.getParameter("bottom"))+1;
        int topping = Integer.parseInt(request.getParameter("topping"))+1;
        int amount = Integer.parseInt(request.getParameter("number"));

        session = request.getSession();
        int orderId = (int) session.getAttribute("orderId");

        OrderMapper orderMapper = new OrderMapper(connectionPool);
        try {
            orderMapper.createOrderLine(orderId,bottom,topping,amount);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("purchase.jsp").forward(request,response);

    }
}
