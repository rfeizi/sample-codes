package UI;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JSeparator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import user.User;
import user.UserHome;


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
public class ChangePassWord extends javax.swing.JFrame {
	
	
	private User user;
	
	
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPasswordField newPasswordField;
	private JLabel jLabel4;
	private JButton OKButton;
	private JLabel jLabel5;
	private JLabel errorLabel;
	private JPasswordField newPasswordRepeatField;
	private JButton cancelButton;
	private JPasswordField oldPasswordField;
	private JSeparator jSeparator1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ChangePassWord inst = new ChangePassWord();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ChangePassWord() {
		super();
		initGUI();
	}
	
	public ChangePassWord(User u) {
		super("تغییر رمز عبور");
		user=u;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			getContentPane().setLayout(null);
			setTitle("تغییر رمز عبور");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634 \u0631\u0645\u0632 \u0648\u0631\u0648\u062f");
				jLabel1.setBounds(318, 30, 121, 36);
				jLabel1.setFont(new java.awt.Font("Tahoma",1,14));
				jLabel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
				jLabel1.setForeground(new java.awt.Color(128,0,64));

			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u0631\u0645\u0632 \u0648\u0631\u0648\u062f \u0641\u0639\u0644\u06cc");
				jLabel2.setBounds(324, 105, 80, 30);
				jLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				jLabel2.setFont(new java.awt.Font("Tahoma",0,12));
				jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u0631\u0645\u0632 \u0639\u0628\u0648\u0631 \u062c\u062f\u06cc\u062f");
				jLabel3.setBounds(320, 146, 84, 26);
				jLabel3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				jLabel3.setFont(new java.awt.Font("Tahoma",0,12));
				jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(23, 44, 289, 22);
				jSeparator1.setBackground(new java.awt.Color(128,0,64));
			}
			{
				oldPasswordField = new JPasswordField();
				getContentPane().add(oldPasswordField);
				oldPasswordField.setBounds(166, 105, 119, 28);
				oldPasswordField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
			{
				newPasswordField = new JPasswordField();
				getContentPane().add(newPasswordField);
				newPasswordField.setBounds(166, 146, 119, 28);
				newPasswordField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setBounds(309, 294, 191, 84);
				jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ax.jpg")));
			}
			{
				OKButton = new JButton();
				getContentPane().add(OKButton);
				OKButton.setText("\u062a\u0627\u06cc\u06cc\u062f");
				OKButton.setBounds(147, 313, 119, 44);
				OKButton.setFont(new java.awt.Font("Tahoma",0,14));
				OKButton.setBackground(new java.awt.Color(255,236,255));
				OKButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				OKButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						OKButtonActionPerformed(e);
						
					}
				});
				
			}
			{
				cancelButton = new JButton();
				getContentPane().add(cancelButton);
				cancelButton.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
				cancelButton.setBounds(16, 313, 119, 44);
				cancelButton.setFont(new java.awt.Font("Tahoma",0,14));
				cancelButton.setBackground(new java.awt.Color(255,236,255));
				cancelButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						cancelButtonActionPerformed(e);
						
					}
				});
			}
			{
				newPasswordRepeatField = new JPasswordField();
				getContentPane().add(newPasswordRepeatField);
				newPasswordRepeatField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				newPasswordRepeatField.setBounds(166, 187, 119, 28);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u062a\u06a9\u0631\u0627\u0631 \u0631\u0645\u0632 \u062c\u062f\u06cc\u062f");
				jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
				jLabel5.setFont(new java.awt.Font("Tahoma",0,12));
				jLabel5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
				jLabel5.setBounds(320, 187, 84, 26);
			}
			{
				errorLabel = new JLabel();
				getContentPane().add(errorLabel);
				errorLabel.setBounds(166, 231, 238, 17);
				errorLabel.setFont(new java.awt.Font("Dialog",0,10));
				errorLabel.setForeground(new java.awt.Color(255,0,0));
			}

			pack();
			setSize(500, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	protected void cancelButtonActionPerformed(ActionEvent e) {
		this.dispose();
		
	}

	protected void OKButtonActionPerformed(ActionEvent e) {
		String oldPassword=new String(oldPasswordField.getPassword());
		String newPassword=new String(newPasswordField.getPassword());
		String newPasswordRepeat= new String(newPasswordRepeatField.getPassword());
		
		
		byte[] passwdmd5Bytes = null;
		String passwd=new String(oldPassword);
		try {
			passwdmd5Bytes = MessageDigest.getInstance("MD5").digest(
					passwd.getBytes("ISO-8859-1"));
		} catch (NoSuchAlgorithmException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String passwdmd5 = new String(passwdmd5Bytes);
		
		if(!passwdmd5.equals(user.getPassword())){
			errorLabel.setText("کلمه عبور فعلی به اشتباه وارد شده است");
			oldPasswordField.setText("");
			newPasswordField.setText("");
				newPasswordRepeatField.setText("");
			}else{
			if(!newPassword.equals(newPasswordRepeat)){
				errorLabel.setText("تکرار کلمه عبور جدید را به درستی وارد کنید");
			}else{
				byte[] newPasswdmd5Bytes = null;
				
				try {
					newPasswdmd5Bytes = MessageDigest.getInstance("MD5").digest(
							newPassword.getBytes("ISO-8859-1"));
				} catch (NoSuchAlgorithmException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String newPasswdmd5 = new String(newPasswdmd5Bytes);
				user.setPassword(newPasswdmd5);
				UserHome.getInstance().updateUser(user);
				JOptionPane.showMessageDialog(this, "رمز عبور با موفقیت تغییر یافت.");
				this.dispose();
			}
		}
	}

}
