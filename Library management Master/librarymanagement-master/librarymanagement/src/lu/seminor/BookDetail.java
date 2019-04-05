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
@XmlRootElement(name = "book")
public class BookDetail {
	private int id;
	private String name;
	private String author;
	private String publisher;
	private String placeStored;
	private String type;
	
	private int count;
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	@XmlElement
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPlaceStored() {
		return placeStored;
	}
	@XmlElement
	public void setPlaceStored(String placeStored) {
		this.placeStored = placeStored;
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	@XmlElement
	public void setCount(int count) {
		this.count = count;
	}
	public BookDetail(int id, String name, String author, String publisher, String placeStored, String type,
			int count) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.placeStored = placeStored;
		this.type = type;
		this.count = count;
	}
	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", placeStored=" + placeStored + ", type=" + type + ", count=" + count + "]";
	}
	public BookDetail() {
		super();
	}
	
	
	

}
