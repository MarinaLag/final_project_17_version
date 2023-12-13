package controllers.user;

import controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static constants.ApplicationConstants.LOGOUT_CONTROLLER;
import static constants.JspConstants.LOGIN_JSP;

@WebServlet(urlPatterns = LOGOUT_CONTROLLER)
public class LogoutController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        session.invalidate();
        resp.sendRedirect(LOGIN_JSP);
    }
}
