package ir.rezacolonel.springTutorial1.web.controller;

import ir.rezacolonel.springTutorial1.model.Orders;
import ir.rezacolonel.springTutorial1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView orderHome() {
        List<Orders> orders = orderRepository.findAll(PageRequest.of(0, 10)).getContent();
        return new ModelAndView("order/index").addObject("orders", orders);
    }

    @GetMapping("/detail")
    public String showOrderDetail(@RequestParam Long id, ModelMap modelMap) {
        Optional<Orders> order = orderRepository.findById(id);
        modelMap.addAttribute("order", order.orElse(new Orders()));
        return "order/detail";
    }

    @GetMapping("/showfiles")
    public void showfiles() {


    }
}
