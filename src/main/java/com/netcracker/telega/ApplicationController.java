package com.netcracker.telega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.SchemaOutputResolver;

import org.springframework.data.mongodb.core.MongoTemplate;
@Controller
public class ApplicationController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private FriendsRepository friendsRepository ;
    @Autowired
    private MessageRepository messageRepository;

    Validator validator = new Validator();
    Friends friend;

    User user=new User();
    User user2=new User();
    Message message=new Message();
    List<Friends> friends;

    @GetMapping("/chat")
    public String chat(Model model,@RequestParam( required=false) String name) {

        model.addAttribute("usermessage", messageRepository.findAll());
        model.addAttribute("friends",friendsRepository.findByUsername(user.getUsername()) );
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
            user=new User(username,"firstname","lastname",password);

           model.addAttribute("message", "You have been logged out successfully.");
            model.addAttribute("usermessage", messageRepository.findByFromAndTo(user.getUsername(),user2.getUsername()));
            model.addAttribute("friends",friendsRepository.findByUsername(user.getUsername()) );

            return "chat";
        }
        else{
            model.addAttribute("error", "Your username and password is invalid.");
            return "login";}
    }

    @RequestMapping(params = "choose", method = RequestMethod.GET)
    public String choose(Model model,String choose, String username) {


        for (User a : repository.findAll())
        {
         if(a.getUsername().equals(choose))user2=a;

        }
        System.out.println(user2.getUsername());
        List<Message> Messages=new ArrayList<Message>();
        for (Message a1 : messageRepository.findAll())
        {
            if(a1.getFrom().equals(user.getUsername())&& (a1.getTo().equals(user2.getUsername())) || a1.getFrom().equals(user2.getUsername())&& (a1.getTo().equals(user.getUsername())))
                Messages.add(a1);


        }

        model.addAttribute("user1",user );
        model.addAttribute("user2",user2 );
        model.addAttribute("usermessage",Messages);
        model.addAttribute("friends",friendsRepository.findByUsername(user.getUsername()) );

            return "chat";


    }

    @RequestMapping(params = "submitmsg", method = RequestMethod.POST)
    public String submitmsg(Model model, String usermsg, String username) {
        message=new Message(user.getUsername(),user2.getUsername(),usermsg);
        messageRepository.save(message);
        List<Message> Messages=new ArrayList<Message>();
        for (Message a1 : messageRepository.findAll())
        {
            if(a1.getFrom().equals(user.getUsername())&& (a1.getTo().equals(user2.getUsername())) || a1.getFrom().equals(user2.getUsername())&& (a1.getTo().equals(user.getUsername())))
                Messages.add(a1);
            System.out.println(a1);


        }
        model.addAttribute("user1",user );
        model.addAttribute("user2",user2 );
        model.addAttribute("usermessage",Messages);
        model.addAttribute("friends",friendsRepository.findByUsername(user.getUsername()) );

        return "chat";


    }
    @RequestMapping(params = "Add", method = RequestMethod.GET)

    public String Add(Model model,String findUser) {
        System.out.println(repository.findByUsername("123"));
        if (true)//repository.findByUsername(findUser)
             {
            friend = new Friends(user.getUsername(), repository.findByUsername(findUser).getUsername());
                 friendsRepository.save(friend);
                 friend = new Friends( repository.findByUsername(findUser).getUsername(),user.getUsername());
        friendsRepository.save(friend);
    }
else  model.addAttribute("message1","User Not Found!");


        model.addAttribute("user1",user );
        model.addAttribute("user2",user2 );
        model.addAttribute("friends",friendsRepository.findByUsername(user.getUsername()) );
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