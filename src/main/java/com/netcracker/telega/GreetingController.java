package com.netcracker.telega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.mongodb.core.MongoTemplate;
@Controller
public class GreetingController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private MessageRepository messageRepository;

    Validator validator = new Validator();
    User user=new User();
    Message message=new Message();

    @GetMapping("/chat")
    public String greeting(Model model,@RequestParam(name="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        model.addAttribute("usermessage", messageRepository.findAll());
        model.addAttribute("users", repository.findAll() );
        return "chat";
    }

    @GetMapping("/login")
    public String login(Model model, String username, String password) {
        return "login";
    }

    @RequestMapping(params = "LogIn", method = RequestMethod.POST)
    public String login1(Model model, String username, String password) {
        boolean b=false;
        for(User a : repository.findAll()){
            if(a. getUsername().equals(username)) {
                if (a.getPassword().equals(password)) b=true;
            }

        }
        if (b)//validator.Valid(username,password))
        {
           model.addAttribute("message", "You have been logged out successfully.");

            return "chat";
        }
        else{
            model.addAttribute("error", "Your username and password is invalid.");
            return "login";}
    }

    @RequestMapping(params = "submitmsg", method = RequestMethod.POST)
    public String submitmsg(Model model, String usermsg, String username) {
        message=new Message(username,"2",usermsg);
        messageRepository.save(message);
            model.addAttribute("usermessage", messageRepository.findAll());
        model.addAttribute("users", repository.findAll() );

            return "chat";


    }

    @RequestMapping(params = "Submit", method = RequestMethod.POST)
        public String Save(Model model,String username1,String password1,String lastname,String firstname){

        if(username1 != ""&& password1 != "" && lastname!= "" && firstname!= ""){
            user=new User(username1,firstname, lastname,password1);
       //   users.add(user);
          repository.save(user);
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