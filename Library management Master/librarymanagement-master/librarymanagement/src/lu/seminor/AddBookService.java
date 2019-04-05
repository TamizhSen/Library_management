/**
 * 
 */
package lu.seminor;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Satish Reddy
 *
 */
@Path("/add")
public class AddBookService {
	 	BookDao bookDao = new BookDao();
		private static final String SUCCESS_RESULT="<result>success</result>";
	    private static final String FAILURE_RESULT="<result>failure</result>";
	    @POST
	    @Path("/book")
	    @Produces(MediaType.APPLICATION_XML)
	    @Consumes(MediaType.APPLICATION_XML)
	    public String addBook(BookDetail bookDetail) {
	    	bookDetail.setType("1");
	    	boolean bool =bookDao.addBook(bookDetail);
	    	return bool?FAILURE_RESULT:SUCCESS_RESULT;
	    }
	    
	    @POST
	    @Path("/journal")
	    @Produces(MediaType.APPLICATION_XML)
	    @Consumes(MediaType.APPLICATION_XML)
	    public String addjournel(BookDetail bookDetail) {
	    	bookDetail.setType("2");
	    	boolean bool =bookDao.addBook(bookDetail);
	    	return bool?FAILURE_RESULT:SUCCESS_RESULT;
	    }
	    @PUT
	    @Path("/book")
	    @Produces(MediaType.APPLICATION_XML)
	    @Consumes(MediaType.APPLICATION_XML)
	    public String UpdateBook(BookDetail bookDetail) {
	    	bookDetail.setType("1");
	    	boolean bool =bookDao.updateBook(bookDetail);
	    	return bool?SUCCESS_RESULT:FAILURE_RESULT;
	    }
	    @PUT
	    @Path("/journal")
	    @Produces(MediaType.APPLICATION_XML)
	    @Consumes(MediaType.APPLICATION_XML)
	    public String UpdateJournel(BookDetail bookDetail) {
	    	bookDetail.setType("2");
	    	boolean bool =bookDao.updateBook(bookDetail);
	    	return bool?SUCCESS_RESULT:FAILURE_RESULT;
	    }

}
