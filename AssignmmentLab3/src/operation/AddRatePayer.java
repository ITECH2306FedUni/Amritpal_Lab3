package operation;
import java.io.File;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.*;

import domain.RatePayer;

/**
 * @author Amritpal kaur ramana
 * @version 1.0
 * @Created 20 may, 2020
 */
public class AddRatePayer extends FunctionalDialog {
	
	RatePayerData rateData ;
	public AddRatePayer(Scanner console) {
		super(1, console);
		rateData = new RatePayerData();
		rateData.readFromFile();
	}

	@Override
	public void obtainInput(int i) {

		String name, address, postcode, phone, type;
		System.out.println("Enter Rate Payer's name : ");
		name = super.getScanner().nextLine();
		System.out.println("Enter Rate Payer's Address : ");
		address = super.getScanner().nextLine();
		System.out.println("Enter Rate Payer's postcode : ");
		postcode = super.getScanner().nextLine();
		System.out.println("Enter Rate Payer's phone : ");
		phone = super.getScanner().nextLine();
		System.out.println("Enter Rate Payer's property type : ");
		type = super.getScanner().nextLine();
		
		RatePayer ratePayer = new RatePayer();
		ratePayer.setName(name);
		ratePayer.setAddress(address);
		ratePayer.setPhone(phone);
		ratePayer.setPostcode(postcode);
		ratePayer.setType(type);
		rateData.insert(ratePayer);
		setStillRunning(false);
	}

	@Override
	public void respondToInput() {
		
		System.out.println("\nList of RatePayers is : \n"+rateData.toString());
		rateData.writeToFile();
		
	}
	public int getNumberOfRatePayers()
	{
		return rateData.getSize();
	}
	}