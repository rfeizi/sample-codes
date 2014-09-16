package UI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


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
@SuppressWarnings("serial")
public class AddInventorCollaboration extends javax.swing.JFrame {


	private JTable inventorsTable;
	private JScrollPane jScrollPane1;
	private JPanel jPanel3;

	private JButton cancelButton;
	private JLabel jLabel14;

	SelectableTableModel<User> inventorsTableModel;
	private JPanel jPanel1;
	private JButton addButton;


	private NewInventionSession session;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddInventorCollaboration inst = new AddInventorCollaboration();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AddInventorCollaboration() {
		super();
		initGUI();

	}


	public AddInventorCollaboration(NewInventionSession nis) {
		super("افزودن مخترع");
		session=nis;
		initGUI();

	}


	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

			{
				jPanel1 = new JPanel();
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1,
						javax.swing.BoxLayout.Y_AXIS);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));

					{
						jScrollPane1 = new JScrollPane();
						jPanel1.add(jScrollPane1);
						jScrollPane1.setBounds(135, 12, 386, 77);
						{
							inventorsTableModel = new SingleSelectableTableModel<User>("inventor",
									User.getColumnNames("inventor"),
									session.allInventors);
							inventorsTableModel
									.addTableModelListener(new TableModelListener() {

										@Override
										public void tableChanged(
												TableModelEvent tme) {
											System.out.println("table changed");
											switch (tme.getType()) {
											case TableModelEvent.DELETE:
											case TableModelEvent.INSERT:
											case TableModelEvent.UPDATE:
												if (inventorsTableModel
														.getSelectedRows()
														.size() == 0)
													addButton.setEnabled(false);
												else{
													addButton.setEnabled(true);
												}
											}

										}
									});
							inventorsTable = new FarsiTable();
							jScrollPane1.setViewportView(inventorsTable);
							inventorsTable.setModel(inventorsTableModel);
						}
					}
					
				}
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
							session.nextDialog(AddInventorCollaboration.this,null);
							
						}
					});
					
				}
				{
					addButton = new JButton();
					jPanel3.add(addButton);
					addButton.setText("\u0630\u062e\u06cc\u0631\u0647");
					addButton.setBackground(new java.awt.Color(255, 236, 255));
					addButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					addButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					addButton.setBounds(187, 48, 150, 44);
					addButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ArrayList<User> srows=inventorsTableModel.getSelectedRows();
							session.nextDialog(AddInventorCollaboration.this,srows.get(0));
						}
					});
					addButton.setEnabled(false);
				}
			}

			pack();
			this.setSize(600, 289);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
