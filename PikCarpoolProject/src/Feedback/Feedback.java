package Feedback;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Feedback {

	private int arrivalTimeRating;
    private int proffesionalismRating;
	private int driverRating;
	private int carQualityRating;
	private String comment;
	
	public int getarrivalTimeRating() {
		return arrivalTimeRating;
	}
	public void setarrivalTimeRating(int arrivalTimeRating) { 
		this.arrivalTimeRating = arrivalTimeRating; 
		} 
	public int getproffesionalismRating() {
		return proffesionalismRating;
	}
	public void setproffesionalismRating(int proffesionalismRating) { 
		this.proffesionalismRating = proffesionalismRating; 
		} 
	
	public int getdriverRating() {
		return driverRating;
	}
	public void setdriverRating(int driverRating) { 
		this.driverRating = driverRating; 
		} 
	
	public int getcarQualityRating() {
		return carQualityRating;
	}
	public void setcarQualityRating(int carQualityRating) { 
		this.carQualityRating = carQualityRating; 
		} 
	
	public String getcomment() {
		return comment;
	}
	public void setcomment(String comment) { 
		this.comment = comment; 
		} 
	
	public void createReview()
	{
		 Console input;
		 int arrivalTimeRating = 0;
		   int proffesionalismRating = 0;
			int driverRating=0;
			int carQualityRating=0;
			String comment=null;
		  	  
		  try
		  {
		     input = System.console();
		   
		     if (input!= null)
		     {
		    	 arrivalTimeRating=  Integer.parseInt(input.readLine());
		    	 System.out.println("ArrivalTime : " + arrivalTimeRating);
		    	 proffesionalismRating = Integer.parseInt(input.readLine());
		    	 System.out.println("Professionalism: " + proffesionalismRating);
				 driverRating= Integer.parseInt(input.readLine());
				 System.out.println("Driver: " + driverRating);
				 carQualityRating= Integer.parseInt(input.readLine());
				 System.out.println("Car Quality: " +carQualityRating);
				 comment= input.readLine();
				 System.out.println("Comment: " + comment);
		           
		     }
		  } catch (Exception exception)
		  {
		     exception.printStackTrace();
		  }
		}

	
	public void saveReview()
	{
		BufferedWriter save = null;

		try {
		    save = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("feedback.txt"), "utf-8"));
		    save.write("ArrivalTime: " + arrivalTimeRating);
		    save.write("Professionalism: " + proffesionalismRating);
		    save.write("Driver:" + driverRating);
		    save.write("Car Quality:" + carQualityRating);
		    save.write("Comments:" + comment);
		    
		} catch (IOException ex) 
		{
		 ex.printStackTrace();
		} 
		
		finally {
		   try {save.close();} catch (Exception ex) {}
		}
		
		
		
		
	}
	
public void retrieveReview()                                                                                                                                                                                               
		
{
	try {BufferedReader br=new BufferedReader(new FileReader("feedback.txt"));
	String lines = null;
	while ((lines=br.readLine())!=null)
		{String review[]=lines.split("\t");
        arrivalTimeRating=Integer.parseInt(review[0]);
        proffesionalismRating=Integer.parseInt(review[1]);
        driverRating=Integer.parseInt(review[2]);
        carQualityRating=Integer.parseInt(review[3]);
        comment=review[4];
		} 
	
	br.close();}
	
	
	catch(IOException exc){exc.printStackTrace();}
	
	
	}



}