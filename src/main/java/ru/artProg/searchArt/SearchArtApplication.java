package ru.artProg.searchArt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.IIOException;
import java.io.IOException;

@SpringBootApplication
public class SearchArtApplication {

	public static void main(String[] args) {
		Parser parserImg = new Parser();


		try {
		parserImg.getImg();
		}catch (IIOException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		SpringApplication.run(SearchArtApplication.class, args);
	}

}
