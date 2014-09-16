package UI;


import invention.Invention;
import invention.InventionHome;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
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
public class RelatedInvention extends javax.swing.JFrame {
	private JLabel relationType;
	private JPanel jPanel1;
	private JCheckBox relatedInventionCheckBox;
	private ButtonGroup relationTypeButtonGroup;
	private JCheckBox allInventionBox;
	private JCheckBox ownInventionBox;
	private ButtonGroup relationButtonGroup;
	private JScrollPane ownInventionPane;
	private JTable ownInventionTable;
	private SingleSelectableTableModel<Invention> ownInventionTableModel;
	private JScrollPane allInventionPane;
	private JButton previousButton;
	private JCheckBox continuationBox;
	private JCheckBox improveBox;
	private JCheckBox partBox;
	private JTable allInventionTable;
	private SingleSelectableTableModel<Invention> allInventionTableModel;
	private TableModelListener selectionListener;
	private JPanel jPanel3;
	private JLabel jLabel14;
	private JButton cancelButton;
	private JButton nextButton;
	private Component[] relationTypeComps;
	private NewInventionSession session;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RelatedInvention inst = new RelatedInvention();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public RelatedInvention(NewInventionSession nis) {
		super("پرونده اختراع مرتبط");
		initGUI();
		session=nis;
		updateInventionTables();
	}
	
	public RelatedInvention(){
		super("پرونده اختراع مرتبط");
		initGUI();
	}
	
	public void updateInventionTables(){
		ownInventionTableModel.setData(InventionHome.getInstance().getCollaboratedInventions(session.creator));
		ownInventionTableModel.fireTableDataChanged();
		
		allInventionTableModel.setData(InventionHome.getInstance().getAllInventions());
		
		allInventionTableModel.fireTableDataChanged();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

			{
				selectionListener = new TableModelListener() {

					@Override
					public void tableChanged(TableModelEvent tme) {
						SelectableTableModel<Invention> tm = (SelectableTableModel<Invention>) tme
								.getSource();
						ArrayList<Invention> srows = tm.getSelectedRows();
						if (srows.isEmpty()) {
							for (Component c: relationTypeComps)
								c.setEnabled(false);
							relationTypeButtonGroup.clearSelection();
						} else
							for (Component c : relationTypeComps)
								c.setEnabled(true);
						
						if(continuationBox.isSelected() || improveBox.isSelected() || partBox.isSelected() || !relatedInventionCheckBox.isSelected())
							nextButton.setEnabled(true);
						else
							nextButton.setEnabled(false);

					}
				};
			}

			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1,
						javax.swing.BoxLayout.Y_AXIS);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBounds(75, 283, 475, 110);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));

				relationButtonGroup = new ButtonGroup();
				{
					relatedInventionCheckBox = new JCheckBox();
					jPanel1.add(relatedInventionCheckBox);
					relatedInventionCheckBox
							.setText("\u0627\u06cc\u0646 \u0627\u062e\u062a\u0631\u0627\u0639 \u0628\u0627 \u0627\u062e\u062a\u0631\u0627\u0639 \u062f\u06cc\u06af\u0631\u06cc \u0627\u0631\u062a\u0628\u0627\u0637 \u062f\u0627\u0631\u062f");
					relatedInventionCheckBox.setBounds(365, 20, 223, 19);
					relatedInventionCheckBox.setFont(new java.awt.Font(
							"Tahoma", 0, 12));
					relatedInventionCheckBox.setBackground(new java.awt.Color(
							255, 255, 255));
					relatedInventionCheckBox.setBorder(BorderFactory
							.createEmptyBorder(0, 0, 10, 10));

					relatedInventionCheckBox
							.setHorizontalTextPosition(SwingConstants.LEFT);
					relatedInventionCheckBox
							.setAlignmentX(Component.RIGHT_ALIGNMENT);
					relatedInventionCheckBox
							.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									if (relatedInventionCheckBox.isSelected()) {
										ownInventionBox.setEnabled(true);
										allInventionBox.setEnabled(true);
									} else {
										relationButtonGroup.clearSelection();
										relationTypeButtonGroup
												.clearSelection();
										SwingUtilities
												.invokeLater(new Runnable() {

													@Override
													public void run() {
														jPanel1.remove(allInventionPane);
														jPanel1.remove(ownInventionPane);

														for (Component c : jPanel1
																.getComponents())
															c.setEnabled(false);
														relatedInventionCheckBox.setEnabled(true);
														jPanel1.revalidate();
														jPanel1.repaint();
													}
												});

									}
								}
							});
				}
				{
					ownInventionBox = new JCheckBox();
					jPanel1.add(ownInventionBox);
					ownInventionBox
							.setText("\u062c\u0633\u062a \u0648 \u062c\u0648 \u0627\u0632 \u0627\u062e\u062a\u0631\u0627\u0639\u0627\u062a \u062e\u0648\u062f");
					ownInventionBox.setFont(new java.awt.Font("Tahoma", 0, 12));
					ownInventionBox.setBackground(new java.awt.Color(255, 255,
							255));
					ownInventionBox.setBorder(BorderFactory.createEmptyBorder(
							0, 0, 10, 20));

					ownInventionBox
							.setHorizontalTextPosition(SwingConstants.LEFT);
					ownInventionBox.setPreferredSize(new java.awt.Dimension(
							178, 24));
					ownInventionBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
					relationButtonGroup.add(ownInventionBox);
					ownInventionBox.setEnabled(false);

					ownInventionBox.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (ownInventionBox.isSelected()) {

								SwingUtilities.invokeLater(new Runnable() {

									@Override
									public void run() {
										jPanel1.remove(allInventionPane);
										jPanel1.add(ownInventionPane, 2);
										allInventionTableModel.clearSelection();
										jPanel1.revalidate();
										jPanel1.repaint();
									}
								});
							}

						}
					});
				}
				{
					ownInventionPane = new JScrollPane();
					//jPanel1.add(ownInventionPane,2);
					ownInventionPane
							.setBackground(new java.awt.Color(79, 0, 55));
					ownInventionPane
							.setFont(new java.awt.Font("Tahoma", 0, 14));
					ownInventionPane.setPreferredSize(new java.awt.Dimension(600, 157));
					{
						ownInventionTableModel = new SingleSelectableTableModel("invention",
								Invention.getColumnNames("invention"),
								new ArrayList<Invention>());
						ownInventionTableModel
								.addTableModelListener(selectionListener);
						ownInventionTable = new FarsiTable();
						ownInventionTable.setFont(new java.awt.Font("Tahoma",
								0, 14));
						ownInventionPane.setViewportView(ownInventionTable);
						ownInventionTable.setModel(ownInventionTableModel);
					}
				}

				{
					allInventionBox = new JCheckBox();
					jPanel1.add(allInventionBox);
					allInventionBox
							.setText("\u062c\u0633\u062a \u0648 \u062c\u0648 \u062f\u0631 \u062a\u0645\u0627\u0645\u06cc \u0627\u062e\u062a\u0631\u0627\u0639\u0627\u062a");

					allInventionBox
							.setHorizontalTextPosition(SwingConstants.LEFT);
					allInventionBox.setBackground(new java.awt.Color(255, 255,
							255));
					allInventionBox.setFont(new java.awt.Font("Tahoma", 0, 12));
					allInventionBox.setPreferredSize(new java.awt.Dimension(
							178, 24));
					allInventionBox.setBorder(BorderFactory.createEmptyBorder(
							0, 0, 10, 20));
					allInventionBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
					relationButtonGroup.add(allInventionBox);
					allInventionBox.setEnabled(false);

					allInventionBox.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if (allInventionBox.isSelected()) {
								SwingUtilities.invokeLater(new Runnable() {

									@Override
									public void run() {
										jPanel1.remove(ownInventionPane);
										ownInventionTableModel.clearSelection();
										jPanel1.add(allInventionPane, 3);
										jPanel1.revalidate();
										jPanel1.repaint();
									}
								});
							}

						}
					});
				}

				{
					allInventionPane = new JScrollPane();
					//jPanel1.add(allInventionPane);
					allInventionPane
							.setBackground(new java.awt.Color(79, 0, 55));
					allInventionPane
							.setFont(new java.awt.Font("Tahoma", 0, 14));
					{
						allInventionTableModel = new SingleSelectableTableModel<Invention>("invention",
								Invention.getColumnNames("invention"),
								new ArrayList<Invention>());

						allInventionTableModel
								.addTableModelListener(selectionListener);

						allInventionTable = new FarsiTable();
						allInventionTable.setFont(new java.awt.Font("Tahoma",
								0, 14));
						allInventionPane.setViewportView(allInventionTable);
						allInventionTable.setModel(allInventionTableModel);
					}
				}

				{
					relationType = new JLabel();
					jPanel1.add(relationType);
					relationType
							.setText("\u0646\u0648\u0639 \u0627\u0631\u062a\u0628\u0627\u0637");
					relationType.setHorizontalAlignment(SwingConstants.RIGHT);
					relationType.setHorizontalTextPosition(SwingConstants.LEFT);
					relationType.setAlignmentX(RIGHT_ALIGNMENT);
					relationType
							.setBackground(new java.awt.Color(255, 255, 255));
					relationType.setFont(new java.awt.Font("Tahoma", 0, 12));
					relationType.setBorder(BorderFactory.createEmptyBorder(20,
							0, 10, 10));
				}

				relationTypeButtonGroup = new ButtonGroup();
				
				

				{
					continuationBox = new JCheckBox();
					jPanel1.add(continuationBox);
					relationTypeButtonGroup.add(continuationBox);
					continuationBox
							.setText("\u0627\u062f\u0627\u0645\u0647 \u0627\u062e\u062a\u0631\u0627\u0639");
					continuationBox
							.setHorizontalAlignment(SwingConstants.RIGHT);
					continuationBox
							.setHorizontalTextPosition(SwingConstants.LEFT);
					continuationBox.setAlignmentX(RIGHT_ALIGNMENT);
					continuationBox.setBackground(new java.awt.Color(255, 255,
							255));
					continuationBox.setFont(new java.awt.Font("Tahoma", 0, 12));
					continuationBox.setBorder(BorderFactory.createEmptyBorder(
							0, 0, 10, 20));
				}

				{
					improveBox = new JCheckBox();
					jPanel1.add(improveBox);
					relationTypeButtonGroup.add(improveBox);
					improveBox
							.setText("\u0628\u0647\u0628\u0648\u062f \u0648 \u06cc\u0627 \u0627\u0635\u0644\u0627\u062d \u0627\u062e\u062a\u0631\u0627\u0639");
					improveBox.setHorizontalAlignment(SwingConstants.RIGHT);
					improveBox.setHorizontalTextPosition(SwingConstants.LEFT);
					improveBox.setAlignmentX(RIGHT_ALIGNMENT);
					improveBox.setBackground(new java.awt.Color(255, 255, 255));
					improveBox.setFont(new java.awt.Font("Tahoma", 0, 12));
					improveBox.setBorder(BorderFactory.createEmptyBorder(0, 0,
							10, 20));
				}

				{
					partBox = new JCheckBox();
					jPanel1.add(partBox);
					relationTypeButtonGroup.add(partBox);
					partBox.setText("\u062c\u0632\u06cc\u06cc \u0645\u062c\u0632\u0627 \u0627\u0632 \u0627\u062e\u062a\u0631\u0627\u0639");
					partBox.setHorizontalAlignment(SwingConstants.RIGHT);
					partBox.setHorizontalTextPosition(SwingConstants.LEFT);
					partBox.setAlignmentX(RIGHT_ALIGNMENT);
					partBox.setBackground(new java.awt.Color(255, 255, 255));
					partBox.setFont(new java.awt.Font("Tahoma", 0, 12));
					partBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 10,
							20));
				}

			}

			{
				for (Component c : jPanel1.getComponents()) {
					c.setEnabled(false);
					if(c instanceof AbstractButton)
						((AbstractButton) c).addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								if(continuationBox.isSelected() || improveBox.isSelected() || partBox.isSelected() || !relatedInventionCheckBox.isSelected())
									nextButton.setEnabled(true);
								else
									nextButton.setEnabled(false);
								
							}
						});
				}
				relatedInventionCheckBox.setEnabled(true);
				relationTypeComps=new Component[]{relationType,continuationBox,partBox,improveBox};
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
					cancelButton.setBounds(25, 48, 112, 41);
					cancelButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					cancelButton
							.setBackground(new java.awt.Color(255, 236, 255));
					cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							session.cancel(RelatedInvention.this);
							
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
					nextButton.setBounds(145, 48, 112, 41);
					nextButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Invention relatedInv=null;
							if(allInventionBox.isSelected()){
								ArrayList<Invention> srows=allInventionTableModel.getSelectedRows();
								relatedInv=srows.get(0);
							}
							if(ownInventionBox.isSelected()){
								ArrayList<Invention> srows=ownInventionTableModel.getSelectedRows();
								relatedInv=srows.get(0);
							}
							session.nextDialog(RelatedInvention.this,relatedInv);
							
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
							session.previousDialog(RelatedInvention.this);
						}
					});
				}
			}

			pack();
			setSize(600, 550);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}
	

}
