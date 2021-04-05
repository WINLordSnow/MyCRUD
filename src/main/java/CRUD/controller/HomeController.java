package CRUD.controller;

import CRUD.UserService.UserService;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/")
public class HomeController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    private List<User> list;

    @GetMapping(value = "/")
    public String getIndex() {

        return "index";
    }

//    @GetMapping("/welcome")
//    public String getWelcome() {
//        return "welcome";
//    }
//
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String printUsers(ModelMap model) {
//        System.out.println(list.get(0));
//        String temp = "RRRRRRRR";
//        model.addAttribute("users", temp);
//        return "users";
//    }
//
//    @GetMapping("addUser")
//    public String getAddUser() {
//
//        return "addUser";
//    }
//
//    @GetMapping("add")
//    public String getAddUser1(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
//        userService.setUser(new User(name, lastName));
//        return "add";
//    }

}
