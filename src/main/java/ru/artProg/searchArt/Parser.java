package ru.artProg.searchArt;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;

public class Parser {

    private static String IMAGE_DESTINATION_FOLDER = "C:\\Users\\user\\Desktop\\searchArt\\src\\main\\resources\\static\\images";
    private ArrayList<Image> images = new ArrayList<>();


    public void getImg() throws IOException {

//replace it with your URL
//happy
        String strURL = "https://shakko.ru/1383822.html";
//kind
//String strURL = "https://shakko.ru/915167.html?rfrom=shakko_kitsune";
//sad
//String strURL = "https://shakko.ru/1175125.html";

//connect to the website and get the document
        Document document = Jsoup
                .connect(strURL)
                .userAgent("Mozilla/5.0")
                .timeout(10 * 1000)
                .get();

//select all img tags
        Elements imageElements = document.select("img");

//iterate over each image
        for(Element imageElement : imageElements){

//make sure to get the absolute URL using abs: prefix
            String strImageURL = imageElement.attr("abs:src");

//download image one by one
            downloadImage(strImageURL);

        }
        File[] files = new File("C:/images").listFiles();

        for(File f : files) {
            images.add(new ImageIcon(f.getAbsolutePath()).getImage());
        }

    }

    private static void downloadImage(String strImageURL){

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
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + strImageName );

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
