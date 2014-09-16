package user;

// Generated Jul 31, 2012 6:27:12 AM by Hibernate Tools 4.0.0

import invention.InventionFile;
import invention.InventionFileAssesment;
import invention.InventionFileEdition;
import invention.InventorCollaboration;
import invention.Invention.Status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;



import util.TableRowRepresentation;

import expertise.ExpertiseDomain;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "patentsys")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="discriminator",
    discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="U")
public class User implements java.io.Serializable , TableRowRepresentation{

	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private Long phoneNumber;
	private String email;
	private Company company;
	
	
	private Set<InventionFileEdition> inventionFileEditions = new HashSet<InventionFileEdition>(
			0);
	private Set<InventorCollaboration> inventorCollaborations = new HashSet<InventorCollaboration>(
			0);
	private Set<InventionFile> inventionFiles = new HashSet<InventionFile>(0);
	
	private Set<InventionFileAssesment> inventionFileAssesments = new HashSet<InventionFileAssesment>(
			0);
	
	private Set<ExpertiseDomain> expertiseDomains = new HashSet<ExpertiseDomain>(0);
	


	public User() {
	}

	public User( String username, String password, String firstname,
			String lastname, long phoneNumber) {
		//this.userId = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
	}



	public User(String uname, String pass) {
		this.username=uname;
		this.password=pass;
	}

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "username", nullable = false, unique = true, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstname", nullable = false, length = 100)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = true)
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "lastname", nullable = false, length = 100)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "phoneNumber", nullable = false)
	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name= "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public String getFullName() {
		return getFirstname()+ " " +getLastname();
	}
	
	@Transient
	public String getRole(){
		if(this instanceof Manager)
			return "مدیر";
		else if(isExpert())
			return "کارشناس";
		else
			return "کاربر";
	}
	
	



	@OneToMany(fetch = FetchType.EAGER, mappedBy = "editor")
	public Set<InventionFileEdition> getInventionFileEditions() {
		return this.inventionFileEditions;
	}

	public void setInventionFileEditions(
			Set<InventionFileEdition> inventionFileEditions) {
		this.inventionFileEditions = inventionFileEditions;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventor")
	public Set<InventorCollaboration> getInventorCollaborations() {
		return this.inventorCollaborations;
	}

	public void setInventorCollaborations(
			Set<InventorCollaboration> inventorCollaborations) {
		this.inventorCollaborations = inventorCollaborations;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "creator")
	public Set<InventionFile> getInventionFiles() {
		System.out.println(this.inventionFiles.size());
		return this.inventionFiles;
	}

	public void setInventionFiles(Set<InventionFile> inventionFiles) {
		this.inventionFiles = inventionFiles;
	}


	


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "expert")
	public Set<InventionFileAssesment> getInventionFileAssesments() {
		return this.inventionFileAssesments;
	}

	public void setInventionFileAssesments(
			Set<InventionFileAssesment> inventionFileAssesments) {
		this.inventionFileAssesments = inventionFileAssesments;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "expert_in_domain", catalog="patentsys", 
				joinColumns = { @JoinColumn(name = "expert_id") }, 
							inverseJoinColumns = { @JoinColumn(name = "domain_id") })
	
	public Set<ExpertiseDomain> getExpertiseDomains() {
		return this.expertiseDomains;
	}

	public void setExpertiseDomains(Set<ExpertiseDomain> expertiseDomains) {
		this.expertiseDomains = expertiseDomains;
	}
	
	
	
	@Override
	public String[] showRowRepresentation(String type) {
		if(type.equals("inventor")){
			return new String[]{getFullName(),getPhoneNumber().toString(),getEmail()};
		}else if(type.equals("user")){
			return new String[]{getUsername(),getFullName(),new Long(getPhoneNumber()).toString(),getRole()};
		}
		return null;
	}

	public static String[] getColumnNames(String type) {
		if(type.equals("inventor"))
			return new String[]{"نام مخترع","شماره تماس","آدرس الکترونیکی"};
		else if(type.equals("user"))
			return new String[]{"نام کاربری","نام و نام خانوادگی","شماره تماس","نقش"};
		return null;
	}
	
	@Transient
	public boolean isExpert(){
		if(getExpertiseDomains().size()!=0)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User))
			return false;
		if(((User)obj).getUserId()==getUserId())
			return true;
		else
			return false;
	}

	public void addInventionFileEdition(
			InventionFileEdition ife) {
		inventionFileEditions.add(ife);
		
	}

	@Transient
	public ArrayList<InventionFile> getUnderStudyInventionFiles() {
		ArrayList<InventionFile> underStudies=new ArrayList<InventionFile>();
		for(InventionFile ifile: getCollaboratedInventionFiles()){
			if(ifile.getInvention()!=null)
				if(ifile.getInvention().getStatus()==Status.pending)
					underStudies.add(ifile);
		}
		
		return underStudies;
	}

	@Transient
	public Collection<InventionFile> getCollaboratedInventionFiles() {
		ArrayList<InventionFile> collaboratedFiles=new ArrayList<InventionFile>();
		for(InventorCollaboration ic: getInventorCollaborations())
			collaboratedFiles.add(ic.getInventionFile());
		return collaboratedFiles;
	}

	
}