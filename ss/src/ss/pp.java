package ss;



import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class pp {
	public static void main(String[] args) {
	String url = "www.17k.com";
	try {
		Document document= Jsoup.connect(url).get();
		String title = document.title();
		System.out.println("title:"+title);
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
	}
