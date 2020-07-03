package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Role;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String getUserList(ModelMap model) {
        model.addAttribute("users", service.listUsers());
        return "adminPage";
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.GET)
    public String getAddMenu(ModelMap model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam(name = "role") Role role) {
        service.add(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "admin/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(name = "id") Long id) {
        service.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.GET)

    public String getUpdateMenu(@RequestParam(name = "id") Long id, ModelMap model) {
        User user = service.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("user", new User());
        return "updateUser";
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam(name = "id") Long id,
                             @RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password) {
        service.update(new User(id, username, password));
        return "redirect:/admin";
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String getUserPage(ModelMap model) {
        model.addAttribute("users", service.listUsers());
        return "userPage";
    }


}