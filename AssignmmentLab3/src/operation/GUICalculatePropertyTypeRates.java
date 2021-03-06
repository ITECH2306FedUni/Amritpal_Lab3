package operation;
import javax.swing.*;

import domain.*;

import java.awt.*;
import java.awt.event.*;

public class GUICalculatePropertyTypeRates extends JFrame implements ActionListener{
	/**
	 * @author Amritpal kaur ramana
	 * @version 1.0
	 * @Created 20 may, 2020
	 */
	private static final long serialVersionUID = 1L;
	private JLabel propertyType, valueProperty, lblCategory,lblCharity;
	private JRadioButton r1, r2, r3, r4, r5, r6, c1, c2, c3;
	private JTextField txtValueProperty;
	private JPanel mainPanel, type, category;
	private JCheckBox chkCharityStatus;
	private JButton btnCalculate;
	public GUICalculatePropertyTypeRates()
	{
		super("Calculate Property Type Rates");
		propertyType = new JLabel("Choose Type of Property");
		
		r1 = new JRadioButton("Residential");
		r2 = new JRadioButton("Commercial");
		r3 = new JRadioButton("Industrial");
		r4 = new JRadioButton("Hospital");
		r5 = new JRadioButton("School");
		r6 = new JRadioButton("Other");
		
		valueProperty = new JLabel("Value of Property ");
		txtValueProperty = new JTextField(30);
		
		lblCategory = new JLabel("Select the category size of School or Community Building ");
		c1 = new JRadioButton("Small");
		c2 = new JRadioButton("Medium");
		c3 = new JRadioButton("Large");
		
		
		lblCharity = new JLabel("Tick if rate payer have a charity status? ");
		chkCharityStatus = new JCheckBox();
		
		btnCalculate = new JButton("Calculate Rate");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		bg.add(r5);
		bg.add(r6);
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(c1);
		bg2.add(c2);
		bg2.add(c3);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(9,1));
		
		type = new JPanel();
		type.add(r1);
		type.add(r2);
		type.add(r3);
		type.add(r4);
		type.add(r5);
		type.add(r6);
		
		category = new JPanel();
		category.add(c1);
		category.add(c2);
		category.add(c3);
		
		mainPanel.add(propertyType);
		mainPanel.add(type);
		mainPanel.add(valueProperty);
		mainPanel.add(txtValueProperty);
		mainPanel.add(lblCategory);
		mainPanel.add(category);
		mainPanel.add(lblCharity);
		mainPanel.add(chkCharityStatus);
		mainPanel.add(btnCalculate);
		
		add(mainPanel);
		btnCalculate.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		Property property=null;
		double capitalImprovedValue;
		boolean charityStatus;
		if(r1.isSelected())
		{
			property = new Residential();
		}
		else if(r2.isSelected())
		{
			property = new Commercial();
		}
		else if(r2.isSelected())
		{
			property = new Industrial();
		}
		else if(r2.isSelected())
		{
			property = new Hospital();
		}
		else if(r2.isSelected())
		{
			property = new SchoolCommunity();
		}
		else if(r2.isSelected())
		{
			property = new OtherProperty();
		}
		
		capitalImprovedValue = Double.parseDouble(txtValueProperty.getText());
		
		charityStatus = chkCharityStatus.isSelected();
		
		if (property != null) {
			property.setCapitalImprovedValue(capitalImprovedValue);
			property.setUpExtraServices();
			property.getOwner().setCharity(charityStatus);
			JOptionPane.showMessageDialog(null,"Details Selected: " + property +  "\n" + "Total Rate Costs: " +property.calculateRates() );
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUICalculatePropertyTypeRates screen = new GUICalculatePropertyTypeRates();
		screen.setSize(800, 300);
		screen.setVisible(true);
	}

}
