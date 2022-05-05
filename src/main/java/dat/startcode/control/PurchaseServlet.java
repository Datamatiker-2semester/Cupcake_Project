package dat.startcode.control;

import dat.startcode.model.entities.Bottom;
import dat.startcode.model.entities.Cupcake;
import dat.startcode.model.entities.Topping;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;
import dat.startcode.model.services.Cart;
import dat.startcode.model.services.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        CupcakeMapper cupcakeMapper = new CupcakeMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null)
        {
            cart = new Cart();
        }

        int toppingChoice = Integer.parseInt(request.getParameter("nameT"));
        int bottomChoice = Integer.parseInt(request.getParameter("nameB"));

        CartItem cartItem = new CartItem(toppingChoice, bottomChoice);
        cart.addToCart(cartItem);

        session.setAttribute("cart", cart);

        System.out.println("Du valgte "+toppingChoice);
        request.getRequestDispatcher("purchase.jsp").forward(request, response);


    }
}
