package UI;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.JTextComponent;

import util.Attachment;



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
public class NewInventionSpec extends javax.swing.JFrame {

	public JTextArea getExplanField() {
		return explanField;
	}


	public JTextArea getIndictmentField() {
		return indictmentField;
	}

	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel13;

	private JTextArea indictmentField;
	private JTextArea explanField;

	private JScrollPane jScrollPane2;
	private JButton finishButton;
	private JButton cancelButton;
	private JLabel jLabel14;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private SingleSelectableTableModel<Attachment> filesTableModel;
	private JButton previousButton;
	private JPanel jPanel6;
	private JButton removeFileButton;
	private JButton attachNewFileButton;
	private JTable filesTable;
	private NewInventionSession session;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewInventionSpec inst = new NewInventionSpec();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewInventionSpec() {
		super();
		initGUI();
	}
	
	public NewInventionSpec(NewInventionSession nis) {
		super("جزییات اختراع");
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
			{
				jPanel6 = new JPanel();
				BoxLayout jPanel6Layout = new BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS);
				jPanel6.setLayout(jPanel6Layout);
				getContentPane().add(jPanel6, BorderLayout.CENTER);
				jPanel6.setPreferredSize(new java.awt.Dimension(305, 91));
				{
					jPanel2 = new JPanel();
					jPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
					jPanel6.add(jPanel2);
					jPanel2.setBounds(247, 175, 305, 91);
					jPanel2.setBackground(new java.awt.Color(255,255,255));
					jPanel2.setPreferredSize(new java.awt.Dimension(600, 122));
					{
						indictmentField = new JTextArea();
						jPanel2.add(indictmentField);
						indictmentField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						indictmentField.setBounds(495, 291, 213, 59);
						indictmentField.setPreferredSize(new java.awt.Dimension(463, 89));
						indictmentField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
					{
						jLabel11 = new JLabel();
						jPanel2.add(jLabel11);
						jLabel11.setText("\u0627\u062f\u0639\u0627\u0646\u0627\u0645\u0647:");
						jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel11.setFont(new java.awt.Font("Tahoma",1,12));
						jLabel11.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
						jLabel11.setBounds(621, 255, 108, 33);
						jLabel11.setPreferredSize(new java.awt.Dimension(92, 38));
					}
				}
				{
					jPanel1 = new JPanel();
					jPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
					jPanel6.add(jPanel1);
					jPanel1.setBounds(267, 70, 319, 33);
					jPanel1.setBackground(new java.awt.Color(255,255,255));
					jPanel1.setPreferredSize(new java.awt.Dimension(600, 112));
					{
						explanField = new JTextArea();
						jPanel1.add(explanField);
						explanField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						explanField.setBounds(467, 115, 213, 59);
						explanField.setPreferredSize(new java.awt.Dimension(463, 89));
						explanField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
					{
						jLabel10 = new JLabel();
						jPanel1.add(jLabel10);
						jLabel10.setText("\u0634\u0631\u062d \u0627\u062e\u062a\u0631\u0627\u0639:");
						jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel10.setFont(new java.awt.Font("Tahoma",1,12));
						jLabel10.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
						jLabel10.setBounds(596, 76, 108, 33);
						jLabel10.setPreferredSize(new java.awt.Dimension(92, 38));
					}
				}
				{
					jPanel3 = new JPanel();
					jPanel6.add(jPanel3);
					jPanel3.setBounds(201, 296, 327, 158);
					jPanel3.setBackground(new java.awt.Color(255,255,255));
					jPanel3.setLayout(null);
					jPanel3.setPreferredSize(new java.awt.Dimension(600, 155));
					{
						removeFileButton= new JButton();
						jPanel3.add(removeFileButton);
						removeFileButton.setText("\u062d\u0630\u0641");
						removeFileButton.setBackground(new java.awt.Color(255,236,255));
						removeFileButton.setFont(new java.awt.Font("Tahoma",0,14));
						removeFileButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						removeFileButton.setBounds(41, 67, 56, 21);
						removeFileButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								removeFileButtonActionPerformed();
								
							}
						});
						
						removeFileButton.setEnabled(false);
					}
					{
						attachNewFileButton= new JButton();
						jPanel3.add(attachNewFileButton);
						attachNewFileButton.setText("\u0627\u0636\u0627\u0641\u0647");
						attachNewFileButton.setBackground(new java.awt.Color(255,236,255));
						attachNewFileButton.setFont(new java.awt.Font("Tahoma",0,14));
						attachNewFileButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						attachNewFileButton.setBounds(41, 40, 56, 21);
						attachNewFileButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								attachNewFile();
							}
						});
					}
					{
						jLabel13 = new JLabel();
						jPanel3.add(jLabel13);
						jLabel13.setText("\u0641\u0627\u06cc\u0644 \u0647\u0627\u06cc \u0636\u0645\u06cc\u0645\u0647:");
						jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel13.setFont(new java.awt.Font("Tahoma",1,12));
						jLabel13.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
						jLabel13.setBounds(454, 40, 118, 38);
					}
					{
						jScrollPane2 = new JScrollPane();
						jPanel3.add(jScrollPane2);
						jScrollPane2.setBounds(122, 40, 300, 94);
						{
							filesTableModel = new SingleSelectableTableModel<Attachment>("attachment",
									Attachment.getColumnNames("attachment"),
									new ArrayList<Attachment>());
							filesTable = new FarsiTable();
							jScrollPane2.setViewportView(filesTable);
							filesTable.setModel(filesTableModel);
							filesTableModel.addTableModelListener(new TableModelListener() {
								
								@Override
								public void tableChanged(TableModelEvent tme) {
									System.out.println("table changed");
									switch(tme.getType()){
									case TableModelEvent.DELETE:
										attachNewFileButton.setEnabled(true);
									case TableModelEvent.INSERT:
										if(filesTableModel.getRowCount()==3)
											attachNewFileButton.setEnabled(false);
									case TableModelEvent.UPDATE:
										if(filesTableModel.getSelectedRows().size()==0)
											removeFileButton.setEnabled(false);
										else
											removeFileButton.setEnabled(true);
									}
									
								}
							});
							
						}
						
						
					}
				}
			}

			{
				jPanel4 = new JPanel();
				getContentPane().add(jPanel4, BorderLayout.SOUTH);
				jPanel4.setBackground(new java.awt.Color(255,255,255));
				jPanel4.setPreferredSize(new java.awt.Dimension(600,110));
				jPanel4.setLayout(null);
				{
					jLabel14 = new JLabel();
					jPanel4.add(jLabel14);
					jLabel14.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ax.jpg")));
					jLabel14.setBounds(407, 35, 193, 75);
				}
				{
					cancelButton = new JButton();
					jPanel4.add(cancelButton);
					cancelButton.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
					cancelButton.setBackground(new java.awt.Color(255,236,255));
					cancelButton.setFont(new java.awt.Font("Tahoma",0,14));
					cancelButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					cancelButton.setBounds(21, 48, 112, 41);
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							session.cancel(NewInventionSpec.this);
							
						}
					});
				}
				{
					finishButton = new JButton();
					jPanel4.add(finishButton);
					finishButton.setText("\u0627\u062a\u0645\u0627\u0645");
					finishButton.setBackground(new java.awt.Color(255,236,255));
					finishButton.setFont(new java.awt.Font("Tahoma",0,14));
					finishButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					finishButton.setBounds(145, 48, 112, 41);
					finishButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							session.nextDialog(NewInventionSpec.this,null);
						}
					});
				}
				{
					previousButton = new JButton();
					jPanel4.add(previousButton);
					previousButton.setText("\u0642\u0628\u0644\u06cc");
					previousButton.setBackground(new java.awt.Color(255,236,255));
					previousButton.setFont(new java.awt.Font("Tahoma",0,14));
					previousButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					previousButton.setBounds(269, 48, 112, 41);
					previousButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							session.previousDialog(NewInventionSpec.this);
						}
					});
				}
			}

			pack();
			setSize(600, 550);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	protected void finishButtonMouseClicked() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		
	}

	private void attachNewFile(){
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();

			String filename = JOptionPane.showInputDialog(this, "نام فایل",
					f.getName());
			if (filename == null)
				filename = f.getName();

			Attachment af = new Attachment(filename, f);

			session.inventionFile.getAttachments().add(af);
			af.setStatus(Attachment.Status.added);
			af.setInventionFile(session.inventionFile);
			filesTableModel.setData(session.inventionFile.getAttachments());
		}
		
	}
	
	protected void removeFileButtonActionPerformed() {
		Attachment att = filesTableModel.getSelectedRow();
		if(att.getStatus()==Attachment.Status.added)
			session.inventionFile.getAttachments().remove(att);
		else
			att.setStatus(Attachment.Status.removed);
		
		filesTableModel.setData(session.inventionFile.getAttachments());

	}



}
