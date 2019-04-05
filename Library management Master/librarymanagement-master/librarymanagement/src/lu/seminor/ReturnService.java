/**
 * 
 */
package lu.seminor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Satish Reddy
 *
 */
@Path("/return")
public class ReturnService {
	AvailabilityConsumer availabilityConsumer = new AvailabilityConsumer();
	BookDao bookDao = new BookDao();
	private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String FAILURE_RESULT="<result>failure</result>";
    	@POST
	    @Path("/book")
	    @Produces(MediaType.APPLICATION_XML)
	    @Consumes(MediaType.APPLICATION_XML)
	    public String addBook(Returndetails returndetails) {
		
	    	boolean bool =bookDao.returnBook(returndetails);
	    	return bool?FAILURE_RESULT: availabilityConsumer.updateAvailability(returndetails.getBookid(),1,1)?SUCCESS_RESULT:FAILURE_RESULT;
	    }
    	@POST
	    @Path("/journal")
	    @Produces(MediaType.APPLICATION_XML)
	    @Consumes(MediaType.APPLICATION_XML)
	    public String journal(Returndetails returndetails) {
		
	    	boolean bool =bookDao.returnBook(returndetails);
	    	return bool?FAILURE_RESULT: availabilityConsumer.updateAvailability(returndetails.getBookid(),2,1)?SUCCESS_RESULT:FAILURE_RESULT;
	    }
}
