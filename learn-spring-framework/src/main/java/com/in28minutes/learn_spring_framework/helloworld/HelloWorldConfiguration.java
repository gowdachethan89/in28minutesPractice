package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address){};
record Address(String firstLine, String city){};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Chethan";
    }

    @Bean
    public int age() {
        return 28;
    }

    @Bean
    public Person person() {
        return new Person("prabhu", 29, new Address("Ittasandra", "Hoskote"));
    }



    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3){
        return new Person(name, age, address3);
    }

    @Primary
    @Bean(name = "address2")
    public Address address() {
        return new Address("Mahadevapura", "Banglore");
    }

    @Bean(name = "address3")
    public Address address3() {
        return new Address("Ittasandra", "Hoskote");
    }
}
