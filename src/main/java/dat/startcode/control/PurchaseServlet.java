package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Cupcake;
import dat.startcode.model.entities.User;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    private ConnectionPool connectionPool;
    HttpSession session;


    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        request.getSession();
        int orderId = (int) session.getAttribute("orderId");
        ArrayList<Cupcake> cupcakes = orderMapper.orderlineData(orderId);
        session.setAttribute("orderline", cupcakes);

        int totalPrice = 0;

        for (int i = 0; i < cupcakes.size(); i++) {

            totalPrice += cupcakes.get(i).getPrice();
        }
        session.setAttribute("totalPrice", totalPrice);

        request.getRequestDispatcher("purchase.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession();
        String delete = request.getParameter("delete");
        if(delete != null){

            int index = Integer.parseInt(delete);
            ArrayList<Cupcake> cupcakes = (ArrayList<Cupcake>)  session.getAttribute("orderline");
            int orderId = (int) session.getAttribute("orderId");
            OrderMapper orderMapper = new OrderMapper(connectionPool);
            orderMapper.deleteOrderline(orderId,cupcakes.get(index));
            doGet(request,response);

        }
        else{
            User user = (User) session.getAttribute("user");
            user.updateBalance((int) session.getAttribute("totalPrice"));
            UserMapper userMapper = new UserMapper(connectionPool);
            userMapper.updateUser(user);
            session.setAttribute("customerOrderId",session.getAttribute("orderId"));
            session.setAttribute("orderId", 0);
            request.getRequestDispatcher("reciept.jsp").forward(request,response);
        }


    }
}
