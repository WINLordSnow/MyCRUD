package CRUD.controller;

import CRUD.UserService.UserService;
import CRUD.config.RootConfig;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
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
        return "welcome";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String printUsers(ModelMap model) {
        System.out.println(list.get(0));
        String temp = "RRRRRRRR";
        model.addAttribute("users", temp);
        return "users";
    }

    @GetMapping("addUser")
    public String getAddUser() {

        return "addUser";
    }

    @GetMapping("add")
    public String getAddUser1(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        userService.setUser(new User(name, lastName));
        return "/";
    }

    @GetMapping
    public String getIndex() {

        return "index";
    }


}
