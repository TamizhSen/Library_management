package lu.seminor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao {
	
	MysqlConnector mysqlConnector = new MysqlConnector();
	
	public List<BookDetail> getAllBooks (int type) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<BookDetail> list = new ArrayList<BookDetail>();
	try {
		con = mysqlConnector.getDataSource().getConnection();
		 stmt = con.prepareStatement("SELECT * FROM book where type=? and count>0");
		stmt.setInt(1, type);
		 rs = stmt.executeQuery();
		BookDetail bookDetails = null;
		
		while (rs.next()) {
			bookDetails = new BookDetail();
			bookDetails.setAuthor(rs.getString("author"));
			bookDetails.setCount(rs.getInt("count"));
			bookDetails.setId(rs.getInt("id"));
			bookDetails.setName(rs.getString("name"));
			bookDetails.setPublisher(rs.getString("publisher"));
			bookDetails.setType(String.valueOf(type));
			bookDetails.setPlaceStored(rs.getString("placestored"));
			System.out.println("book details:"+bookDetails);
			
			list.add(bookDetails);
			System.out.println("list"+list);
		}
		return list;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		return null;
	}

	public boolean addBook(BookDetail bookDetail) {
		String Sql = "INSERT INTO book (Name, author, publisher, count, placestored, type) "
				+ "VALUES (?, ?, ?, ?, ?, ?)" ;
		boolean bool=false;
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = mysqlConnector.getDataSource().getConnection();
			 stmt = con.prepareStatement(Sql);
			 stmt.setString(1,bookDetail.getName());
			 stmt.setString(2,bookDetail.getAuthor());
			 stmt.setString(3,bookDetail.getPublisher());
			 stmt.setInt(4,bookDetail.getCount());
			 stmt.setString(5,bookDetail.getPlaceStored());
			 stmt.setString(6,bookDetail.getType());
			 bool=stmt.execute();
			 System.out.println("boolean value :"+bool);
		}catch (Exception e) {
			
		}
		finally {
			try {
				
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	public boolean updateBook(BookDetail bookDetail) {
		
		String Sql = "update book set Name=?, author=?, publisher=?, count=?, placestored=?, type=? where id=?" ;
		boolean bool=false;
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = mysqlConnector.getDataSource().getConnection();
			 stmt = con.prepareStatement(Sql);
			 stmt.setString(1,bookDetail.getName());
			 stmt.setString(2,bookDetail.getAuthor());
			 stmt.setString(3,bookDetail.getPublisher());
			 stmt.setInt(4,bookDetail.getCount());
			 stmt.setString(5,bookDetail.getPlaceStored());
			 stmt.setString(6,bookDetail.getType());
			 stmt.setInt(7, bookDetail.getId());
			 bool=stmt.executeUpdate()>0?true:false;
		}catch (Exception e) {
			
		}
		finally {
			try {
				
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	public BookDetail getAllBook(int id,int type) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		System.out.println("type :"+type);
	try {
		con = mysqlConnector.getDataSource().getConnection();
		 stmt = con.prepareStatement("SELECT * FROM book where type=? and id=? and count>0");
		stmt.setInt(2, id);
		stmt.setInt(1, type);
		 rs = stmt.executeQuery();
		BookDetail bookDetails = null;
		
		while (rs.next()) {
			bookDetails = new BookDetail();
			bookDetails.setAuthor(rs.getString("author"));
			bookDetails.setCount(rs.getInt("count"));
			bookDetails.setId(rs.getInt("id"));
			bookDetails.setName(rs.getString("name"));
			bookDetails.setPublisher(rs.getString("publisher"));
			bookDetails.setType(rs.getString("type"));
			bookDetails.setPlaceStored(rs.getString("placestored"));
			System.out.println("book details:"+bookDetails);
			
			
			System.out.println("book"+bookDetails);
		}
		return bookDetails;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		return new BookDetail();
	}

	public boolean issueBook(Issue issue) {
		
		String Sql = "INSERT INTO person (name, address, email, phone) "
				+ "VALUES (?, ?, ?, ?)" ;
		String sql1 = "INSERT INTO issued (person,type,date,returndate,bookid)"
				+ "VALUES (?,?,?,?,?)";
		boolean bool=false;
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		if(checkavailablility(con,issue)) {
		try {
			con = mysqlConnector.getDataSource().getConnection();
			 stmt = con.prepareStatement(Sql);
			 stmt.setString(1,issue.getPerson().getName());
			 stmt.setString(2,issue.getPerson().getAddress());
			 stmt.setString(3,issue.getPerson().getEmail());
			 stmt.setLong(4,issue.getPerson().getPhone());
			 bool=stmt.execute();
			 System.out.println("boolean value :"+bool);
			 stmt1 = con.prepareStatement(sql1);
			 stmt1.setInt(1, issue.getPerson().getId());
			 stmt1.setInt(2, issue.getType());
			 stmt1.setString(3,issue.getDate());
			 stmt1.setString(4,issue.getReturndate());
			 stmt1.setInt(5,issue.getBookid());
			 bool=stmt1.execute();
		}catch (Exception e) {
			
		}
		finally {
			try {
				stmt1.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		} else {
			bool=true;
		}
		return bool;
	}

	private boolean checkavailablility(Connection con,Issue issue) {
		boolean bool=false;
		String sql ="select count from book where id=?";
		PreparedStatement stmt = null;
		ResultSet resultSet=null;
		try {
			con = mysqlConnector.getDataSource().getConnection();
			stmt = con.prepareStatement(sql);
			 stmt.setInt(1,issue.getBookid());
			 resultSet = stmt.executeQuery();
			 if (resultSet.next()) {
			        int numberOfRows = resultSet.getInt(1);
			        System.out.println("numberOfRows= " + numberOfRows);
			        bool=numberOfRows>0?true:false;
			      } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		 
		return bool;
	}

	public boolean returnBook(Returndetails returndetails) {
		
		
		String sql1 = "INSERT INTO return (bookid,personid,fine,date)"
				+ "VALUES (?,?,?,?)";
		boolean bool=false;
		Connection con = null;
	
		PreparedStatement stmt1 = null;
		
		try {
			con = mysqlConnector.getDataSource().getConnection();
			
			 System.out.println("boolean value :"+bool);
			 stmt1 = con.prepareStatement(sql1);
			 stmt1.setInt(1, returndetails.getBookid());
			 stmt1.setInt(2, returndetails.getPersonid());
			 stmt1.setDouble(3,returndetails.getFine());
			 stmt1.setString(4,returndetails.getRetundate());
			 
			 bool=stmt1.execute();
		}catch (Exception e) {
			
		}
		finally {
			try {
				stmt1.close();
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	public List<BookDetail> getAllBooks(String name, String author, String publisher, String type) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<BookDetail> list = new ArrayList<BookDetail>();
	try {
		con = mysqlConnector.getDataSource().getConnection();
		
		 stmt = getData(name, author, publisher, type, stmt, con);
		 
		/*stmt.setString(1, type);
		stmt.setString(2,author);
		stmt.setString(3,publisher);
		stmt.setString(4,name); */
		 rs = stmt.executeQuery();
		 System.out.println("Rs :"+rs);
		BookDetail bookDetails = null;
		
		while (rs.next()) {
			bookDetails = new BookDetail();
			bookDetails.setAuthor(rs.getString("author"));
			bookDetails.setCount(rs.getInt("count"));
			bookDetails.setId(rs.getInt("id"));
			bookDetails.setName(rs.getString("name"));
			bookDetails.setPublisher(rs.getString("publisher"));
			bookDetails.setType(String.valueOf(type));
			bookDetails.setPlaceStored(rs.getString("placestored"));
			System.out.println("book details:"+bookDetails);
			
			list.add(bookDetails);
			System.out.println("list"+list);
		}
		//return list;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
		return list;
	}
	private PreparedStatement getData(String name,String author,String publisher,String type,PreparedStatement prep,Connection con) {
		String sql = "select * from book where type=? and count>0";
		//System.out.println("printing the sql function validation :"+name.trim().length());
		try {
			if(name!=null && name.trim().length()>0&&publisher!=null&&publisher.trim().length()>0&&author!=null&&author.trim().length()>0) {
				sql ="SELECT * FROM book where type=? and author=? and count>0 and publisher=? and Name=?";
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
				prep.setString(2,author);
				prep.setString(3,publisher);
				prep.setString(4,name);
			} else if(name!=null && name.trim().length()>0&&publisher!=null&&publisher.trim().length()>0&&(author ==null ||author.trim().length()==0)){
				sql ="SELECT * FROM book where type=? and count>0 and publisher=? and Name=?";
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
				//prep.setString(2,author);
				prep.setString(2,publisher);
				prep.setString(3,name);
			}else if(name!=null && name.trim().length()>0&&(publisher==null||publisher.trim().length()==0)&&(author ==null ||author.trim().length()==0)){
				sql ="SELECT * FROM book where type=? and count>0 and Name=?";
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
				//prep.setString(2,author);
				//prep.setString(2,publisher);
				prep.setString(2,name);
			}else if((name==null || name.trim().length()==0)&&(publisher!=null&&publisher.trim().length()>0)&&(author ==null ||author.trim().length()==0)){
				sql ="SELECT * FROM book where type=? and count>0 and publisher=? ";
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
				//prep.setString(2,author);
				prep.setString(2,publisher);
				//prep.setString(2,name);
			}else if((name==null || name.trim().length()==0)&&(publisher!=null&&publisher.trim().length()>0)&&(author !=null&&author.trim().length()>0)){
				sql ="SELECT * FROM book where type=? and count>0 and author=? and publisher=? ";
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
				prep.setString(2,author);
				prep.setString(3,publisher);
				//prep.setString(2,name);
			}else if((name==null || name.trim().length()==0)&&(publisher==null||publisher.trim().length()==0)&&(author !=null&&author.trim().length()>0)){
				sql ="SELECT * FROM book where type=? and count>0 and author=?";
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
				prep.setString(2,author);
				//prep.setString(3,publisher);
				//prep.setString(2,name);
			}else if((name!=null && name.trim().length()>0)&&(publisher==null||publisher.trim().length()==0)&&(author !=null&&author.trim().length()>0)){
				sql ="SELECT * FROM book where type=? and count>0 and author=? and Name=?";
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
				prep.setString(2,author);
				//prep.setString(3,publisher);
				prep.setString(3,name);
			} else {
				prep = con.prepareStatement(sql);
				prep.setString(1, type);
			}
			System.out.println("sql is :"+sql);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return prep;
	}

	

}
