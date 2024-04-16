package com.talentreef.interviewquestions;

import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "com.talentreef")
@EntityScan(basePackages = "com.talentreef")
@EnableWebMvc

public class InterviewQuestionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewQuestionsApplication.class, args);

        System.out.println("================== START OF TESTS  ==================");
        WidgetRepository widgetRepository = new WidgetRepository();

        System.out.println("1) Create and add to the repository 3 new Widgets: Clock, Weather and News");
        widgetRepository.create("Clock", "Basic clock display", 5.99);
        widgetRepository.create("Weather", "Displays the current weather in your location", 25.20);
        widgetRepository.create("News", "Get the latest news!", 21000);
        System.out.println("List of all widgets: " + widgetRepository.findAll());

        System.out.println("------------------------------");

        System.out.println("2) Retrieve widgets by name");
        System.out.println("Find Widget Clock: " + widgetRepository.findById("Clock"));
        System.out.println("Find Widget News: " + widgetRepository.findById("News"));

        System.out.println("------------------------------");

        System.out.println("3) Update description and price for Widget Clock");
        System.out.println("Change Clock's description to: Displays the clock in different styles - and price to 10.99");
        widgetRepository.updateDesc("Clock", "Displays the clock in different styles");
        widgetRepository.updatePrice("Clock", 10.99);
        System.out.println("Widget Clock after update: " + widgetRepository.findById("Clock"));
        System.out.println("4) Retrieve Clock's description and price separately");
        System.out.println("Clock's description only: " + widgetRepository.retrieveDesc("Clock"));
        System.out.println("Clock's price only: " + widgetRepository.retrievePrice("Clock"));

        System.out.println("------------------------------");

        System.out.println("5) Delete Widget Weather from the repository");
        widgetRepository.deleteById("Weather");
        System.out.println("Updated list of widgets: " + widgetRepository.findAll());


        System.out.println("================== END OF TESTS  ==================");

    }


}
