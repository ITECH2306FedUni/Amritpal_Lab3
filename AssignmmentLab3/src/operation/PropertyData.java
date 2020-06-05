package operation;
import java.util.*;
import domain.*;
import java.io.*;

/**
 * @author Amritpal kaur ramana
 * @version 1.0
 * @created 5 june, 2020
 */


public class PropertyData {
	private ArrayList<Property> properties;
	public PropertyData()
	{
		properties = new ArrayList<Property>();
	}
	public void insert(Property _property)
	{
		properties.add(_property);
	}
	
	public int getSize()
	{
		return properties.size();
	}
	public String toString()
	{
		String result="";
		for(Property property: properties)
		{
			result += "\n"+property.toString();
		}
		return result;
	}
	
	public void writeToFile()
	{
		File file = new File("C:\\Users\\RS\\git\\Amritpal_Lab3\\AssignmmentLab3\\src\\files\\ITECH2306_2020_Load_Properties.txt");
		FileOutputStream fos = null;
		PrintStream outFile = null;

		try {
			fos = new FileOutputStream(file);
			outFile = new PrintStream(fos);
			for(Property property: properties)
			{
				outFile.println(property.toString());
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
			File file = new File("C:\\Users\\RS\\git\\Amritpal_Lab3\\AssignmmentLab3\\src\\files\\ITECH2306_2020_Load_Properties.txt");
			Scanner input = new Scanner(file);
			Property property=null;
			while(input.hasNext()) {
				String line = input.nextLine();
				String values[] = line.split(",");
				if(values[0].equals("Commercial"))
				{
			//		property = new Commercial();
				}
				else if(values[0].equals("Industrial"))
				{
					property = new Industrial();
				}
				else if(values[0].equals("Residential"))
				{
					property = new Residential();
				}
				else if(values[0].equals("SchoolCommunity"))
				{
					property = new SchoolCommunity();
				}
				else if(values[0].equals("Hospital"))
				{
					property = new Hospital();
				}
				else
				{
					property = new OtherProperty();
				}
				
				property.setDescription(values[1]);
				property.setLocation(values[2]);
				property.setArea(Double.parseDouble(values[3]));
				property.setSiteValue(Double.parseDouble(values[4]));
				
				properties.add(property);
			}
			file = null;
		}
		catch(Exception ae)
		{
			System.out.println("Error Opening/Reading File");
		}
		
	}
}