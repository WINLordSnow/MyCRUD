package CRUD.controller;

import CRUD.UserService.UserService;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
//    @Autowired
//    private List<User> list;

    @GetMapping
    public String startPage() {
        return "home";
    }

    @GetMapping("/users")
    public String listUsers(ModelMap model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("users", list);
        return "index";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUserForm(@PathVariable("id")long id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


    @GetMapping("/addUser")
    public String addUserForm(User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userService.setUser(user);
        return "redirect:/users";
    }

}
