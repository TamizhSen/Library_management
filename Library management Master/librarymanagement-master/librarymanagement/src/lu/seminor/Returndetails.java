/**
 * 
 */
package lu.seminor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Satish Reddy
 *
 */
@XmlRootElement(name = "return")
public class Returndetails {

	private int bookid;
	private int personid;
	private int id;
	private String retundate;
	private double fine;
	public int getBookid() {
		return bookid;
	}
	@XmlElement
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getPersonid() {
		return personid;
	}
	@XmlElement
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public String getRetundate() {
		return retundate;
	}
	@XmlElement
	public void setRetundate(String retundate) {
		this.retundate = retundate;
	}
	public double getFine() {
		return fine;
	}
	@XmlElement
	public void setFine(double fine) {
		this.fine = fine;
	}
	
}
