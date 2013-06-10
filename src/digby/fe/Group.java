package digby.fe;

import java.util.List;

public class Group {
	private int groupId;
	private String groupName;
	private List<User> userList;
	private ContactShare contactList;

	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public ContactShare getContactList() {
		return contactList;
	}
	public void setContactList(ContactShare contactList) {
		this.contactList = contactList;
	}
	
	
	
}
