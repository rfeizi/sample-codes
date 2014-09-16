package UI;

import invention.InventionFileEdition;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


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
public class InventionEditionsForm extends JFrame {
	
	
	private JPanel jPanel3;
	private JButton cancelButton;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable editionTable;
	private JButton retrieveButton;
	private JLabel jLabel14;
	private SingleSelectableTableModel<InventionFileEdition> InventionEditionsTableModel;
	private InventionFileChangeSession session;
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InventionEditionsForm inst = new InventionEditionsForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public InventionEditionsForm(){
		initGUI();
	}

	public InventionEditionsForm(
			InventionFileChangeSession inventionFileChangeSession) {
		super("ویرایش های پرونده اختراع");
		session=inventionFileChangeSession;
		initGUI();
		InventionEditionsTableModel.setData(session.editions);
		
	}

	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				getContentPane().setLayout(thisLayout);
				{
					jPanel3 = new JPanel();
					getContentPane().add(jPanel3, BorderLayout.SOUTH);
					jPanel3.setBackground(new java.awt.Color(255, 255, 255));
					jPanel3.setPreferredSize(new java.awt.Dimension(600, 109));
					jPanel3.setLayout(null);
					jPanel3.setBounds(22, 525, 599, 112);
					{
						jLabel14 = new JLabel();
						jPanel3.add(jLabel14);
						jLabel14.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("ax.jpg")));
						jLabel14.setBounds(396, 32, 204, 78);
					}
					{
						cancelButton = new JButton();
						jPanel3.add(cancelButton);
						cancelButton
								.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
						cancelButton.setBackground(new java.awt.Color(255, 236,
								255));
						cancelButton
								.setFont(new java.awt.Font("Tahoma", 0, 14));
						cancelButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						cancelButton.setBounds(25, 48, 112, 41);
						cancelButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								session.previousDialog(InventionEditionsForm.this);
								
							}
						});
					}
					{
						retrieveButton = new JButton();
						jPanel3.add(retrieveButton);
						retrieveButton.setText("\u0628\u0627\u0632\u06cc\u0627\u0628\u06cc \u0648\u06cc\u0631\u0627\u06cc\u0634");
						retrieveButton.setBackground(new java.awt.Color(255,
								236, 255));
						retrieveButton.setFont(new java.awt.Font("Tahoma", 0,
								14));
						retrieveButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						retrieveButton.setBounds(145, 48, 112, 41);
						retrieveButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								InventionFileEdition ife=InventionEditionsTableModel.getSelectedRow();
								session.nextDialog(InventionEditionsForm.this,ife);
							}
						});
						
						retrieveButton.setEnabled(false);
					}
					
				}
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1, BorderLayout.CENTER);
					jPanel1.setBackground(new java.awt.Color(255,255,255));
					jPanel1.setLayout(null);
					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(jScrollPane1);
						jScrollPane1.setBackground(new java.awt.Color(255,255,255));
						jScrollPane1.setBounds(36, 37, 522, 213);
						{
							InventionEditionsTableModel = new SingleSelectableTableModel<InventionFileEdition>(
									"invention_file_edition",
									InventionFileEdition.getColumnNames(),
									new ArrayList<InventionFileEdition>());
							editionTable = new FarsiTable();
							jScrollPane1.setViewportView(editionTable);
							editionTable.setModel(InventionEditionsTableModel);
							InventionEditionsTableModel.addTableModelListener(new TableModelListener() {
								
								@Override
								public void tableChanged(TableModelEvent tme) {
									ArrayList<InventionFileEdition> srows=InventionEditionsTableModel.getSelectedRows();
									retrieveButton.setEnabled(!srows.isEmpty());
								}
							});
							
						}
					}
				}
			}
			pack();
			setSize(600, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
