/**
 * 
 */
package lu.seminor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Satish Reddy
 *
 */
@Path("/issue")
public class IssueService {
	AvailabilityConsumer availabilityConsumer = new AvailabilityConsumer();
	BookDao bookDao = new BookDao();
	private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String FAILURE_RESULT="<result>failure</result>";
    @POST
    @Path("/book")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public String addBook(Issue issue) {
    	issue.setType(1);
    	boolean bool =bookDao.issueBook(issue);
    	//return bool?FAILURE_RESULT:SUCCESS_RESULT;
    	System.out.println("boolean value in issue service is:"+bool);
    	return bool?FAILURE_RESULT: availabilityConsumer.updateAvailability(issue.getBookid(),1,-1)?SUCCESS_RESULT:FAILURE_RESULT;
    }
    @POST
    @Path("/journal")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public String journal(Issue issue) {
    	issue.setType(2);
    	boolean bool =bookDao.issueBook(issue);
    	//return bool?FAILURE_RESULT:SUCCESS_RESULT;
    	return bool?FAILURE_RESULT: availabilityConsumer.updateAvailability(issue.getBookid(),2,-1)?SUCCESS_RESULT:FAILURE_RESULT;
    }
    @GET
    @Path("/book")
    @Produces(MediaType.APPLICATION_XML)
    public Issue getBook() {
    	Issue issue = new Issue();
    	Person person = new Person();
    	person.setEmail("snulaka@lakeheadu.ca");
    	issue.setPerson(person);
    	issue.setBookid(2000);
    	issue.setDate("2018-11-10");
    	return issue;
    }
   
}
