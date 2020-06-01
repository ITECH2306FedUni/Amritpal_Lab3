package domain;

/**
 * @author Takeogh
 * @version 1.0
 * @created 02-Apr-2020 8:30:00am
 */
public class OtherProperty extends Property {

	private String specialDescription;
	private static final double CIV_RATE = 0.0030;
	private static final double FIRE_SERVICES_BASE = 150;
	private static final double FIRE_SERVICES_PERCENT = 0.00006;
	private ServiceType fireServicesLevy;
	
	public OtherProperty() {
		super();
		this.setSpecialDescription("None");
		setCapitalImprovedRate(CIV_RATE);
	}

	public String getSpecialDescription() {
		return specialDescription;
	}

	public void setSpecialDescription(String specialDescription) {
		this.specialDescription = specialDescription;
	}

	@Override
	public void setUpExtraServices() {
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire Levy",
				FIRE_SERVICES_BASE,
				FIRE_SERVICES_PERCENT,
				getCapitalImprovedValue());
		
	}

	@Override
	public double calculateExtraServices() {
		return fireServicesLevy.calculateChargeForServiceType();
	}
	
	@Override
	public String toString() {
		return super.toString() + "OtherProperty [\n" +
								  fireServicesLevy.toString() + "]\n ";	
	}

}
