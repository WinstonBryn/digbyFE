package digby.fe;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class UpdateFe {
public ArrayList<DigitalAsset> ar;

public ArrayList<DigitalAsset> getAr() {
	return ar;
}

public void setAr(ArrayList<DigitalAsset> ar) {
	this.ar = ar;
}

}