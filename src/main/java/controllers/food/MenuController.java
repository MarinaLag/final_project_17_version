package controllers.food;

import controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.FoodItem;

import java.io.IOException;
import java.util.List;

import static constants.ApplicationConstants.MENU_CONTROLLER;
import static constants.JspConstants.*;

@WebServlet(urlPatterns = MENU_CONTROLLER)
public class MenuController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var foodType = Integer.parseInt(req.getParameter(FOOD_TYPE_PARAM));
        var items = foodService.getFoodItemsByType(foodType); // Integer - т.к. должны получить int
        enrichRequest(req, foodType, items);
        forwardUrl(req, resp, HOME_JSP);
    }

    private void enrichRequest(HttpServletRequest req, int foodType, List<FoodItem> items) {
        switch (foodType) {
            case 1 -> req.setAttribute(PIZZA_ATTR, items);
            case 2 -> req.setAttribute(DRINK_ATTR, items);
        }
    }

}

