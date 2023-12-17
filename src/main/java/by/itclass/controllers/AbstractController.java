package by.itclass.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.itclass.model.services.FoodService;
import by.itclass.model.services.UserService;

import java.io.IOException;

import static by.itclass.constants.JspConstants.MESSAGE_ATTR;


@WebServlet(name = "abstractController")
public abstract class AbstractController extends HttpServlet {
    // инициализация
    protected UserService userService;
    protected FoodService foodService;

    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
        foodService = FoodService.getInstance();
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
// убивает сессию
    protected void redirect(HttpServletResponse resp, String url)
            throws IOException {
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

}
