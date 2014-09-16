package UI;

import invention.InventionFile;
import invention.InventorCollaboration;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

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
public class CollabInvention extends javax.swing.JFrame {

	private ArrayList<InventorCollaboration> collabs;

	private JButton addInventorButton;
	private JButton removeInventorButton;
	private JTable inventorsTable;
	private JScrollPane jScrollPane1;
	private JPanel jPanel3;

	private JButton cancelButton;
	private JLabel jLabel14;

	SingleSelectableTableModel<InventorCollaboration> inventorsTableModel;
	private ButtonGroup collabTypeGroup;
	private JPanel jPanel2;
	private JCheckBox groupInventionBox;
	private JCheckBox singleInventionBox;
	private JPanel jPanel1;
	private JButton nextButton;

	private NewInventionSession session;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CollabInvention inst = new CollabInvention();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public CollabInvention() {
		super();
		initGUI();

	}

	public CollabInvention(NewInventionSession nis) {
		super("انتخاب مخترعین");
		session = nis;
		initGUI();
		updateCollaborationsTable();

	}

	public void updateCollaborationsTable() {

		inventorsTableModel.setData(session.inventionFile
				.getInventorCollaborations());

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

			{
				collabTypeGroup = new ButtonGroup();
			}

			{
				jPanel1 = new JPanel();
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1,
						javax.swing.BoxLayout.Y_AXIS);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setBounds(30, 10, 545, 151);
				jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
				jPanel1.setPreferredSize(new java.awt.Dimension(81, 80));
				{
					singleInventionBox = new JCheckBox();
					jPanel1.add(singleInventionBox);
					collabTypeGroup.add(singleInventionBox);
					singleInventionBox
							.setText("\u0627\u062e\u062a\u0631\u0627\u0639 \u0641\u0631\u062f\u06cc ");
					singleInventionBox.setFont(new java.awt.Font("Tahoma", 0,
							12));
					singleInventionBox.setBackground(new java.awt.Color(255,
							255, 255));
					singleInventionBox.setBorder(BorderFactory
							.createEmptyBorder(0, 0, 10, 0));
					singleInventionBox
							.setHorizontalAlignment(SwingConstants.RIGHT);
					singleInventionBox
							.setHorizontalTextPosition(SwingConstants.LEFT);
					singleInventionBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
					singleInventionBox.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (singleInventionBox.isSelected()) {
								nextButton.setEnabled(true);
								SwingUtilities.invokeLater(new Runnable() {

									@Override
									public void run() {
										inventorsTableModel.clearSelection();
										jPanel1.remove(jPanel2);
										jPanel1.revalidate();
										jPanel1.repaint();
									}
								});
							}

						}
					});
				}

				{
					groupInventionBox = new JCheckBox();
					jPanel1.add(groupInventionBox);
					collabTypeGroup.add(groupInventionBox);
					groupInventionBox
							.setText("\u0627\u062e\u062a\u0631\u0627\u0639 \u06af\u0631\u0648\u0647\u06cc");
					groupInventionBox
							.setFont(new java.awt.Font("Tahoma", 0, 12));
					groupInventionBox.setBackground(new java.awt.Color(255,
							255, 255));
					groupInventionBox.setBorder(BorderFactory
							.createEmptyBorder(0, 0, 10, 0));
					groupInventionBox
							.setHorizontalAlignment(SwingConstants.RIGHT);
					groupInventionBox
							.setHorizontalTextPosition(SwingConstants.LEFT);
					groupInventionBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
					groupInventionBox.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (groupInventionBox.isSelected()) {
								nextButton.setEnabled(true);

								SwingUtilities.invokeLater(new Runnable() {

									@Override
									public void run() {
										jPanel1.add(jPanel2);
										jPanel1.revalidate();
										jPanel1.repaint();
									}
								});
							}

						}
					});
				}
				{
					jPanel2 = new JPanel();
					// jPanel1.add(jPanel2);
					jPanel2.setBackground(new java.awt.Color(255, 255, 255));
					jPanel2.setLayout(null);
					{
						addInventorButton = new JButton();
						jPanel2.add(addInventorButton);
						addInventorButton
								.setText("\u0627\u0636\u0627\u0641\u0647");
						addInventorButton.setBackground(new java.awt.Color(255,
								236, 255));
						addInventorButton.setFont(new java.awt.Font("Tahoma",
								0, 14));
						addInventorButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						addInventorButton.setBounds(46, 22, 66, 21);
						addInventorButton
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent ae) {
										session.showAddInventorCollaboration();

									}

								});
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel2.add(jScrollPane1);
						jScrollPane1.setBounds(135, 12, 386, 90);
						{
							inventorsTableModel = new SingleSelectableTableModel<InventorCollaboration>(
									"inventor_collaboration",
									InventorCollaboration.getColumnNames(null),
									new ArrayList<InventorCollaboration>()) {

								@Override
								public void setValueAt(Object v, int r, int c) {
									if (c < 2)
										super.setValueAt(v, r, c);
									else {
										try {
											String str=(String) v;
												Double value =  Double.parseDouble(str);
												if (c == 2) {
													data.get(r).setFinancialShareAndUpdate(
															value);
													updateCollaborationsTable();
												} else if (c == 3) {
													data.get(r).setSpiritualShareAndUpdate(
															value);
													
													updateCollaborationsTable();
												
											}
										}catch(NumberFormatException ex){
												JOptionPane.showMessageDialog(CollabInvention.this,"لطفاً یک عدد معتبر وارد کنید");
											
										} catch (Exception ex) {
												JOptionPane.showMessageDialog(CollabInvention.this,"لطفاً عددی بین 0 و 100 وارد کنید");
										}

									}
								}

								@Override
								public boolean isCellEditable(int r, int c) {
									if(inventorsTableModel.data.size()==1)
										return false;
									if(c==2)
										return true;
									if(c==3)
										return true;
									return super.isCellEditable(r, c);
								}
								
								

							};

							inventorsTableModel
									.addTableModelListener(new TableModelListener() {

										@Override
										public void tableChanged(
												TableModelEvent tme) {
											System.out.println("table changed");

											if (inventorsTableModel
													.getSelectedRows().size() == 0)
												removeInventorButton
														.setEnabled(false);
											else{
												InventorCollaboration ic=inventorsTableModel.getSelectedRow();
												if(ic.getInventor()!=session.creator)
													removeInventorButton
															.setEnabled(true);
											}
											if (inventorsTableModel
													.getRowCount() == 3)
												addInventorButton
														.setEnabled(false);
											else
												addInventorButton
														.setEnabled(true);

										}
									});
							inventorsTable = new FarsiTable();
							jScrollPane1.setViewportView(inventorsTable);
							inventorsTable.setModel(inventorsTableModel);
						}
					}
					{
						removeInventorButton = new JButton();
						jPanel2.add(removeInventorButton);
						removeInventorButton.setText("\u062d\u0630\u0641");
						removeInventorButton.setBackground(new java.awt.Color(
								255, 236, 255));
						removeInventorButton.setFont(new java.awt.Font(
								"Tahoma", 0, 14));
						removeInventorButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						removeInventorButton
								.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent arg0) {
										removeInventorButtonActionPerformed();

									}
								});
						removeInventorButton.setEnabled(false);
						removeInventorButton.setBounds(46, 49, 66, 21);
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
							session.cancel(CollabInvention.this);

						}
					});
				}
				{
					nextButton = new JButton();
					jPanel3.add(nextButton);
					nextButton.setText("\u0628\u0639\u062f\u06cc");
					nextButton.setBackground(new java.awt.Color(255, 236, 255));
					nextButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					nextButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					nextButton.setBounds(187, 48, 150, 44);
					nextButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							session.nextDialog(CollabInvention.this, null);
						}
					});

					nextButton.setEnabled(false);
				}
			}

			pack();
			this.setSize(600, 340);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	protected void removeInventorButtonActionPerformed() {
		InventorCollaboration ic = (InventorCollaboration) inventorsTableModel
				.getSelectedRow();
			
		session.inventionFile.removeCollaboration(ic);
		updateCollaborationsTable();

	}

}
