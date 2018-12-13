package shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shop.business.Cart;
import shop.business.Item;
import shop.database.ProductDAO;

@WebServlet(name = "CatalogServlet", urlPatterns = {"/catalog"})
public class CatalogServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String url = "/catalog/catalog.jsp";
        if (cart == null) {
            cart = new Cart();
        }

        try {
            String action = req.getParameter("action");

            if ("Add to cart".equalsIgnoreCase(action)) {
                int productID = Integer.parseInt(req.getParameter("productID"));
                Item item = new Item(1, ProductDAO.getProduct(productID));
                cart.addItems(item);
                session.setAttribute("cart", cart);
            }
            if ("Check out".equalsIgnoreCase(action)) {
                url = "/cart/checkout.jsp";
            }

            req.setAttribute("catalog", ProductDAO.selectProduct());

            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(req, resp);

        } catch (SQLException ex) {
            Logger.getLogger(CatalogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
