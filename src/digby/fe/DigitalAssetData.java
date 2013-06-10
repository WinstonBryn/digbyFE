package digby.fe;


public class DigitalAssetData {

	private String daName;
	private int daAppId;
	private Contact daContact;
	
	public String getDaName() {
		return daName;
	}
	public void setDaName(String daName) {
		this.daName = daName;
	}
	public Contact getDaContact() {
		return daContact;
	}
	public void setDaContact(Contact daContact) {
		this.daContact = daContact;
	}
	public int getDaAppId() {
		return daAppId;
	}
	public void setDaAppId(int daAppId) {
		this.daAppId = daAppId;
	}
	
}
