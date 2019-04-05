package lu.seminor;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/search")
public class SearchService {
	
   BookDao bookDao = new BookDao();
	private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String FAILURE_RESULT="<result>failure</result>";
    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_XML)
    public List<BookDetail> getBooks(){
       return bookDao.getAllBooks(1);
    }
    @GET
    @Path("/journals")
    @Produces(MediaType.APPLICATION_XML)
    public List<BookDetail> getJournals(){
       return bookDao.getAllBooks(2);
    }
    @GET
    @Path("/books/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public BookDetail getBook(@PathParam("id") int id){
       return bookDao.getAllBook(id,1);
    }
    @GET
    @Path("/journals/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public BookDetail getJournal(@PathParam("id") int id){
    	
       return bookDao.getAllBook(id,2);
    }
    @GET
    @Path("/book")
    @Produces(MediaType.APPLICATION_XML)
    public List<BookDetail> getBook(@QueryParam("name") String name,@QueryParam("author") String author,
    		@QueryParam("publisher") String publisher,@QueryParam("type") String type){
       return bookDao.getAllBooks(name,author,publisher,type);
    }
    @GET
    @Path("/journal")
    @Produces(MediaType.APPLICATION_XML)
    public List<BookDetail> getJournal(@QueryParam("name") String name,@QueryParam("author") String author,
    		@QueryParam("publisher") String publisher,@QueryParam("type") String type){
       return bookDao.getAllBooks(name,author,publisher,type);
    }

}
