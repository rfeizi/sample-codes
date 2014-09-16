package expertise;

// Generated Jul 31, 2012 6:27:12 AM by Hibernate Tools 4.0.0

import invention.InventionFile;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import util.TableRowRepresentation;

/**
 * NewExpertiseDomainRequest generated by hbm2java
 */
@Entity
@Table(name = "new_expertise_domain_request", catalog = "patentsys", uniqueConstraints = @UniqueConstraint(columnNames = "invention_file_id"))
public class NewExpertiseDomainRequest implements java.io.Serializable,
		TableRowRepresentation {

	private Integer id;
	private InventionFile inventionFile;
	private String domainName;

	public enum Status {
		pending, rejected, accepted;
	};

	private Status status;
	private Set<InventionFile> inventionFiles = new HashSet<InventionFile>(0);

	public NewExpertiseDomainRequest() {
	}

	public NewExpertiseDomainRequest(InventionFile inventionFile,
			String domainName) {
		this.inventionFile = inventionFile;
		this.domainName = domainName;
		this.status=Status.pending;
	}

	public NewExpertiseDomainRequest(InventionFile inventionFile,
			String domainName, Status status, Set<InventionFile> inventionFiles) {
		this.inventionFile = inventionFile;
		this.domainName = domainName;
		this.status = status;
		this.inventionFiles = inventionFiles;
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
	@JoinColumn(name = "invention_file_id", unique = true, nullable = false)
	public InventionFile getInventionFile() {
		return this.inventionFile;
	}

	public void setInventionFile(InventionFile inventionFile) {
		this.inventionFile = inventionFile;
	}

	@Column(name = "domain_name", nullable = false, length = 100)
	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "newExpertiseDomainRequest")
	public Set<InventionFile> getInventionFiles() {
		return this.inventionFiles;
	}

	public void setInventionFiles(Set<InventionFile> inventionFiles) {
		this.inventionFiles = inventionFiles;
	}

	@Override
	public String[] showRowRepresentation(String type) {
		return new String[] { getDomainName(), getInventionFile().getTitle(),
				getInventionFile().getCreator().getFullName(),
				getInventionFile().getCreationTime().toString() };
	}

	public static String[] getColumnNames(String string) {
		return new String[]{"نام حوزه","عنوان اختراع","نام متقاضی","تاریخ تقاضا"};
	}
	

}