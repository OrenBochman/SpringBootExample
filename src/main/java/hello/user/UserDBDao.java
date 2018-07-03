package hello.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Date;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import hello.IDao;
import hello.JdbcUtils;
import hello.user.User.RoleEnum;

@Repository
public class UserDBDao implements  IDao<User>{

	//	@PersistenceContext(unitName="production")
	//	private EntityManager entityManager;

	@Override
	public void create(User user) throws Exception {
		String sql = "INSERT INTO user (name, user_name, password,password_expiration,age,role) VALUES (?,?,?,?,?,?);";
		try(
				Connection con=JdbcUtils.getConnection("root", "mambojambo", "127.0.0.1", "3306","ProductsDataBase");	
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setString(1,user.getName());
			ps.setString(2,user.getUserName());
			ps.setString(3,user.getPassword());
			ps.setDate(4,user.getPasswordExpiration());
			ps.setInt(5,user.getAge());
			ps.setInt(6,user.getRole().ordinal());
			ps.executeUpdate(); //executing the command	
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e);
			throw new Exception("could not create customer " + user.toString(),e);
		}		
	}

	@Override
	public Collection<User> read() throws Exception {

		List<User> users = new ArrayList<User>();
		String sql=("select * from user");
		try(	// Creating auto-closable resources
				// Getting a connection from the connection manager
				Connection connection=JdbcUtils.getConnection("root", "mambojambo", "127.0.0.1", "3306","ProductsDataBase");
				// Creating a statement object which holds the SQL we're about to execute and asking for the generated keys back
				PreparedStatement preparedStatement  = connection.prepareStatement(sql);
				// Executing the query
				ResultSet resultSet = preparedStatement.executeQuery();	){			
			while(resultSet.next()){
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String password = resultSet.getString("password");
				String userName = resultSet.getString("user_name");
				long id = resultSet.getLong("id");
				Date passwordExpiration = resultSet.getDate("password_expiration");
				User.RoleEnum role=RoleEnum.values()[Integer.parseInt(resultSet.getString("role"))];
				//User.RoleEnum role=User.RoleEnum.USER;
				User user = new User().setName(name).setUserName(userName).setPassword(password).setAge(age).setId(id).setRole(role).setPasswordExpiration(passwordExpiration);
				users.add(user);
			}
			//if there was an exception in the "try" block above, it is caught here and notifies a level above.
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return users;
	}
	
	public Collection<User> readUserbyAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		String sql = "Update user Set name=?, user_name=?, password = ?,password_expiration=?, age=?,role=? WHERE id=?;";
		try(
				Connection con=JdbcUtils.getConnection("root", "mambojambo", "127.0.0.1", "3306","ProductsDataBase");	
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setString(1,user.getName());
			ps.setString(2,user.getUserName());
			ps.setString(3,user.getPassword());
			ps.setDate(4,user.getPasswordExpiration());
			ps.setInt(5,user.getAge());
			ps.setInt(6,user.getRole().ordinal());
			ps.setLong(7,user.getId());
			ps.executeUpdate(); //executing the command	
			if(0==ps.executeUpdate()) //executing the command			
				throw new ApplicationException(String.format("user id: %d not found",user.getId()));
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("update user failed due: " + e.getMessage(),e);
		}			}



	@Override
	public void delete(long id) {
		String sql = "DELETE FROM user WHERE id=?;";
		try(
				Connection con=JdbcUtils.getConnection("root", "mambojambo", "127.0.0.1", "3306","ProductsDataBase");	
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setLong(1,id);
			if(0==ps.executeUpdate()) //executing the command			
				throw new ApplicationException(String.format("user id: %d not found",id));
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("delete user failed due: " + e.getMessage(),e);
		}		
	}


}
