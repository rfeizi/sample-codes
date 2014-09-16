package UI;

import invention.InventionFile;
import invention.InventionFileAssesment;
import invention.InventionHome;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import expertise.ExpertiseDomain;
import expertise.ExpertiseHome;

import user.User;
import user.UserHome;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AssignExpertiseForm extends JFrame {
	

	private JButton OKButton;
	private JPanel jPanel1;
	private JButton addToOwnButton;
	private JButton removeFromOwnButton;
	private JLabel jLabel1;
	private JLabel ownDomainsLabel;
	private JButton cancelButton;
	private JPanel jPanel3;

	private User user;
	private JLabel jLabel14;
	private SelectableListModel<ExpertiseDomain> ownDomainsListModel;
	private JList<ExpertiseDomain> ownDomainsList;
	private JList<ExpertiseDomain> allDomainsList;
	private SelectableListModel<ExpertiseDomain> allDomainsListModel;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private ArrayList<ExpertiseDomain> ownDomains;
	private ArrayList<ExpertiseDomain> allDomains;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AssignExpertiseForm inst = new AssignExpertiseForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AssignExpertiseForm() {
		super("تحصیص نقش کارشناسی");
		initGUI();
	}

	public AssignExpertiseForm(User user) {
		super("تحصیص نقش کارشناسی");
		this.user = user;
		ownDomains=new ArrayList<ExpertiseDomain>();
		if(this.user.isExpert())
			ownDomains.addAll(this.user.getExpertiseDomains());
		
		allDomains=new ArrayList<ExpertiseDomain>();
		allDomains.addAll(ExpertiseHome.getInstance().getAllDomains());
		for(ExpertiseDomain domain: ownDomains){
				allDomains.remove(domain);
		}
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3, BorderLayout.SOUTH);
				jPanel3.setLayout(null);
				jPanel3.setBackground(new java.awt.Color(255, 255, 255));
				jPanel3.setPreferredSize(new java.awt.Dimension(600, 110));
				{
					jLabel14 = new JLabel();
					jPanel3.add(jLabel14);
					jLabel14.setBounds(396, 32, 204, 78);
					jLabel14.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("ax.jpg")));
				}
				{
					cancelButton = new JButton();
					jPanel3.add(cancelButton);
					cancelButton
							.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
					cancelButton.setBounds(25, 48, 150, 44);
					cancelButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					cancelButton
							.setBackground(new java.awt.Color(255, 236, 255));
					cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					cancelButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							cancelButtonActionPerformed();
						}
					});
				}

				{
					OKButton = new JButton();
					jPanel3.add(OKButton);
					OKButton.setText("\u0627\u062a\u0645\u0627\u0645");
					OKButton.setBackground(new java.awt.Color(255, 236, 255));
					OKButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					OKButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					OKButton.setBounds(187, 48, 150, 44);
					OKButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							OKButtonActionPerformed();
						}
					});

				}

			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.WEST);
				jPanel1.setPreferredSize(new java.awt.Dimension(584, 252));
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2);
					jScrollPane2.setBounds(55, 84, 176, 137);
					{
						
						allDomainsList = new JList<ExpertiseDomain>();
						jScrollPane2.setViewportView(allDomainsList);
						allDomainsListModel=new SelectableListModel<ExpertiseDomain>(allDomains);
						allDomainsList.setModel(allDomainsListModel);
						allDomainsList.setBounds(55, 84, 176, 137);
						allDomainsList.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
						allDomainsList.addListSelectionListener(new ListSelectionListener() {
							
							@Override
							public void valueChanged(ListSelectionEvent arg0) {
								if(allDomainsList.getSelectedValue()!=null){
									removeFromOwnButton.setEnabled(false);
									addToOwnButton.setEnabled(true);
									ownDomainsList.clearSelection();
								}
								
							}
						});
						
					}
				}

					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(jScrollPane1);
						jScrollPane1.setBounds(354, 84, 176, 137);
						{
							ownDomainsList=new JList<ExpertiseDomain>();
							jScrollPane1.setViewportView(ownDomainsList);

							ownDomainsListModel=new SelectableListModel<ExpertiseDomain>(ownDomains);
							ownDomainsList.setModel(ownDomainsListModel);
							ownDomainsList.setBounds(354, 84, 176, 137);
							ownDomainsList.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					
						}
						ownDomainsList.addListSelectionListener(new ListSelectionListener() {
							
							@Override
							public void valueChanged(ListSelectionEvent arg0) {
								if(ownDomainsList.getSelectedValue()!=null){
									removeFromOwnButton.setEnabled(true);
									addToOwnButton.setEnabled(false);
									allDomainsList.clearSelection();
								}
								
							}
						});
					}

					{
						addToOwnButton = new JButton();
						jPanel1.add(addToOwnButton);
						addToOwnButton.setEnabled(false);
						addToOwnButton.setText("<< \u0627\u0636\u0627\u0641\u0647");
						addToOwnButton.setBackground(new java.awt.Color(255,236,255));
						addToOwnButton.setFont(new java.awt.Font("Tahoma",0,14));
						addToOwnButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						addToOwnButton.setBounds(250, 84, 85, 37);
						addToOwnButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								addToOwnButtonActionPerformed();
							}
						});
						addToOwnButton.setEnabled(false);
					}
					{
						removeFromOwnButton = new JButton();
						jPanel1.add(removeFromOwnButton);
						removeFromOwnButton.setEnabled(false);
						removeFromOwnButton.setText("\u062d\u0630\u0641 >>");
						removeFromOwnButton.setBackground(new java.awt.Color(255,236,255));
						removeFromOwnButton.setFont(new java.awt.Font("Tahoma",0,14));
						removeFromOwnButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						removeFromOwnButton.setBounds(250, 133, 85, 37);
						removeFromOwnButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								removeFromOwnButtonActionPerformed();
							}
						});
						removeFromOwnButton.setEnabled(false);
					}
					{
						ownDomainsLabel = new JLabel();
						jPanel1.add(ownDomainsLabel);
						ownDomainsLabel.setText("\u062d\u0648\u0632\u0647 \u0647\u0627\u06cc \u062a\u062e\u0635\u06cc\u0635 \u062f\u0627\u062f\u0647 \u0634\u062f\u0647 \u0628\u0647 \u06a9\u0627\u0631\u0628\u0631");
						ownDomainsLabel.setBounds(354, 47, 176, 37);
					}
					{
						jLabel1 = new JLabel();
						jPanel1.add(jLabel1);
						jLabel1.setText("\u062d\u0648\u0632\u0647 \u0647\u0627\u06cc \u0645\u0648\u062c\u0648\u062f");
						jLabel1.setBounds(55, 47, 176, 37);
					}
			}

			pack();
			this.setSize(600, 400);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	protected void cancelButtonActionPerformed() {
		this.dispose();
		
	}

	protected void OKButtonActionPerformed() {
		if(!this.user.isExpert()){ //was not expert
			System.out.println("was not expert");
			if(ownDomains.size()!=0){
				System.out.println("coming into this");
				this.user.getExpertiseDomains().addAll(ownDomains);
				UserHome.getInstance().updateUser(this.user);
				for (ExpertiseDomain ed : ownDomains){
					for(InventionFile iFile: ed.getInventionFiles()){
						if(iFile.getInvention()!=null){
							if(iFile.getInvention().getInventionFileAssesments()==null){
								InventionHome.getInstance().saveInventionFileAssesment(iFile.getInvention(), this.user);
							}
						}
					}
				}
				

			}
		}
		else{	//was expert
			Set<ExpertiseDomain> ownDomainsSet=new HashSet<ExpertiseDomain>(ownDomains);
			this.user.setExpertiseDomains(ownDomainsSet);
			UserHome.getInstance().updateUser(this.user);
		}
		
		
		this.dispose();
	
		
	}

	protected void addToOwnButtonActionPerformed() {
		ExpertiseDomain d=allDomainsList.getSelectedValue();
		ownDomains.add(d);
		allDomains.remove(d);
		allDomainsListModel.setData(allDomains);
		ownDomainsListModel.setData(ownDomains);
		
	}

	protected void removeFromOwnButtonActionPerformed() {
		ExpertiseDomain d=ownDomainsList.getSelectedValue();
		allDomains.add(d);
		ownDomains.remove(d);
		allDomainsListModel.setData(allDomains);
		ownDomainsListModel.setData(ownDomains);
	}
}
