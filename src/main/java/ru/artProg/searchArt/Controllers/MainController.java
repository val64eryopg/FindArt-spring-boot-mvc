package ru.artProg.searchArt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.artProg.searchArt.Parser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        File file = new File("C:\\Users\\user\\Desktop\\searchArt\\src\\main\\resources\\static\\images\\766px-Adriaen_Brouwer_-_The_Bitter_Potion_-_Google_Art_Project.jpg");
        modeAndView.addObject("images",file);
        //modeAndView.addObject();

        return modeAndView;
    }

}
