package ru.dmitry.usol.SpringbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dmitry.usol.SpringbootCRUD.models.User;
import ru.dmitry.usol.SpringbootCRUD.service.UserService;
import ru.dmitry.usol.SpringbootCRUD.service.UserServiceInter;


import javax.validation.Valid;

@Controller
@RequestMapping("/table")
public class userController {
    private UserServiceInter userService;
    @Autowired
    public userController(UserServiceInter userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(Model model ) {
        model.addAttribute("users", userService.allUsers());
        return "all";
    }
    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user",userService.show(id));
        return "user";
    }
    @GetMapping("/new")
    public String saveUser(Model model) {
        model.addAttribute("cruser", new User());
        return  "newUser";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("cruser")@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "newUser";
        }
        userService.save(user);
        return "redirect:/table";
    }
    @GetMapping("/user/{id}/edit")
    public String editUser(@PathVariable("id") long id,Model model) {
        model.addAttribute("user",userService.show(id));
        return "edit";
    }
    @PatchMapping("/user/{id}")

    public String updateUser(@PathVariable("id")long id,
                             @ModelAttribute("user") @Valid User user,
                             BindingResult  bindingResult) {
        if(bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(id,user);
        return "redirect:/table";
    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id")long id) {
        userService.delete(id);
        return "redirect:/table";
    }


}
