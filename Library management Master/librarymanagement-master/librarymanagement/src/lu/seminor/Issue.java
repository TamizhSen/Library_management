/**
 * 
 */
package lu.seminor;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author satish Reddy
 *
 */
@XmlRootElement(name = "issue")
public class Issue {

	private Person person;
	private int bookid;
	private String date;
	private String returndate;
	private int type;
	public Person getPerson() {
		return person;
	}
	@XmlElement
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getBookid() {
		return bookid;
	}
	@XmlElement
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	public String getDate() {
		return date;
	}
	@XmlElement
	public void setDate(String date) {
		this.date = date;
	}
	public String getReturndate() {
		return returndate;
	}
	@XmlElement
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public int getType() {
		return type;
	}
	@XmlElement
	public void setType(int type) {
		this.type = type;
	}
	
}
