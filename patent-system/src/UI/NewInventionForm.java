package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.JTextComponent;

import expertise.ExpertiseHome;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class NewInventionForm extends javax.swing.JFrame {


	private JLabel jLabel12;

	private JComboBox domainSelection;	
	
	
	SelectableTableModel inventorsTableModel ;
	private JTextField newDomainField;
	private SelectableTableModel filesTableModel;
	private JButton previousButton;
	private JLabel jLabel9;
	private JTextArea historyField;
	private JPanel jPanel6;
	private JLabel jLabel8;
	private JTextArea abstractField;
	private JPanel jPanel5;
	private JTextField inventionTitleField;
	private JLabel jLabel1;
	private JPanel jPanel4;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JButton nextButton;
	private JButton cancelButton;
	public JTextField getInventionTitleField() {
		return inventionTitleField;
	}

	private JLabel jLabel14;
	private JPanel jPanel3;
	private JRadioButton newDomainRButton;
	private JLabel newDomainNoteLabel;

	private NewInventionSession session;

	private JPanel wrapper;

	private Border redBorder;

	private Border regBorder;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewInventionForm inst = new NewInventionForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewInventionForm() {
		super("کلیات اختراع");
		initGUI();
	}

	
	public JTextArea getHistoryField() {
		return historyField;
	}

	public JTextArea getAbstractField() {
		return abstractField;
	}

	public NewInventionForm(NewInventionSession nis) {
		super("کلیات اختراع");
		initGUI();
		session=nis;
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			
			
			redBorder = BorderFactory.createLineBorder(Color.red);
			regBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3, BorderLayout.SOUTH);
				jPanel3.setBackground(new java.awt.Color(255,255,255));
				jPanel3.setLayout(null);
				jPanel3.setPreferredSize(new java.awt.Dimension(600, 110));
				{
					jLabel14 = new JLabel();
					jPanel3.add(jLabel14);
					jLabel14.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ax.jpg")));
					jLabel14.setBounds(396, 32, 204, 78);
				}
				{
					cancelButton = new JButton();
					jPanel3.add(cancelButton);
					cancelButton.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
					cancelButton.setBackground(new java.awt.Color(255,236,255));
					cancelButton.setFont(new java.awt.Font("Tahoma",0,14));
					cancelButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					cancelButton.setBounds(25, 48, 112, 41);
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							session.cancel(NewInventionForm.this);
							
						}
					});
				}
				{
					previousButton = new JButton();
					jPanel3.add(previousButton);
					previousButton.setText("\u0642\u0628\u0644\u06cc");
					previousButton.setBackground(new java.awt.Color(255,236,255));
					previousButton.setFont(new java.awt.Font("Tahoma",0,14));
					previousButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					previousButton.setBounds(269, 48, 112, 41);
					previousButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							session.previousDialog(NewInventionForm.this);
						}
					});
				}
				{
					nextButton = new JButton();
					jPanel3.add(nextButton);
					nextButton.setText("\u0628\u0639\u062f\u06cc");
					nextButton.setBackground(new java.awt.Color(255,236,255));
					nextButton.setFont(new java.awt.Font("Tahoma",0,14));
					nextButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					nextButton.setBounds(145, 48, 112, 41);
					nextButton.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							session.nextDialog(NewInventionForm.this, domainSelection.getSelectedItem());
							
						}
						
					});
				}
			}
			{
				jPanel1 = new JPanel();
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(255,255,255));
				jPanel1.setPreferredSize(new java.awt.Dimension(381, 418));
				
				{
					jPanel4 = new JPanel();
					jPanel1.add(jPanel4);
					jPanel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
					jPanel4.setBackground(new java.awt.Color(255,255,255));
					jPanel4.setPreferredSize(new java.awt.Dimension(600, 51));
					jPanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 30));
					{
						inventionTitleField = new JTextField();
						jPanel4.add(inventionTitleField);
						inventionTitleField.setPreferredSize(new java.awt.Dimension(239, 22));
						inventionTitleField.setHorizontalAlignment(JTextField.RIGHT);
						inventionTitleField.setPreferredSize(new java.awt.Dimension(231, 33));
					}
					{
						jLabel1 = new JLabel();
						jPanel4.add(jLabel1);
						jLabel1.setText("\u0639\u0646\u0648\u0627\u0646 \u0627\u062e\u062a\u0631\u0627\u0639:");
						jLabel1.setHorizontalTextPosition(SwingConstants.LEFT);
						jLabel1.setFont(new java.awt.Font("Tahoma",1,12));
						jLabel1.setPreferredSize(new java.awt.Dimension(84, 35));
						jLabel1.setAlignmentX(RIGHT_ALIGNMENT);
					}
				}
				{
					jPanel5 = new JPanel();
					jPanel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
					jPanel1.add(jPanel5);
					jPanel5.setBackground(new java.awt.Color(255,255,255));
					jPanel5.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 30));
					{
						abstractField = new JTextArea();
						jPanel5.add(abstractField);
						abstractField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						abstractField.setBounds(495, 187, 213, 59);
						abstractField.setPreferredSize(new java.awt.Dimension(389, 78));
						abstractField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
					{
						jLabel8 = new JLabel();
						jPanel5.add(jLabel8);
						jLabel8.setText("\u0686\u06a9\u06cc\u062f\u0647 \u0627\u062e\u062a\u0631\u0627\u0639:");
						jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel8.setFont(new java.awt.Font("Tahoma",1,12));
						jLabel8.setBounds(621, 148, 108, 33);
						jLabel8.setPreferredSize(new java.awt.Dimension(82, 35));
					}
				}
				{
					jPanel6 = new JPanel();
					jPanel6.setLayout(new FlowLayout(FlowLayout.RIGHT));
					jPanel1.add(jPanel6);
					jPanel6.setBackground(new java.awt.Color(255,255,255));
					jPanel6.setPreferredSize(new java.awt.Dimension(584, 99));
					jPanel6.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 30));
					{
						historyField = new JTextArea();
						jPanel6.add(historyField);
						historyField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						historyField.setBounds(139, 186, 213, 59);
						historyField.setPreferredSize(new java.awt.Dimension(388, 78));
						historyField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
					{
						jLabel9 = new JLabel();
						jPanel6.add(jLabel9);
						jLabel9.setText("\u0633\u0627\u0628\u0642\u0647 \u0627\u062e\u062a\u0631\u0627\u0639:");
						jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel9.setFont(new java.awt.Font("Tahoma",1,12));
						jLabel9.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
						jLabel9.setBounds(181, 148, 194, 33);
						jLabel9.setPreferredSize(new java.awt.Dimension(83, 35));
					}
				}
				{
					wrapper = new JPanel();
					FlowLayout wrapperLayout = new FlowLayout(FlowLayout.RIGHT);
					wrapper.setLayout(wrapperLayout);
					jPanel1.add(wrapper);
					wrapper.setPreferredSize(new java.awt.Dimension(600, 77));
					wrapper.setBackground(new java.awt.Color(255,255,255));
					wrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 30));
					{
						domainSelection = new javax.swing.JComboBox();
						wrapper.add(domainSelection);
						domainSelection.setModel(new javax.swing.DefaultComboBoxModel(ExpertiseHome.getInstance().getAllDomains().toArray()));
						domainSelection.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
						domainSelection.setFont(new java.awt.Font("Tahoma",0,14));
						domainSelection.setPreferredSize(new java.awt.Dimension(231, 33));
						domainSelection.setAlignmentX(RIGHT_ALIGNMENT);
						domainSelection.setBackground(new java.awt.Color(255,232,243));
					}
					{
						jLabel12 = new JLabel();
						wrapper.add(jLabel12);
						jLabel12.setText("\u062d\u0648\u0632\u0647 \u0627\u062e\u062a\u0631\u0627\u0639:");
						jLabel12.setHorizontalTextPosition(SwingConstants.LEFT);
						jLabel12.setFont(new java.awt.Font("Tahoma",1,12));
						jLabel12.setPreferredSize(new java.awt.Dimension(75, 35));
						jLabel12.setAlignmentX(RIGHT_ALIGNMENT);
					}
				}
				{
					jPanel2 = new JPanel();
					jPanel1.add(jPanel2);
					FlowLayout jPanel2Layout = new FlowLayout(FlowLayout.RIGHT);
					jPanel2.setLayout(jPanel2Layout);
					jPanel2.setBackground(new java.awt.Color(255,255,255));
					jPanel2.setPreferredSize(new java.awt.Dimension(600, 73));
					jPanel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 30));
					{
						newDomainField = new JTextField();
						jPanel2.add(newDomainField);
						newDomainField.setBounds(433, 448, 174, 33);
						newDomainField.setVisible(false);
						newDomainField.setPreferredSize(new java.awt.Dimension(231, 33));
						newDomainField.setHorizontalAlignment(JTextField.RIGHT);
					}
					{
						newDomainRButton = new JRadioButton();
						jPanel2.add(newDomainRButton);
						newDomainRButton.setText("\u062d\u0648\u0632\u0647 \u062c\u062f\u06cc\u062f");
						newDomainRButton.setBackground(new java.awt.Color(255,255,255));
						newDomainRButton.setFont(new java.awt.Font("Tahoma",0,14));
						newDomainRButton.setAlignmentX(RIGHT_ALIGNMENT);
						newDomainRButton.setHorizontalAlignment(SwingConstants.RIGHT);
						newDomainRButton.setHorizontalTextPosition(SwingConstants.LEFT);
						newDomainRButton.setPreferredSize(new java.awt.Dimension(79, 35));
						newDomainRButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								if(newDomainRButton.isSelected()){
									newDomainField.setVisible(true);
									newDomainNoteLabel.setVisible(true);
								}else{
									newDomainField.setVisible(false);
									newDomainNoteLabel.setVisible(false);
								}
								
							}
						});
					}
					{
						newDomainNoteLabel = new JLabel();
						jPanel2.add(newDomainNoteLabel);
						newDomainNoteLabel.setText("\u062f\u0631\u062e\u0648\u0627\u0633\u062a \u062d\u0648\u0632\u0647 \u062c\u062f\u06cc\u062f \u062a\u0648\u0633\u0637 \u0645\u062f\u06cc\u0631 \u0628\u0631\u0631\u0633\u06cc \u0634\u062f\u0647 \u0648 \u0646\u062a\u06cc\u062c\u0647 \u0627\u0639\u0644\u0627\u0645 \u062e\u0648\u0627\u0647\u062f \u0634\u062f");
						newDomainNoteLabel.setBounds(453, 487, 267, 15);
						newDomainNoteLabel.setFont(new java.awt.Font("Tahoma",1,8));
						newDomainNoteLabel.setVisible(false);
						newDomainNoteLabel.setPreferredSize(new java.awt.Dimension(326, 24));
						
					}
				}
			}

			pack();
			setSize(600, 550);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	public JRadioButton getNewDomainRButton() {
		// TODO Auto-generated method stub
		return newDomainRButton;
	}

	public JTextField getNewDomainField() {
		return newDomainField;
	}
	
	public boolean allRequiredField(){
		boolean flag= true;
		if(inventionTitleField.getText().equals("")){
			inventionTitleField.setBorder(redBorder);
			flag=false;
		}else
			inventionTitleField.setBorder(regBorder);
		
		if(newDomainRButton.isSelected()){
			if(newDomainField.getText().equals("")){
				newDomainField.setBorder(redBorder);
				flag=false;
			}else
				newDomainField.setBorder(regBorder);
		}
		
		if(abstractField.getText().equals("")){
			abstractField.setBorder(redBorder);
			flag=false;
		}else
			abstractField.setBorder(regBorder);
		
		return flag;
	}

}
