package com.project.javajokeslib;
import java.util.List;
import java.util.Random;
import static java.util.Arrays.asList;

/**
 * Created on july 2018
 */

public class JokesBook {

    List<String> list = asList(
            "Why shouldn't you play basketball with a pig? Because it'll hog the ball!",
            "Cleaning with kids in the house is like brushing your teeth with Oreos.",
            "What did the ocean say to the sailboat? Nothing, it just waved.",
            "I wouldn't buy anything with velcro. It's a total rip-off.",
            "Did you see the movie about the hot dog? It was an Oscar wiener.",
            "Why did the man use ketchup in the rain? Because it was raining cats and hot dogs",
            "What kind of music are balloons afraid of? Pop Music."
    );

    public String getJoke(){
        Random randnum = new Random();
        String jokeResult = list.get(randnum.nextInt(list.size()));
        return  jokeResult;
    }

}
