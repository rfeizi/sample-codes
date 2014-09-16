package UI;


import invention.Invention;
import invention.InventionFile;
import invention.InventionFileEdition;
import invention.InventionHome;
import invention.InventorCollaboration;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import expertise.ExpertiseDomain;
import expertise.NewExpertiseDomainRequest;

import user.User;
import user.UserHome;

public class NewInventionSession {
	
	User creator;
	InventionFile inventionFile;
	InventionFileEdition ife;
	Set<InventorCollaboration> colabs;
	CollabInvention ci;
	AddInventorCollaboration aic;
	public List<User> allInventors;
	private RelatedInvention ri;
	private NewInventionForm ni;
	private NewInventionSpec nispec;
	private DesktopUser duser;
	

	public NewInventionSession(DesktopUser desktopUser, User inventor) {
		creator=inventor;
		inventionFile=new InventionFile(creator);
		ife=new InventionFileEdition(inventionFile,creator);
		allInventors= UserHome.getInstance().getAllInventors();
		allInventors.remove(creator);
		duser=desktopUser;
		 
	}
	
	public void startDialog(){
		ci = new UI.CollabInvention(this);
		ci.setLocationRelativeTo(null);
		ci.setVisible(true);
	}

	public void showAddInventorCollaboration() {
		aic = new AddInventorCollaboration(this);
		aic.setLocationRelativeTo(null);
		aic.setVisible(true);
		
	}

	public void nextDialog(JFrame window,Object obj) {
		if(window==aic){
			User inventor= (User) obj;
			if(inventor!=null){
				inventionFile.addCollaboration(inventor);
				allInventors.remove(inventor);
			}
			aic.dispose();
			ci.updateCollaborationsTable();
		}
		if(window==ci){
			ci.setVisible(false);
			if(ri==null)
				ri = new RelatedInvention(this);
			ri.setLocationRelativeTo(null);
			ri.setVisible(true);
		}
		if(window==ri){
			Invention relatedInv=(Invention) obj;
			inventionFile.setRelatedInvention(relatedInv);
			ri.setVisible(false);
			if(ni==null)
				ni = new UI.NewInventionForm(this);
			ni.setLocationRelativeTo(null);
			ni.setVisible(true);
		}
		if(window==ni){
			if(!ni.allRequiredField())
				JOptionPane.showMessageDialog(ni, "لطفاً فیلدهای ضروری را پر کنید");
			
			else{
			
				inventionFile.setTitle(ni.getInventionTitleField().getText());
				inventionFile.setExpertiseDomain((ExpertiseDomain) obj);
				if(ni.getNewDomainRButton().isSelected()){
					NewExpertiseDomainRequest nedr=new NewExpertiseDomainRequest(inventionFile, ni.getNewDomainField().getText());
					inventionFile.setNewExpertiseDomainRequest(nedr);
				}
				ife.setAbstract_(ni.getAbstractField().getText());
				ife.setHistory(ni.getHistoryField().getText());
				
				ni.setVisible(false);
				if(nispec==null)
					nispec = new UI.NewInventionSpec(this);
				nispec.setLocationRelativeTo(null);
				nispec.setVisible(true);
			}
		}
		if(window==nispec){
			ife.setIndictment(nispec.getIndictmentField().getText());
			ife.setExplan(nispec.getExplanField().getText());
			ife.setEditionExplan("اولین ویرایش");
			//TODO
			inventionFile=InventionHome.getInstance().saveInventionFile(inventionFile);
			nispec.dispose();
			duser.updateInventionsTable();
		}
		
	}
	


	public void previousDialog(JFrame window){
		if(window==ri){
			inventionFile.setRelatedInvention(null);
			ri.setVisible(false);
			ci.setLocationRelativeTo(null);
			ci.setVisible(true);
		}
		if(window==ni){
			inventionFile.setTitle(null);
			inventionFile.setExpertiseDomain(null);
			ife.setAbstract_(null);
			ife.setHistory(null);
			ni.setVisible(false);
			ri.setLocationRelativeTo(null);
			ri.setVisible(true);
			
		}
		
		if(window==nispec){
			nispec.setVisible(false);
			ni.setLocationRelativeTo(null);
			ni.setVisible(true);
		}
	}

	public void cancel(JFrame window) {
		creator.getInventionFiles().remove(inventionFile);
		window.dispose();
		
	}


}
