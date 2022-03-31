package ru.artProg.searchArt;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;

public class Parser {

    public static void main(String[] args) throws IOException {
        String IMAGE_DESTINATION_FOLDER = "C:\\Users\\Stas\\Desktop\\FindArt-spring-boot-mvc\\src\\main\\resources\\static\\images";
        System.out.println(getImg(IMAGE_DESTINATION_FOLDER,"https://shakko.ru/1383822.html"));
        //happy
        //String strURL = "https://shakko.ru/1383822.html";
        //kind
        //String strURL = "https://shakko.ru/915167.html?rfrom=shakko_kitsune";
        //sad
        //String strURL = "https://shakko.ru/1175125.html";
    }

    public static ArrayList<String> getImg(String IMAGE_DESTINATION_FOLDER, String strURL) throws IOException {

        ArrayList<String> images = new ArrayList<>();
        //replace it with your URL

        //connect to the website and get the document
        Document document = Jsoup
                .connect(strURL)
                .userAgent("Mozilla/5.0")
                .timeout(10 * 1000)
                .get();

        //select all img tags
        Elements imageElements = document.select("img");
        Integer count = 1;
        //iterate over each image
        for(Element imageElement : imageElements){

            //make sure to get the absolute URL using abs: prefix
            String strImageURL = imageElement.attr("abs:src");

            //download image one by one
            if(strImageURL.contains("wiki")) {
                downloadImage(strImageURL, count, IMAGE_DESTINATION_FOLDER);
                images.add(IMAGE_DESTINATION_FOLDER + "/" + "img_"+count.toString()+".jpg");
                count += 1;
            }

        }

        return images;
    }

    private static void downloadImage(String strImageURL, Integer count, String IMAGE_DESTINATION_FOLDER){

        //get file name from image path
        String strImageName =
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );

        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

        try {

            //open the stream from URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os =
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + "img_"+count.toString()+".jpg");

            //write bytes to the output stream
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

            System.out.println("Image saved");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
