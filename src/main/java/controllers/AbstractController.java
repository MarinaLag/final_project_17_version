package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.services.UserService;

import java.io.IOException;

import static constants.JspConstants.MESSAGE_ATTR;


public abstract class AbstractController extends HttpServlet {
    protected UserService userService;

    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //просто перейти на некий адрес
    public void forwardUrl(HttpServletRequest req, HttpServletResponse resp,
                           String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    //перегруженный метод... перейти с сообщением
    public void forwardUrl(HttpServletRequest req, HttpServletResponse resp,
                           String url, String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR, message);
        forwardUrl(req, resp, url);
    }

    protected void redirect(HttpServletResponse resp, String url)
            throws IOException {
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

}
