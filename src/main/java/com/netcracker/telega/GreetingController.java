package com.netcracker.telega;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class GreetingController {
    private static List<User> persons = new ArrayList<User>();
    User user=new User("Bill", "Gates","Bill", "Gates");


    @GetMapping("/greeting")
    public String greeting(Model model,@RequestParam(name="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        model.addAttribute("persons", user);
        return "login";
    }

    @RequestMapping(params = "Submit", method = RequestMethod.POST)
        public String Save(Model model,String username1,String password1,String lastname,String firstname){

        if(username1 != ""&& password1 != "" && lastname!= "" && firstname!= ""){
            user=new User(username1,firstname, lastname,password1);
            return "login";
        }
        else   model.addAttribute("error", "Error,all fields must be filled");
        model.addAttribute("persons", user);
        return "registration";


    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

}