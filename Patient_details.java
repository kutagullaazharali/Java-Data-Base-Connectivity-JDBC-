package Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient_details 
{
	public static void FetchAllPatient_details() 
	{
		System.out.println("-----------all patient details---------------");
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
			PreparedStatement ps=con.prepareStatement("select * from patient");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4)+" "+rs.getString(5));
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}	
		
		public static void RegisterPatient_details1() 
		{
			Scanner s= new Scanner(System.in);
			System.out.println("enter patient id : ");
			int id=s.nextInt();
			
			System.out.println("enter patient name : ");
			String name=s.next();
			
			System.out.println("enter patient age : ");
			int age=s.nextInt();
			
			System.out.println("enter patient number : ");
			long phone=s.nextLong();
			
			System.out.println("enter disease : ");
			String disease=s.next();
			
			System.out.println("-----------Register patient details---------------");
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
				PreparedStatement ps=con.prepareStatement("insert into patient values(?,?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setInt(3,age);
				ps.setLong(4,phone);
				ps.setString(5,disease);
				ps.execute();
				System.out.println("executed......");
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		public static void Delete_DetailsBy_id() 
		{
			Scanner s= new Scanner(System.in);
			System.out.println("enter patient id : ");
			int id=s.nextInt();
			
			System.out.println("-----------Delete patient details By Id---------------");
			
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
				PreparedStatement ps=con.prepareStatement("delete from patient where id=?");
				ps.setInt(1,id);
				ps.execute();
				System.out.println("executed......");
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		public static void FetchAllPatient_details_By_name() 
		{
			Scanner s= new Scanner(System.in);
			System.out.println("enter patient name : ");
			String name=s.next();
			System.out.println("-----------Fetch patient details By name---------------");
			
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
				PreparedStatement ps=con.prepareStatement("select * from patient where name=?");
				ps.setString(1,name);
				
				ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4)+" "+rs.getString(5));
				 }
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		public static void FetchAllPatient_details_By_Disease()
		{
			Scanner s= new Scanner(System.in);
			System.out.println("enter patient Disease : ");
			String disease=s.next();
			System.out.println("-----------Fetch patient details By Disease---------------");
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
				PreparedStatement ps=con.prepareStatement("select * from patient where disease=?");
				ps.setString(1,disease);
				
				ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4)+" "+rs.getString(5));
				 }
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		public static void update_Patient_details_id() 
		{
			Scanner s= new Scanner(System.in);
			System.out.println("enter patient id : ");
			int  id=s.nextInt();
			System.out.println("-----------update patient details By id---------------");
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
				PreparedStatement ps=con.prepareStatement("select * from patient where id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 {
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4)+" "+rs.getString(5));
					 System.out.println("enter new disease : ");
					 String disease=s.next();
					 PreparedStatement ps1=con.prepareStatement("update patient set disease=? where id=?");
					 ps1.setString(1, disease);
					 ps1.setInt(2, id);
					 ps1.execute();
					 System.out.println("disease updated......");
					 
				 }
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		public  static void update_Patient_details_disease_By_phoneNumber() 
		{
			Scanner s= new Scanner(System.in);
			System.out.println("enter patient phone Number : ");
			long  phonenumber=s.nextLong();
			System.out.println("-----------update patient details By phone---------------");
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
				PreparedStatement ps=con.prepareStatement("select * from patient where phonenumber=?");
				ps.setLong(1, phonenumber);
				ResultSet rs=ps.executeQuery();
				 if(rs.next())
				 {
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4)+" "+rs.getString(5));
					 System.out.println("enter new disease : ");
					 String disease=s.next();
					 
					 PreparedStatement ps1=con.prepareStatement("update patient set disease=? where phonenumber=?");
					 ps1.setString(1, disease);
					 ps1.setLong(2, phonenumber);
					 ps1.execute();
					 System.out.println("disease updated......");
					 
				 }
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		public static void search_Patient_details_by_character() 
		{
			Scanner s= new Scanner(System.in);
			System.out.println("enter patient  character : ");
			String character=s.next();
			String c="%"+character+"%";
			System.out.println("-----------search patient details By character---------------");
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
				PreparedStatement ps=con.prepareStatement("select * from patient where name like '"+c+"' ");
				ResultSet rs=ps.executeQuery();
				 while(rs.next())
				 {
					 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4)+" "+rs.getString(5));
				 }
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
	public static void main(String[] args)
	{
	while(true) {
		System.out.println("welcome to patient database");
		Scanner s=new Scanner(System.in);
		System.out.println("---------enter your choice----------: ");
		System.out.println("1)------ fetch all the patient details------- ");
		System.out.println("2)------ register patient details------------- ");
		System.out.println("3)------ Delete  patient details By Id----------");
		System.out.println("4)------ fetch  patient details By name----------");
		System.out.println("5)------ fetch  patient details By Disease-------");
		System.out.println("6)------ update  patient disease By id-----------");
		System.out.println("7)------ update  patient disease By Phone number---");
		System.out.println("8)-------Search  patient details By Phone Character---");
		System.out.println("9)--------------------exit--------------");
		
		int n=s.nextInt();
		switch(n)
		{
			case 1: 
			{
			FetchAllPatient_details();
			}
			break;
			case 2: 
			{
			RegisterPatient_details1();
			}
			break;
			case 3: 
			{
			Delete_DetailsBy_id();
			}
			break;
			case 4: 
			{
			FetchAllPatient_details_By_name();
			}
			break;
			case 5: 
			{
			FetchAllPatient_details_By_Disease();
			}
			break;
			case 6: 
			{
				update_Patient_details_id();
			}
			break;
			case 7: 
			{
			update_Patient_details_disease_By_phoneNumber();
			}
			break;
			case 8: 
			{
			search_Patient_details_by_character();
			}
			break;
			case 9: 
			{
				System.out.println("exited successfully");
			
				break;
			}
		}
	}
	
	}
}