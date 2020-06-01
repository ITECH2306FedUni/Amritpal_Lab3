package operation;
import java.util.*;
import domain.RatePayer;
import java.io.*;
/**
 * @author Amritpal kaur ramana
 * @version 1.0
 * @created 20 may, 2020
 */

public class RatePayerData {
	
	private ArrayList<RatePayer> ratePayers;
	public RatePayerData()
	{
		ratePayers = new ArrayList<RatePayer>();
	}
	public void insert(RatePayer _payer)
	{
		ratePayers.add(_payer);
	}
	
	public int getSize()
	{
		return ratePayers.size();
	}
	public String toString()
	{
		String result="";
		for(RatePayer ratePayer: ratePayers)
		{
			result += "\n"+ratePayer.toString();
		}
		return result;
	}
	public void writeToFile()
	{
		File file = new File("C:\\Users\\RS\\git\\JatinGroup1\\LabAssignment 1 Test\\src\\files\\ITECH2306_2020_Load_RatePayers.txt");
		//File file = new File("ITECH2306_2020_Load_RatePayers.txt");
		
		FileOutputStream fos = null;
		PrintStream outFile = null;

		try {
			fos = new FileOutputStream(file);
			outFile = new PrintStream(fos);
			for(RatePayer payer: ratePayers)
			{
				outFile.println(payer.getName()+","+payer.getAddress()+","+payer.getPostcode()+","+payer.getPhone()+","+ payer.getType()+",false");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error Opening File");
		}

	}
	public void readFromFile()
	{
		
		try
		{
			File file = new File("C:\\Users\\RS\\git\\JatinGroup1\\LabAssignment 1 Test\\src\\files\\ITECH2306_2020_Load_RatePayers.txt");
			//File file = new File("ITECH2306_2020_Load_RatePayers.txt");
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				String line = input.nextLine();
				String values[] = line.split(",");
				RatePayer payer = new RatePayer();
				payer.setName(values[0]);
				payer.setAddress(values[1]);
				payer.setPostcode(values[2]);
				payer.setPhone(values[3]);
				payer.setType(values[4]);
				ratePayers.add(payer);
			}
			file = null;
		}
		catch(Exception ae)
		{
			System.out.println("Error Opening/Reading File");
		}
		
	}
}

