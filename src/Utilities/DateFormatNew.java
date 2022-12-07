package Utilities;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateFormatNew {
		
	public static File create(List<Date> a, File g) {
		try {
			FileWriter writer = new FileWriter(g);
			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat("mm/dd/yyyy");
			for (Date d : a) {
				 writer.write(formatter.format(d));
				 writer.flush();
				 writer.close();
			 }
		
		}catch(IOException u) {
			
		}
		catch(Exception c) {
			
		}
		finally {
			
		}
		return g;
	}

}
