# SC2002-Group-Project
MOBLIMA is an application to computerize the processes of making online booking and purchase of movie tickets, listing of movies and sale reporting. It will be used by the moviegoers and cinema staff.

# File Organisation
All of our code are located in src/main/java. The main function of our program is Main_UI.java, which located in the **ui** folder. All java code is organised based on their functionality. 

For example, MovieListing.java, which controls all the movie object instances, is located in the **movie** folder.

Javadoc folder includes all of the javadoc files of our project.

Lib folder includes the references library (opencsv.jar) we used in this project.

# Setup
We use VSCode to implement our project. Feel free to use other IDE, but VSCode is the best way to review our project.

We use OpenCSV for the CRUD operation to the CSV file.

To setup the VSCode for OpenCSV:
1. Open our project in VSCode
2. Goto the reference library, select opencsv.jar from the lib file
3. You are good to go!

You can also follow [this](https://stackoverflow.com/questions/50232557/visual-studio-code-java-extension-how-to-add-a-jar-to-classpath#:~:text=1.1.1.jar%22%0A%20%20%20%20%5D%0A%7D-,Option%202%3A%20Via%20User%20Interface,-If%20Java%20Extension) to import opencsv.jar to the project.

Should you setup our project correctly, you should see the following output after running Main_UI.java:

--Welcome to MovieTickeing Application--
1. Login
2. Continue as Guest
3. Register new User
4. Quit Application

# To start the program...
Run Main_UI.java, the main class of our project, which located in src/main/java/ui. 

