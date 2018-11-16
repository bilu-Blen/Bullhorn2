package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.Decoder;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public  String postList(Model model){
        model.addAttribute("posts",postRepository.findAll() );
        return "home";
    }

    @RequestMapping("/userlist")
    public String userList(Model model, Authentication auth){
        model.addAttribute("userlist", userRepository.findAll());
        return "userlist";
    }

    @RequestMapping("/update/{id}")
    public String updateProfile(@PathVariable("id") long id, Model model){
        model.addAttribute("userlist", userRepository.findById(id).get());
        return "signup";
    }


    @RequestMapping("/userprofile/{id}")
    public String userProfile(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userRepository.findById(id).get());
        return "userprofile";
    }



    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/signup")
    public String signupUser(Model model){
        model.addAttribute("newUser", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(@Valid @ModelAttribute ("newUser") User user, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result.toString());
            return "signup";
        }
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/addpost")
    public String addPost(Model model){
        model.addAttribute("post", new Post());
        return "addpost";
    }

    @PostMapping("/process")
    public String processPosting(Post post){
        postRepository.save(post);
        return "redirect:/";
    }
}
