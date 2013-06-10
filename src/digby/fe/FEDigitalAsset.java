package digby.fe;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FEDigitalAsset {
private int feId;
private FEDigitalAssetData feData;
public int getFeId() {
	return feId;
}
public void setFeId(int feId) {
	this.feId = feId;
}
public FEDigitalAssetData getFeData() {
	return feData;
}
public void setFeData(FEDigitalAssetData feData) {
	this.feData = feData;
}


}
