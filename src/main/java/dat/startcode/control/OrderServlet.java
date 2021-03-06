package dat.startcode.control;

import dat.startcode.model.entities.Bottom;
import dat.startcode.model.entities.Cupcake;
import dat.startcode.model.entities.Topping;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;
import dat.startcode.model.persistence.OrderlineMapper;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    Bottom bottom;

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
        session.getAttribute("topping_id");





        try {
            ArrayList<Bottom> listCupcakeBottom = cupcakeMapper.getBottom();
            session.setAttribute("listCupcakeB", listCupcakeBottom);


            ArrayList<Topping> listCupcakeTopping = cupcakeMapper.getToppings();
            session.setAttribute("listCupcakeT", listCupcakeTopping);


            request.getRequestDispatcher("ordercupcake.jsp").forward(request, response);
            request.getAttribute("index.jsp");

        } catch (DatabaseException e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();

        try{

            int topping_id = Integer.parseInt(request.getParameter("bottom")+1);
            int bottom_id = Integer.parseInt(request.getParameter("topping")+1);
            int cupcake_price = Integer.parseInt(request.getParameter("price"));
            OrderlineMapper orderlineMapper = new OrderlineMapper(connectionPool);
            orderlineMapper.createOrderline(topping_id,bottom_id,cupcake_price);



        }catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}
