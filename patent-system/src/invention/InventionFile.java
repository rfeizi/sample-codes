package invention;

// Generated Jul 31, 2012 6:27:12 AM by Hibernate Tools 4.0.0

import invention.Invention.Status;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import user.User;
import util.Attachment;
import util.TableRowRepresentation;

import expertise.ExpertiseDomain;
import expertise.NewExpertiseDomainRequest;

/**
 * InventionFile generated by hbm2java
 */
@Entity
@Table(name = "invention_file", catalog = "patentsys")
public class InventionFile implements java.io.Serializable, TableRowRepresentation{

	private Integer id;
	private NewExpertiseDomainRequest newExpertiseDomainRequest;
	private Invention relatedInvention;
	private User creator;
	//private InventionFileEdition lastEdition;
	private ExpertiseDomain expertiseDomain;
	private String title;
	private Date creationTime;
	private String relationType;
	private Invention invention;
	
	private Set<InventorCollaboration> inventorCollaborations = new HashSet<InventorCollaboration>(
			0);
	private Set<InventionFileEdition> inventionFileEditions = new HashSet<InventionFileEdition>(
			0);

	private Set<NewExpertiseDomainRequest> newExpertiseDomainRequests = new HashSet<NewExpertiseDomainRequest>(
			0);
	private Set<Attachment> attachments = new HashSet<Attachment>(0);

	public InventionFile() {
	}

	public InventionFile(NewExpertiseDomainRequest newExpertiseDomainRequest,
			User inventor,
			ExpertiseDomain expertiseDomain, String title, Date creationTime) {
		this.newExpertiseDomainRequest = newExpertiseDomainRequest;
		this.creator = inventor;
		//this.lastEdition = inventionFileEdition;
		this.expertiseDomain = expertiseDomain;
		this.title = title;
		this.creationTime = creationTime;
	}

	public InventionFile(NewExpertiseDomainRequest newExpertiseDomainRequest,
			Attachment attachmentByAttachment3Id, Invention rInvention,
			User inventor, 
			Attachment attachmentByAttachment1Id,
			Attachment attachmentByAttachment2Id,
			ExpertiseDomain expertiseDomain, String title, Date creationTime,
			String relationType,
			Invention invention,
			Set<InventorCollaboration> inventorCollaborations,
			Set<InventionFileEdition> inventionFileEditions,
			Set<NewExpertiseDomainRequest> newExpertiseDomainRequests) {
		this.newExpertiseDomainRequest = newExpertiseDomainRequest;

		this.relatedInvention = rInvention;
		this.creator = inventor;
		//this.lastEdition = inventionFileEdition;
		this.expertiseDomain = expertiseDomain;
		this.title = title;
		this.creationTime = creationTime;
		this.relationType = relationType;
		this.invention=invention;
		this.inventorCollaborations = inventorCollaborations;
		this.inventionFileEditions = inventionFileEditions;

		this.newExpertiseDomainRequests = newExpertiseDomainRequests;
	}

	public InventionFile(User creator) {
		this.creator=creator;
		creator.getInventionFiles().add(this);
		this.addCollaboration(creator);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "new_exp_domain_request_id")
	@Cascade(CascadeType.ALL)
	public NewExpertiseDomainRequest getNewExpertiseDomainRequest() {
		return this.newExpertiseDomainRequest;
	}

	public void setNewExpertiseDomainRequest(
			NewExpertiseDomainRequest newExpertiseDomainRequest) {
		this.newExpertiseDomainRequest = newExpertiseDomainRequest;
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "related_invention_id")
	public Invention getRelatedInvention() {
		return this.relatedInvention;
	}

	public void setRelatedInvention(Invention invention) {
		this.relatedInvention = invention;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creator_id")
	public User getCreator() {
		return this.creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}



	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "exp_domain_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	public ExpertiseDomain getExpertiseDomain() {
		return this.expertiseDomain;
	}

	public void setExpertiseDomain(ExpertiseDomain expertiseDomain) {
		this.expertiseDomain = expertiseDomain;
	}

	@Column(name = "title", nullable = false, length = 500)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time", nullable = false, length = 19)
	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Column(name = "relation_type", length = 18)
	public String getRelationType() {
		return this.relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventionFile")
	@Cascade(CascadeType.ALL)
	public Set<InventorCollaboration> getInventorCollaborations() {
		return this.inventorCollaborations;
	}

	public void setInventorCollaborations(
			Set<InventorCollaboration> inventorCollaborations) {
		this.inventorCollaborations = inventorCollaborations;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventionFile")
	@Cascade(CascadeType.ALL)
	public Set<InventionFileEdition> getInventionFileEditions() {
		return this.inventionFileEditions;
	}

	public void setInventionFileEditions(
			Set<InventionFileEdition> inventionFileEditions) {
		this.inventionFileEditions = inventionFileEditions;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "inventionFile")
	public Invention getInvention() {
		return this.invention;
	}

	public void setInvention(Invention invention) {
		this.invention = invention;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventionFile")
	public Set<NewExpertiseDomainRequest> getNewExpertiseDomainRequests() {
		return this.newExpertiseDomainRequests;
	}

	public void setNewExpertiseDomainRequests(
			Set<NewExpertiseDomainRequest> newExpertiseDomainRequests) {
		this.newExpertiseDomainRequests = newExpertiseDomainRequests;
	}

	@Override
	public String[] showRowRepresentation(String type) {
		return new String[]{getTitle(),getCreationTime().toString(),getStatus()};
	}

	public void addCollaboration(User collaborator) {
		InventorCollaboration ic=new InventorCollaboration(collaborator, this, 0, 0); //TODO share must be set
		 inventorCollaborations.add(ic);
		 updateShares();
		
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventionFile")
	@Cascade({CascadeType.DELETE,CascadeType.SAVE_UPDATE})
	public Set<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	@Transient
	public InventionFileEdition getLastEdition (){
		
		InventionFileEdition lastEdition=null;
		for (InventionFileEdition ife : inventionFileEditions) {
			if(lastEdition!=null){
				if(lastEdition.getEditionTime().before(ife.getEditionTime())){
					lastEdition=ife;
				}
			}
			else
				lastEdition=ife;
		}
		
		return lastEdition;
		
	}

	public void removeCollaboration(InventorCollaboration ic) {
		inventorCollaborations.remove(ic);
		updateShares();
		
	}

	private void updateShares() {
		for(InventorCollaboration ic: inventorCollaborations){
			ic.setFinancialShare(100.0/inventorCollaborations.size());
			ic.setSpiritualShare(100.0/inventorCollaborations.size());
		}
		
	}

	public void addInventionFileEdition(
			InventionFileEdition inventionFileEdition) {
		inventionFileEditions.add(inventionFileEdition);
	}

	@Transient
	public boolean isIndividual() {
		if (this.getInventorCollaborations().size()==1)
			return true;
		return false;
	}

	@Transient
	public String getStatus() {
		if(getInvention()==null)
			return "ارسال نشده";
		else
			return getInvention().getStatusString();
	}

	public static String[] getColumnNames(String string) {
		return new String[] { "اختراع","تاریخ ایجاد","وضعیت"};
	}

	
	
	

}


