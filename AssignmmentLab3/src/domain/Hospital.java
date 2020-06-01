package domain;

/**
 * @author Amritpal kaur ramana
 * @version 1.0
 * @created 05/05/2020
 */
public class Hospital  extends Property{

	private String type;
	private String facilities;
	private int numberOfFloors;
	
	private static final double CIV_RATE = 0.0035;
	private static final int INDUSTRIAL_WASTE_DISPOSAL_UNITS = 4; 
	private static final double INDUSTRIAL_WASTE_DISPOSAL_FEES = 500.00;
	private static final double FIRE_SERVICES_BASE = 200;
	private static final double FIRE_SERVICES_PERCENT = 0.00006;
	
	private ServiceType industrialWasteDisposal;
	private ServiceType fireServicesLevy;
	
	public Hospital() {
		this.type="Public";
		this.facilities="";
		this.numberOfFloors=0;
		setCapitalImprovedRate(CIV_RATE);
	}
	
	/* Constructors */
	public Hospital(String type, String facilities, int numberOfFloors)
	{
		this.type=type;
		this.facilities=facilities;
		this.numberOfFloors=numberOfFloors;
		setCapitalImprovedRate(CIV_RATE);
	}
	
	/* Setter Methods */
	public void setType(String type)
	{
		this.type =type;
	}
	public void setFacilities(String facilities)
	{
		this.facilities = facilities;
	}
	public void setNumberOfFloors(int numberOfFloors)
	{
		this.numberOfFloors = numberOfFloors;
	}
	
	/* Getter Methods */
	public String getType()
	{
		return type;
	}
	public String getFacilities()
	{
		return facilities;
	}
	public int getNumberOfFloors()
	{
		return numberOfFloors;
	}

	@Override
	public void setUpExtraServices() {
		industrialWasteDisposal = new UnitAndRateService("Waste Management",
				INDUSTRIAL_WASTE_DISPOSAL_UNITS,
				INDUSTRIAL_WASTE_DISPOSAL_FEES);
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire Levy",
																FIRE_SERVICES_BASE,
																FIRE_SERVICES_PERCENT,
																getCapitalImprovedValue());
		
	}

	@Override
	public double calculateExtraServices() {
		
		return industrialWasteDisposal.calculateChargeForServiceType()  +
				   fireServicesLevy.calculateChargeForServiceType();
	}
	
	@Override
	public String toString() {
		return  super.toString() + "Hospital [\n" + 
									industrialWasteDisposal.toString() + "\n" +
									fireServicesLevy.toString() + " ]\n ";
	}
}
