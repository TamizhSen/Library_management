/**
 * 
 */
package lu.seminor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 * @author Satish reddy
 *
 */
public class AvailabilityConsumer {

	 private Client client;
	 BookDao bookDao = new BookDao();
	   private String REST_SERVICE_URL = "http://localhost:8080/librarymanagement/add/";
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String PASS = "pass";
	   private static final String FAIL = "fail";

	   public  AvailabilityConsumer(){
	      this.client = ClientBuilder.newClient();
	   }
	public boolean updateAvailability(int id,int type,int count) {
		Boolean bool = true;
		BookDetail bookDetail = new BookDetail();
		bookDetail = bookDao.getAllBook(id, type);
		REST_SERVICE_URL = type==1?REST_SERVICE_URL+"book": REST_SERVICE_URL+"journal";
		
		bookDetail.setCount(bookDetail.getCount()+count);
		String callResult = client
		         .target(REST_SERVICE_URL)
		         .request(MediaType.APPLICATION_XML)
		         .put(Entity.entity(bookDetail,
		            MediaType.APPLICATION_XML),
		            String.class);
		      String result = PASS;
		      if(!SUCCESS_RESULT.equals(callResult)){
		         result = FAIL;
		         bool=false;
		      }

		      System.out.println("Test case name: testUpdateUser, Result: " + result );
		return bool;
	}
}
