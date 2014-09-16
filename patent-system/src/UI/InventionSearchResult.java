package UI;

import invention.Invention;
import util.TableRowRepresentation;

public class InventionSearchResult implements TableRowRepresentation {

	Invention invention;
	String searchKey;
	boolean foundInInventors;
	boolean foundInTitle;
	boolean foundInHisotry;
	boolean foundInAbstract;
	boolean foundInIndictment;
	boolean foundInExplan;

	public InventionSearchResult(Invention invention, String searchKey) {
		this.invention = invention;
		this.searchKey = searchKey;
		setFoundInAbstract(false);
		setFoundInExplan(false);
		setFoundInHisotry(false);
		setFoundInIndictment(false);
		setFoundInTitle(false);
		setFoundInInventors(false);
	}

	public Invention getInvention() {
		return invention;
	}

	public void setInvention(Invention invention) {
		this.invention = invention;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public boolean isFoundInInventors() {
		return foundInInventors;
	}

	public void setFoundInInventors(boolean foundInInventors) {
		this.foundInInventors = foundInInventors;
	}

	public boolean isFoundInTitle() {
		return foundInTitle;
	}

	public void setFoundInTitle(boolean foundInTitle) {
		this.foundInTitle = foundInTitle;
	}

	public boolean isFoundInHisotry() {
		return foundInHisotry;
	}

	public void setFoundInHisotry(boolean foundInHisotry) {
		this.foundInHisotry = foundInHisotry;
	}

	public boolean isFoundInAbstract() {
		return foundInAbstract;
	}

	public void setFoundInAbstract(boolean foundInAbstract) {
		this.foundInAbstract = foundInAbstract;
	}

	public boolean isFoundInIndictment() {
		return foundInIndictment;
	}

	public void setFoundInIndictment(boolean foundInIndictment) {
		this.foundInIndictment = foundInIndictment;
	}

	public boolean isFoundInExplan() {
		return foundInExplan;
	}

	public void setFoundInExplan(boolean foundInExplan) {
		this.foundInExplan = foundInExplan;
	}

	@Override
	public String[] showRowRepresentation(String type) {
		return new String[]{getInvention().getInventionFile().getTitle(),getFoundInFields()};
	}

	private String getFoundInFields() {
		String fields=new String("");
		if(foundInInventors)
			fields+="مخترعین،";
		
		if(foundInTitle)
			fields+="عنوان اختراع،";
		
		if(foundInAbstract)
			fields+="چکیده،";
		
		if(foundInHisotry)
			fields+="شرح و سابقه ایده،";
		
		if(foundInIndictment)
			fields+="شرح اختراع،";
		
		
		return fields;
	}

	public static String[] getColumnNames() {
		return new String[] {  "نام اختراع","یافت شده در"};
	}

	public boolean isFound() {
		return foundInAbstract || foundInExplan || foundInHisotry
				|| foundInIndictment || foundInInventors || foundInTitle;
	}
	

}
