package CRUD.controller;

import CRUD.UserService.UserService;
import CRUD.config.RootConfig;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    private List<User> list;

    @GetMapping("/welcome")
    public String getWelcome() {
        userService.setUser(list.get(0));
        return "welcome";
    }

    @GetMapping
    public String getIndex() {

        return "index";
    }


}
