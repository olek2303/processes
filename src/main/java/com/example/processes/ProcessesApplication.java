package com.example.processes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessesApplication.class, args);
    }

//    @Autowired
//    private UserRepository userRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user1 = User.builder()
//                .nick("przykladowy")
//                .mail("przykladowy@mail.com")
//                .password("przykladowe")
//                .build();
//
//        User user2 = User.builder()
//                .nick("przykladowy2")
//                .mail("przykladowy2@mail.com")
//                .password("przykladowe2")
//                .build();
//
//        userRepo.save(user1);
//        userRepo.save(user2);
//    }

}
