package tail;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FTail {
	File file = new File("C:\\Temp\\1.lst");
	File forward_file = new File("C:\\Temp\\1.lst");
	int TailSize = 100;
	
	BufferedReader reader = null;
	BufferedReader forward_reader = null;
	
	public static void main(String[] args) {
		int c = 'Ж';
		System.out.println(c);
		// TODO Auto-generated method stub
		FTail ftail = new FTail();
		//ftail.printTail();
		//System.out.println(ftail.reverse("QWERTY"));
		//System.out.println(ftail.removeDuplicates("QWERTTTYRETTQTY"));
	}
	
	public String reverse(String src) {
		StringBuilder target = new StringBuilder();
		for (int i = src.length(); i > 0; i--) {
			target.append(src.charAt((i-1)));
		}
		return target.toString();
	}
	
	public String removeDuplicates(String str) {
	    boolean seen[] = new boolean[256];
	    StringBuilder sb = new StringBuilder(seen.length);

	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        if (!seen[ch]) {
	            seen[ch] = true;
	            sb.append(ch);
	        }
	    }

	    return sb.toString();
	}
	
	private void printTail() {
	try {
		String text = null;
		int linesRead  = 0;
		reader = new BufferedReader(new FileReader(file));
		forward_reader = new BufferedReader(new FileReader(forward_file));
	   
		//Read forward_reader line by line
		while (forward_reader.readLine() != null) {
	    	if (linesRead < TailSize) {
	    		linesRead++;
	    	}
	    	else {
	    		//Read next line in reader
	    		reader.readLine();
	    	}
	    }
	    
		while ((text = reader.readLine()) != null) {
			System.out.println(text);
		}
	    
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {    
		if (forward_reader != null) {
	            forward_reader.close();
	        }
		if (reader != null) {
            reader.close();
        }
	    } catch (IOException e) {
	    }
	}
 }
}
