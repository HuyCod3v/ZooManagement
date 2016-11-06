package bo;

import java.util.List;

import dao.LinkJobEmployeeDAO;
import model.LinkJobEmployee;

public class LinkJobEmployeeBO {
	public List<LinkJobEmployee> listAllJob(){
		return new LinkJobEmployeeDAO().listAllJob();
	}
	public boolean createLinkJob(LinkJobEmployee link) {
		return new LinkJobEmployeeDAO().createLinkJob(link);
	}
	
	public boolean deleteLinkJob(String id) {
		return new LinkJobEmployeeDAO().deleteLinkJob(id);
	}
}
