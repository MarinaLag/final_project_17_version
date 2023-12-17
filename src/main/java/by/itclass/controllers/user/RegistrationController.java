package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.itclass.model.entities.User;

import java.io.IOException;

import static by.itclass.constants.ApplicationConstants.LOGIN_CONTROLLER;
import static by.itclass.constants.ApplicationConstants.*;
import static by.itclass.constants.JspConstants.*;

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
