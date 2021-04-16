package by.yurachel.servletExample.servlet;

import by.yurachel.servletExample.entity.Phone;
import by.yurachel.servletExample.repository.PhoneRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/addPhone")
public class newPhoneServlet extends HttpServlet {

    private PhoneRepository pr = PhoneRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/new-phone.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Phone pe = new Phone(req.getParameter("name"), Double.parseDouble(req.getParameter("price")), req.getParameter("processor"));
        pr.addProduct(pe);
        resp.sendRedirect("catalog");
    }
}

