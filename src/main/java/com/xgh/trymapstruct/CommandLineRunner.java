package com.xgh.trymapstruct;

import org.springframework.stereotype.Service;

@Service
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner execute!");
    }
}
