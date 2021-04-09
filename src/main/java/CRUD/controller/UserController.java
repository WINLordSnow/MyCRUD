package CRUD.controller;

import CRUD.UserService.UserService;
import CRUD.model.Role;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping
    public String startPage() {
        return "home";
    }

    @GetMapping("/users")
    public String listUsers(ModelMap model) {
        List<User> list = userService.getAllUsers();
        Set<Role> roles = userService.getAllRoles();
        model.addAttribute("users", list);
        model.addAttribute("roles", roles);
        return "index";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUserForm(@PathVariable("id") long id, ModelMap model) {
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
    public String addUser(@ModelAttribute User user) {
        user.addRole(new Role("USER"));
        userService.setUser(user);
        return "redirect:/users";
    }

}
