package by.itclass.model.services;

import by.itclass.model.entities.OrderItem;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static by.itclass.constants.JspConstants.ORDER_ITEMS_ATTR;

public class CartService {
    private static CartService service;

    private CartService(){
    }

    public static CartService getInstance(){
        if (Objects.isNull(service)){
            service = new CartService();
        }
        return service;
    }

    public List<OrderItem> processCart (HttpSession session,String cartAction, OrderItem item){
        Object orderItems = session.getAttribute(ORDER_ITEMS_ATTR);
        List<OrderItem> items = Objects.nonNull(orderItems)
                ? (List<OrderItem>) orderItems
                : new ArrayList<>();
        switch (cartAction){
            case "addToCard"->items.add(item);
            case "removeFromCart" ->items.remove(item);
        }
          return items;
    }


}
