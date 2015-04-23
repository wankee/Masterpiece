package com.lelewan.masterpiece;
import java.io.File;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String address="http://www.365essay.com/jinyongquanji/02/INDEX.HTM";
		//URL url=new URL(address);
		HtmlProcess htmlProcess = new HtmlProcess();
		//htmlProcess.getText("http://www.365essay.com/jinyongquanji/02/002/INDEX.HTM");
		//htmlProcess.getChapters("http://www.365essay.com/jinyongquanji/02/005/INDEX.HTM");
		//new Book("http://www.365essay.com/jinyongquanji/02/IMAGES/04.JPG", "IMAGES/03.JPG").getCover();
		
		File rootDir=new File("C:\\Users\\ann.chen\\Desktop\\download\\novels");
		if(!rootDir.exists()) {
			rootDir.mkdirs();
		}

		List<Book> books=htmlProcess.getBooks(address);
		for (Book book:books){
			book.generate(rootDir);
		}
	}
}
