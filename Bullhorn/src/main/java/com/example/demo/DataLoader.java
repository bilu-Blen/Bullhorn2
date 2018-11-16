package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        Role userRole = new Role("USER");
//        roleRepository.save(new Role("ADMIN"));
//
//        Role adminRole = roleRepository.findByRole("ADMIN");

//        Role userRole = roleRepository.findByRole("USER");
        roleRepository.save(userRole);
        User user = new
                User("bilu", "password", "Blen", "Gamini", "blen@bob.com", "Hiking", "no image", true);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList(userRole));
        user.getRoles().add(userRole);
        userRepository.save(user);

        Post post = new Post();
        post.setDate("11/13/2018");
//        post.setImage("No image");
        post.setPostedBy(user);
        post.setContent("Beautiful life");
        postRepository.save(post);

        user = new
                User("bet", "password", "Betse", "Teme", "betse@betse.com", "reading", "no image", true);
        user.getRoles().add(userRole);
        userRepository.save(user);


        post = new Post();
        post.setDate("11/15/2018");
        post.setImage("No image");
        post.setPostedBy(user);
        post.setContent("Hello, this my first post too");
        postRepository.save(post);

    }
}