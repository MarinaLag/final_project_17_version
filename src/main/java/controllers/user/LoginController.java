package controllers.user;

import controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static constants.ApplicationConstants.LOGIN_CONTROLLER;
import static constants.ApplicationConstants.USER_NOT_FOUND;
import static constants.JspConstants.*;

@WebServlet(urlPatterns = LOGIN_CONTROLLER)
public class LoginController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter(LOGIN_PARAM);
        var password = req.getParameter(PASS_PARAM);
        var user = userService.getUser(login, password);
        if (!Objects.isNull(user)) {
            var session = req.getSession();
            session.setAttribute(USER_ATTR, user);
            forwardUrl(req, resp, HOME_JSP);
        } else {
            forwardUrl(req, resp, LOGIN_JSP, USER_NOT_FOUND);
        }
    }
}
