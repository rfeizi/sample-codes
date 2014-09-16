
package UI;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;


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
public class EditionExplanForm extends javax.swing.JFrame {
	

	private boolean OKButtonPressed;
	
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JButton OKButton;
	private JButton cancelButton;
	private JLabel jLabel14;
	private JPanel jPanel4;
	private JTextArea editionExplanField;
	public JTextArea getEditionExplanField() {
		return editionExplanField;
	}

	private InventionFileChangeSession session;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EditionExplanForm inst = new EditionExplanForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EditionExplanForm() {
		initGUI();
	}
	
	public EditionExplanForm(InventionFileChangeSession inventionFileChangeSession) {
		super("توضیح ویرایش");
		OKButtonPressed=false;
		session=inventionFileChangeSession;
		initGUI();
	}

	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				getContentPane().setLayout(thisLayout);
				this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				this.addWindowListener(new WindowAdapter() {
					
					@Override
					public void windowClosing(WindowEvent arg0) {
						if(OKButtonPressed==false){
							session.previousDialog(EditionExplanForm.this);
							EditionExplanForm.this.dispose();
						}
					}
						
							
				});
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1, BorderLayout.CENTER);
					jPanel1.setPreferredSize(new java.awt.Dimension(600, 178));
					jPanel1.setBackground(new java.awt.Color(255,255,255));
					{
						editionExplanField = new JTextArea();
						jPanel1.add(editionExplanField);
						editionExplanField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						editionExplanField.setText("\u062a\u0648\u0636\u06cc\u062d\u06cc \u0628\u0631\u0627\u06cc \u0648\u06cc\u0631\u0627\u06cc\u0634");
						editionExplanField.setPreferredSize(new java.awt.Dimension(471, 94));
						editionExplanField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
						editionExplanField.setLocale(new java.util.Locale("ar"));
						editionExplanField.setLineWrap(true);
					}
					{
						jLabel1 = new JLabel();
						jPanel1.add(jLabel1);
						jLabel1.setText("\u062a\u0648\u0636\u06cc\u062d \u0648\u06cc\u0631\u0627\u06cc\u0634");
						jLabel1.setBounds(0, 0, 600, 178);
						jLabel1.setPreferredSize(new java.awt.Dimension(101, 33));
					}
				}
				{
					jPanel4 = new JPanel();
					getContentPane().add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setBackground(new java.awt.Color(255,255,255));
					jPanel4.setPreferredSize(new java.awt.Dimension(600, 110));
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
							public void actionPerformed(ActionEvent e) {
								session.previousDialog(EditionExplanForm.this);
								EditionExplanForm.this.dispose();
								
							}
						});
					}
					{
						OKButton = new JButton();
						jPanel4.add(OKButton);
						OKButton.setText("\u0627\u062a\u0645\u0627\u0645");
						OKButton.setBackground(new java.awt.Color(255,236,255));
						OKButton.setFont(new java.awt.Font("Tahoma",0,14));
						OKButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						OKButton.setBounds(145, 48, 112, 41);
						OKButton.addActionListener(new ActionListener() {
							

							public void actionPerformed(ActionEvent e) {
								OKButtonPressed=true;
								session.nextDialog(EditionExplanForm.this,null);
							}
						});
					}
				}
			}
			pack();
			this.setSize(600, 254);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
