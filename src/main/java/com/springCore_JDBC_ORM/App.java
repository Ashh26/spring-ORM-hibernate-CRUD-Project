package com.springCore_JDBC_ORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springCore_JDBC_ORM.config.JavaConfig;
import com.springCore_JDBC_ORM.dao.UserDao;
import com.springCore_JDBC_ORM.entities.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Processing");
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		UserDao dao = context.getBean("daoImpl", UserDao.class);

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		 System.out.println("Welcome to Student Management Console!");

	        boolean go = true;
	        while (go) {
	            System.out.println("\n==== MENU ====");
	            System.out.println("1. Add User");
	            System.out.println("2. Update User by ID");
	            System.out.println("3. Delete User by ID");
	            System.out.println("4. Get User by Id");
	            System.out.println("5. List All User");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");

			try {
				int input = Integer.parseInt(bf.readLine());

				switch (input) {

				case 1:

					// Inserting New User

					System.out.println("Enter Id:");
					int uId = Integer.parseInt(bf.readLine());

					System.out.println("Enter Name:");
					String uName = bf.readLine();

					System.out.println("Enter City:");
					String uCity = bf.readLine();

					System.out.println("Enter Pincode:");
					int uPincode = Integer.parseInt(bf.readLine());

					User user = new User();
					user.setId(uId);
					user.setName(uName);
					user.setCity(uCity);
					user.setPincode(uPincode);
					int result = dao.insertUser(user);
					System.out.println("User added succesfull:" + result);
					User Newuser = dao.getSingleUser(uId);

					System.out.println();
					System.out.println();

					System.out.println("New User is:" + Newuser.getId() + "\n" + Newuser.getName() + "\n"
							+ Newuser.getCity() + "\n" + Newuser.getPincode());
					System.out.println(
							"----------------------------------------------------------------------------------------------------");

					break;

				case 2:
					// Update User By Id

					System.out.println("Enter Id you want to update:");
					int uId2 = Integer.parseInt(bf.readLine());
					User uptUser = dao.getSingleUser(uId2);

					if(uptUser!=null) {
					System.out.println("Set the Name:");
					String uName2 = bf.readLine();

					System.out.println("Set the City:");
					String uCity2 = bf.readLine();

					System.out.println("Set the Pincode:");
					int uPincode2 = Integer.parseInt(bf.readLine());

					uptUser.setId(uId2);
					uptUser.setName(uName2);
					uptUser.setCity(uCity2);
					uptUser.setPincode(uPincode2);
					int updateUser = dao.updateUser(uptUser);
					System.out.println("User updated succesfull:" + updateUser);

					System.out.println();
					System.out.println();

					System.out.println("Updated User is:" + uptUser.getId() + "\n" + uptUser.getName() + "\n"
							+ uptUser.getCity() + "\n" + uptUser.getPincode());
					}else {
						System.out.println("No User Found with Id:"+uId2);
					}

					System.out.println(
							"----------------------------------------------------------------------------------------------------");

					break;

				case 3:
					// Delete the User
					System.out.println("Enter Id you want to Delete:");
					int uId3 = Integer.parseInt(bf.readLine());

					int   deleteUser = dao.deleteUser(uId3);

					if (deleteUser > 0) {
					    System.out.println("User deleted successfully: " + deleteUser);
					} else {
					    System.out.println("User not found or deletion failed.");
					}

					System.out.println("Operation completed.");

					System.out.println(
							"----------------------------------------------------------------------------------------------------");

					break;

				case 4:
					// Get the User by id
					System.out.println("Enter Id you want to get:");
					int uId4 = Integer.parseInt(bf.readLine());

					User getSingleUser = dao.getSingleUser(uId4);
					if(getSingleUser==null) {
						System.out.println("User Not found");
					}else {
						System.out.println();
						System.out.println();

						System.out.println("User is:" + getSingleUser.getId() + "\n" + getSingleUser.getName() + "\n"
								+ getSingleUser.getCity() + "\n" + getSingleUser.getPincode());
					}
					System.out.println(
							"----------------------------------------------------------------------------------------------------");

					break;

				case 5:

					// Get all user

					List<User> users = dao.getAllUser();
					System.out.println("All user is listed:");
					for (User list : users) {
						System.out.println(list.getId());
						System.out.println(list.getName());
						System.out.println(list.getCity());
						System.out.println(list.getPincode());
						System.out.println(
								"----------------------------------------------------------------------------------------------------");
					}
					break;

				case 6:

					System.out.println();
					System.out.println();

					go = false;
					System.out.println("Thank you for using the User Management System.");
					break;

					default:
						System.out.println("Invalid Choice. Try again");

				}

			} catch (Exception e) {
				System.out.println("Please choose from 1-6");
				e.getMessage();
			}
		}









// **************Inserting********************************************************************
//		User user = new User();
//        user.setId(1);
//        user.setName("Yasif khan");
//        user.setCity("Hydrabad");
//        user.setPincode(493221);
//        int result = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result);

//        user.setId(2);
//        user.setName("Ashh khan");
//        user.setCity("Pune");
//        user.setPincode(897659);
//        int result = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result);
//
//        user.setId(3);
//        user.setName("Zayn khan");
//        user.setCity("Raipur");
//        user.setPincode(490221);
//        int result3 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result3);
//
//        user.setId(4);
//        user.setName("Faiz khan");
//        user.setCity("Banglore");
//        user.setPincode(987345);
//        int result4 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result4);
//
//        user.setId(5);
//        user.setName("Ahil khan");
//        user.setCity("Karnataka");
//        user.setPincode(790043);
//        int result5 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result5);
//
//        user.setId(6);
//        user.setName("The Rock");
//        user.setCity("WWE");
//        user.setPincode(348790);
//        int result6 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result6);
//
//        user.setId(7);
//        user.setName("Yasif khan");
//        user.setCity("Hydrabad");
//        user.setPincode(493221);
//        int result7 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result7);
//
//        user.setId(8);
//        user.setName("John cena");
//        user.setCity("Hollywood");
//        user.setPincode(123456);
//        int result8 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result8);
//
//        user.setId(9);
//        user.setName("Triple H");
//        user.setCity("Nagpur");
//        user.setPincode(978563);
//        int result9 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result9);
//
//        user.setId(10);
//        user.setName("Call of coder");
//        user.setCity("COD");
//        user.setPincode(987456);
//        int result10 = dao.insertUser(user);
//        System.out.println("User added succesfull: "+result10);

// ******************Updating********************************************************************
//        user.setId(5);
//        user.setName("ahil Zayn khan");
//        user.setCity("Kareli");
//        user.setPincode(102938);
//        int updt = dao.updateUser(user);
//        System.out.println("User updated succesfull: "+updt);

		// ******************Deleting********************************************************************
//       int dele = dao.deleteUser(9);
//       System.out.println("User Deleted Succesfull: "+dele);

		// ******************Select Single
		// User********************************************************************
//        User gettingUser = dao.getSingleUser(7);
//        System.out.println(gettingUser);

		// ******************Getting all
		// user********************************************************************
//        List<User> users = dao.getAllUser();
//
//        for(User allUser:users) {
//        	System.out.println(allUser);
//        }

	}
}
