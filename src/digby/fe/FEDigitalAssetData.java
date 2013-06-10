package digby.fe;

import java.util.List;

public class FEDigitalAssetData {
private String feName;
private List<Users> feUserList;
private List<Group> feGroupList;
public String getFeName() {
	return feName;
}
public void setFeName(String feName) {
	this.feName = feName;
}
public List<Users> getFeUserList() {
	return feUserList;
}
public void setFeUserList(List<Users> feUserList) {
	this.feUserList = feUserList;
}
public List<Group> getFeGroupList() {
	return feGroupList;
}
public void setFeGroupList(List<Group> feGroupList) {
	this.feGroupList = feGroupList;
}

}
