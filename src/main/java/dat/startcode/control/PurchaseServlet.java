package dat.startcode.control;

import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;
import dat.startcode.model.persistence.OrderMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    ConnectionPool connectionPool = new ConnectionPool();
    CupcakeMapper cupcakeMapper;


    @Override
    public void init() throws ServletException {
        ConnectionPool connectionPool = new ConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


















        request.getRequestDispatcher("purchase.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        OrderMapper orderlineMapper = new OrderMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        request.getAttribute("OrderCupcake.jsp");

        //orderlineMapper.createOrderline();
    }
}
