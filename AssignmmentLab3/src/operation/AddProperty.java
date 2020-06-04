package operation;

import java.util.Scanner;

import domain.Hospital;
import domain.Industrial;
import domain.OtherProperty;
import domain.Property;
import domain.RatePayer;
import domain.Residential;
import domain.SchoolCommunity;

/**
 * @author Amritpal kaur ramana
 * @version 1.0
 * 
 * @created 03 june,20
 */
public class AddProperty extends FunctionalDialog {

	PropertyData pdata;
	public AddProperty(Scanner console) {
		super(1,console);
		pdata = new PropertyData();
		pdata.readFromFile();
	}

	@Override
	public void obtainInput(int i) {
		String description, location, valuationDate, category;
		double area, siteValue, capitalImprovedValue,capitalImprovedRate,netAnnualValue;
		System.out.println("Enter Property's Category(Residential/Industrial....) : ");
		category = super.getScanner().nextLine();
		
		System.out.println("Enter Property's Description : ");
		description = super.getScanner().nextLine();
		System.out.println("Enter Property's Location : ");
		location = super.getScanner().nextLine();
		System.out.println("Enter Property's Valuation Date : ");
		valuationDate = super.getScanner().nextLine();
		System.out.println("Enter Property's area: ");
		area = super.getScanner().nextDouble();
		System.out.println("Enter Property's site value : ");
		siteValue = super.getScanner().nextDouble();
		System.out.println("Enter Property's Capital Improved value : ");
		capitalImprovedValue = super.getScanner().nextDouble();
		System.out.println("Enter Property's Capital Improved Rate : ");
		capitalImprovedRate = super.getScanner().nextDouble();
		System.out.println("Enter Property's net annual value : ");
		netAnnualValue = super.getScanner().nextDouble();
		Property property = null;
		if(category.equals("Commercial"))
		{
	//		property = new Commercial();
		}
		else if(category.equals("Industrial"))
		{
			property = new Industrial();
		}
		else if(category.equals("Residential"))
		{
			property = new Residential();
		}
		else if(category.equals("SchoolCommunity"))
		{
			property = new SchoolCommunity();
		}
		else if(category.equals("Hospital"))
		{
			property = new Hospital();
		}
		else
		{
			property = new OtherProperty();
		}
		
		property.setDescription(description);
		property.setLocation(location);
		property.setArea(area);
		property.setSiteValue(siteValue);
		
		pdata.insert(property);
		setStillRunning(false);	
	}

	@Override
	public void respondToInput() {
		System.out.println("\nList of Properties is :\n "+pdata.toString());
		pdata.writeToFile();
	}

}
	
