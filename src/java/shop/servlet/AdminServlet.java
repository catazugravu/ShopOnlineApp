package shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.business.Product;
import shop.database.ProductDAO;

/**
 *
 * @author TRINH_PC
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin/product"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action;
            action = req.getParameter("action");

            if ("Edit product".equalsIgnoreCase(action)) {
                int productID = Integer.parseInt(req.getParameter("productID"));
                req.setAttribute("products", ProductDAO.getProduct(productID));
                String url = "/admin/editproduct.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(req, resp);
            }

            if ("Edit product value".equalsIgnoreCase(action)) {
                int productID = Integer.parseInt(req.getParameter("productID"));
                String productCode = req.getParameter("productCode");
                String productDescription = req.getParameter("productDescription");
                double productPrice = Double.parseDouble(req.getParameter("productPrice"));
                Product product = new Product(productID, productCode, productDescription, productPrice);
                ProductDAO.update(product);
            }
            if ("Delete".equalsIgnoreCase(action)) {
                int productID = Integer.parseInt(req.getParameter("productID"));
                ProductDAO.delete(productID);
                String url = "/admin/product.jsp";

            }

            if ("Add product".equalsIgnoreCase(action)) {
                int productID = Integer.parseInt(req.getParameter("productID"));
                String productCode = req.getParameter("productCode");
                String productDescription = req.getParameter("productDescription");
                double productPrice = Double.parseDouble(req.getParameter("productPrice"));
                Product product = new Product(productID, productCode, productDescription, productPrice);
                ProductDAO.insert(product);
            }

            req.setAttribute("products", ProductDAO.selectProduct());

            String url = "/admin/product.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(req, resp);

        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
