package web.SpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.SpringBootApp.model.User;
import web.SpringBootApp.service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = {"/users", "/"})
    public String UserList(ModelMap model){
        model.addAttribute("users", userService.listUsers());
        return "userList";
    }

    @GetMapping(value = "/addUser")
    public String newUser(ModelMap model) {
        model.addAttribute("newUser", new User());
        return "addUser";
    }
    @PostMapping (value = "/addUser")
    public String create(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/show")
    public String showUser(ModelMap model, @RequestParam("id") long id){
        model.addAttribute("theUser", userService.findUser(id));
        return "showUser";
    }


    @GetMapping("/users/edit")
    public String showUserUpdatePage(ModelMap model, @RequestParam("id") long id) {
        model.addAttribute("theUser", userService.findUser(id));
        return "editUser";
    }


    @PostMapping(value = "/users/edit")
    public String edit(@ModelAttribute("theUser") User user) {
        userService.updeteUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUserFromList(ModelMap model, @RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
