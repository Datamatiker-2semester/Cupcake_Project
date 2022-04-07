package dat.startcode.control;

import dat.startcode.model.entities.Bottom;
import dat.startcode.model.entities.Cupcake;
import dat.startcode.model.entities.Topping;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ConnectionPool connectionPool = new ConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        CupcakeMapper cupcakeMapper = new CupcakeMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        try {
            ArrayList<Bottom> listCupcakeBottom = cupcakeMapper.getBottom();
            session.setAttribute("listCupcakeB", listCupcakeBottom);
            ArrayList<Topping> listCupcakeTopping = cupcakeMapper.getToppings();
            session.setAttribute("listCupcakeT",listCupcakeTopping);
            request.getRequestDispatcher("OrderCupcake.jsp").forward(request, response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);

    }
}
