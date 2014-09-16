package UI;

import invention.Invention;
import invention.Invention.Status;
import invention.InventionFile;
import invention.InventionFileEdition;
import invention.InventionHome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import user.User;
import util.Attachment;
import util.AttachmentHome;


public class InventionFileChangeSession{
	
	public InventionFile inventionFile;
	public InventionFileEdition inventionFileEdition;
	public InventionForm ifc;
	public EditionExplanForm eef;
	public InventionEditionsForm ief;
	public User editor;
	public InventionFileEdition lastEdition;
	public Set<InventionFileEdition> editions;
	public DesktopUser duser;
	public Set<Attachment> attachments;
	
	public InventionFileChangeSession(DesktopUser duser, InventionFile ifile,User editor) {
		this.duser=duser;
		inventionFile=ifile;
		this.editor=editor;
		lastEdition=ifile.getLastEdition();
		editions=inventionFile.getInventionFileEditions();
		attachments=inventionFile.getAttachments();
	}

	public void startDialog() {
		ifc = new UI.InventionForm(this);
		ifc.setLocationRelativeTo(null);
		ifc.setVisible(true);
	}

	public void nextDialog(JFrame window,Object obj) {
		
		if(window==ifc){
			if(inventionFileEdition==null)
				inventionFileEdition=new InventionFileEdition();
			inventionFileEdition.setAbstract_(ifc.getAbstractField().getText());
			inventionFileEdition.setIndictment(ifc.getIndictmentField().getText());
			inventionFileEdition.setExplan(ifc.getExplanField().getText());
			inventionFileEdition.setHistory(ifc.getHistoryField().getText());
			
			if(obj!=null){
				if(obj.equals("send")){
					int returnVal=JOptionPane.showConfirmDialog(ifc, "آیا برای ارسال نهایی اختراع اطمینان دارید؟", "اخطار", JOptionPane.YES_NO_OPTION);
					if(returnVal==JOptionPane.YES_OPTION){
						inventionFileEdition.setEditionExplan("ویرایش نهایی");
						if(editor.getUnderStudyInventionFiles().size()>2){
							JOptionPane.showMessageDialog(ifc, "شما در حال حاظر بیشتر از 3 اختراع در حال بررسی دارید. برای ثبت این اختراع باید اجازه توسط مدیر صادر شود");
							InventionHome.getInstance().saveFinalInventionFileEdition(inventionFileEdition, inventionFile, editor,Status.authorizing);
							InventionFileEdition life=inventionFile.getLastEdition();
							
						}
						else{
							Invention invention=InventionHome.getInstance().saveFinalInventionFileEdition(inventionFileEdition, inventionFile, editor,Status.pending);
						
						
							if(invention.getInventionFile().getNewExpertiseDomainRequest()==null){
								Set<User> experts=invention.getInventionFile().getExpertiseDomain().getExperts();
								if(!experts.isEmpty()){
									User expert=(User)experts.toArray()[0];
									InventionHome.getInstance().saveInventionFileAssesment(invention,expert);
								}else{
									JOptionPane.showMessageDialog(ifc, "اختراع ارسال شد ولی هنوز کارشناسی در حوزه انتخابی شما نیست.");
								}
							}else{
								JOptionPane.showMessageDialog(ifc, "اختراع ارسال شد ولی برای بررسی توسط کارشناس ابتدا باید حوزه جدید درخواستی توسط مدیر تایید شود.");
							}
						}
						ifc.dispose();
						duser.updateInventionsTable();
					}else{
						// nothing
					}
				}
			}else{
					
				if(eef==null)
					eef=new EditionExplanForm(this);
				ifc.setVisible(false);
				eef.setLocationRelativeTo(null);
				eef.setVisible(true);
			}
		}
		if(window==eef){
			inventionFileEdition.setEditionExplan(eef.getEditionExplanField().getText());
			InventionHome.getInstance().saveInventionFileEdition(inventionFileEdition,inventionFile,editor);
			eef.dispose();
			ifc.dispose();
		}
		
		if(window==ief){
			InventionFileEdition ife=(InventionFileEdition) obj;
			ifc.getAbstractField().setText(ife.getAbstract_());
			ifc.getHistoryField().setText(ife.getHistory());
			ifc.getExplanField().setText(ife.getExplan());
			ifc.getIndictmentField().setText(ife.getIndictment());
			ief.dispose();
		}
		
	}

	public void showOlderEditions() {
		ief = new UI.InventionEditionsForm(this);
		ief.setLocationRelativeTo(null);
		ief.setVisible(true);
		
	}

	public void previousDialog(JFrame window) {
		if(window==ief){
			ief.dispose();
			ifc.dispose();
		}
		if(window==eef){
			ifc.setVisible(true);
		}
		
	}
	
}
