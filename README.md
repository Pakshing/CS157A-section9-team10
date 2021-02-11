Please note that as of now the application only runs on Google Chrome due to bootstrap styling.
# Running the Application
1. Install Tomcat, Java JDK, and MySQL. 
2. Opening the project in Eclipse, change jdbcURL, dbUser, and dbPassword in Auth.java to your own MySQL url, user, and password.
3. To export a .war file, in Eclipse, right click on the project and select “Export -> WAR file”. This will generate a .war file you can deploy to Tomcat.
4. Start up your Tomcat server and navigate to “localhost:8080/manager/html”
   - At this point you will likely be asked for a manager password, enter one if you have already set one up, if not follow this [link's](http://tomcat.apache.org/tomcat-8.0-doc/manager-howto.html#Configuring_Manager_Application_Access) instructions to set one up.
5. Scroll down to the Deploy section where you should see a subsection “WAR file to deploy” 
6. Choose the .war file you generated and click deploy.
7. Back at the top of the page you should now see the name of the .war file you deployed clicking on it will lead you to the homepage of the application



# About this application
This application provides functionality for our three types of users; general users, authorities, and admin. The admin user is included as a separate type of user.

Users: These are the general public who can view the posts made by other people in the same county. They are able to post a report by providing the necessary information (incident, address, etc). They can also search and reply to other users' posts that are pertaining to the same crime. The users can also save posts for ease of access.

Authorities: The authorities are the people from departments such as the Fire dept., Ambulance, Police dept., and other departments like animal, weather, etc. People from each department keep an eye on the posts and approve the legitimacy of the reported crime. If the crimes are not legitimate, they have the access to remove a post. They can further act according to the nature of the situation. 

Admins: The admin is the main programmer behind the whole web application who administers all the posts and checks for the legitimacy of the posts that are posted by the general users. They have the ability to remove any user’s posts. This is to allow false reports to be filtered out.


1. Reporting/Posting Information
The user will be able to post a report of an incident
The system will require the user to fill out a form about said incident. This information will be stored in the database

2. View Posted Reports
The user will be able to see a post and view the corresponding report
The system will provide the report the user wishes to view

3. User Feed
The user will see a list of recent posts from other users.
The system will retrieve the recent posts and display them on the user’s activity page

4. Edit/Delete Post
The user will be able to edit or delete their own posts as they wish
The system will retrieve the post and update it based on the user’s new input
The system will delete the corresponding post in the database
5. Reply to posts
The user will be able to reply to other users’ posts.
The system will link the replies to the corresponding report within the database

6. Notifications 
Authorities can request that they are notified of new incidents in an area
The system will check for new incidents and return those fitting indicated criteria

7. Create User Account
User accounts are only required for doing more than just viewing. Different account types include general users, authorities, and admins. 
The system provides a form to create an account. They have an option to register if they don’t already have an account.

8. Flag/remove false reports
Admins can flag or remove reports deemed incorrect or not relevant
The system will remove designated reports from the database and add/remove flags as requested

9. Search for Reports
Users are able to search through the database for posts with given parameters.
The system will return to the user any reports matching their request parameters and let them know if none are found.

10. Save Posts
User will be able to save any posts to view later
The system will flag the posts saved by the user and display them in the “Saved Posts” Tab

11. Get User Information
Authorities are able to retrieve the contact information of the user in order to follow up investigation
The system will ensure that authorities are able to see this information when displaying reports/posts

12. Announcement Page
Authorities can make a public announcement on the Announcement page.

13. Members From Departments
List all the authorities and their departments

