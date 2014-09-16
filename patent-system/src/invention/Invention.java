package invention;

// Generated Jul 31, 2012 6:27:12 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import util.TableRowRepresentation;

/**
 * Invention generated by hbm2java
 */
@Entity
@Table(name = "invention", catalog = "patentsys", uniqueConstraints = @UniqueConstraint(columnNames = "invention_file_id"))
public class Invention implements java.io.Serializable, TableRowRepresentation {

	private int id;
	private InventionFile inventionFile;
	private Integer price;
	
	public enum Status{
		authorizing,
		unauthorized,
		pending,
		rejected,
		accepted, 
		understudy;
	};
	private Status status;
	
	private Set<InventionFileAssesment> inventionFileAssesments = new HashSet<InventionFileAssesment>(
			0);
	

	public Invention() {
		this.status=Status.pending;
	}

	public Invention(int id, InventionFile inventionFile, Status status) {
		this.id = id;
		this.inventionFile = inventionFile;
		this.status = status;
	}

	public Invention(int id, InventionFile inventionFile, Integer price,
			Status status, Set<InventionFileAssesment> inventionFileAssesments) {
		this.id = id;
		this.inventionFile = inventionFile;
		this.price = price;
		this.status = status;
		this.inventionFileAssesments = inventionFileAssesments;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "invention_file_id", unique = true, nullable = false)
	@Cascade(CascadeType.ALL)
	public InventionFile getInventionFile() {
		return this.inventionFile;
	}

	public void setInventionFile(InventionFile inventionFile) {
		this.inventionFile = inventionFile;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.ORDINAL) 
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "invention")
	@Cascade(CascadeType.ALL)
	public Set<InventionFileAssesment> getInventionFileAssesments() {
		return this.inventionFileAssesments;
	}

	public void setInventionFileAssesments(
			Set<InventionFileAssesment> inventionFileAssesments) {
		this.inventionFileAssesments = inventionFileAssesments;
	}

	@Override
	public String[] showRowRepresentation(String type) {
		if(type.equals("authorize"))
			return new String[]{getInventionFile().getTitle(),getInventionFile().getCreator().getFullName(),getInventionFile().getExpertiseDomain().toString()};
		else
			return new String[]{getInventionFile().getTitle(),getInventionFile().getCreationTime().toString(),getStatusString()};
	}
	


	@Transient
	public String getStatusString(){
		switch (this.status) {
		case pending:
			InventionFileAssesment curAssesment=getCurrentAssesment();
			if(curAssesment==null)
				return "منتظر تخصیص کارشناس";
			else
				return "تحت بررسی توسط کارشناس";
		case authorizing:
			return "منتظر اجازه ثبت اختراع";
		case unauthorized:
			return "ثبت غیر مجاز";
		case accepted:
			return "پذیرفته شده";
		case rejected:
			return "رد شده";
		default:
			return "naboooood";
		}
	}

	@Transient
	public InventionFileAssesment getCurrentAssesment() {

		InventionFileAssesment curAssesment=null;
		for (InventionFileAssesment ifa : inventionFileAssesments) {
			if(curAssesment!=null){
				if(curAssesment.getAssignTime().before(ifa.getAssignTime())){
					curAssesment=ifa;
				}
			}
			else
				curAssesment=ifa;
			
		}
		return curAssesment;
	}

	public static String[] getColumnNames(String type) {
		if(type.equals("authorize"))
			return new String[]{"عنوان اختراع","نام متقاضی","حوزه اختراع"};
		else
			return new String[]{"عنوان اختراع","تاریخ ایجاد","وضعیت"};
	}
	

}
