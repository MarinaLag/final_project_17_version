package controllers.user;

import controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.User;

import java.io.IOException;

import static constants.ApplicationConstants.LOGIN_CONTROLLER;
import static constants.ApplicationConstants.*;
import static constants.JspConstants.*;

@WebServlet(urlPatterns = REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter(LOGIN_PARAM);
        var name = req.getParameter(NAME_PARAM);
        var password = req.getParameter(PASS_PARAM);
        var email = req.getParameter(EMAIL_PARAM);
        var user = new User(login, name, email);
        if (userService.addUser(user, password)) {
            redirect(resp, LOGIN_JSP);
        } else {
            forwardUrl(req, resp, REGISTRATION_JSP, USER_NOT_REGISTERED);
        }

    }
}
