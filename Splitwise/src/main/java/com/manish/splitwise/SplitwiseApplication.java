package com.manish.splitwise;

import com.manish.splitwise.commands.Command;
import com.manish.splitwise.commands.CommandRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    private CommandRegistry commandRegistry;
    public Scanner scanner;
    //private List<Command> commands;

    public SplitwiseApplication(CommandRegistry commandRegistry) {
        scanner = new Scanner(System.in);
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            System.out.println("Tell what do you want to do?");
            String input = scanner.nextLine();
            commandRegistry.execute(input);
//            if (input.startsWith("UpdatePro"))
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

}

// cli input format : Register password phoneNumber userName