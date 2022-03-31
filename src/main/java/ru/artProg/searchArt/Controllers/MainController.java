package ru.artProg.searchArt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.artProg.searchArt.Parser;

@Controller
public class MainController{
    @GetMapping("/")
    public ModelAndView getModel(){
        System.out.println("Теперь нахожусь тут");
        ModelAndView modeAndView = new ModelAndView("index");
        return modeAndView;
    }

    @GetMapping("/mood")
    public ModelAndView getMoodModel(){
        ModelAndView modeAndView = new ModelAndView("moodpacage");
        //modeAndView.addObject();
        return modeAndView;
    }

    @GetMapping("/fun")
    public ModelAndView getFunModel(){
        ModelAndView modeAndView = new ModelAndView("moodpacage");
        //modeAndView.addObject();
        return modeAndView;
    }

}
