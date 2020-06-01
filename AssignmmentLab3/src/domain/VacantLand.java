package domain;

/**
 * @author Amritpal kaur Ramana
 * @version 1.0
 * @created 09/05/2020
 */
public class VacantLand extends Property{

	private String[] overlays;
	
	private static final double CIV_RATE = 0.002;
	private static final double FIRE_SERVICES_BASE = 110;
	private static final double FIRE_SERVICES_PERCENT = 0.00006;

	private ServiceType fireServicesLevy;
	
	public VacantLand() {
		super();
		overlays = null;
		fireServicesLevy = null;
		setCapitalImprovedRate(CIV_RATE);
	}
	
	
	
	public String[] getOverlays() {
		return overlays;
	}
	public void setOverlays(String[] overlays) {
		this.overlays = overlays;
	}
	@Override
	public double calculateExtraServices() {
		return  fireServicesLevy.calculateChargeForServiceType();
	}
	@Override
	public void setUpExtraServices() {
		fireServicesLevy = new BaseAndPercentageOfValueService("Fires Levy",
				FIRE_SERVICES_BASE,
				FIRE_SERVICES_PERCENT,
				getCapitalImprovedValue());

		
	}

}
