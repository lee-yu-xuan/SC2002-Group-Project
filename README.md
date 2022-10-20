# SC2002-Group-Project
MOBLIMA is an application to computerize the processes of making online booking and purchase of movie tickets, listing of movies and sale reporting. It will be used by the moviegoers and cinema staff.

The following are information about the application:
  • The application acts as a centralized ‘location’ for making bookings for all the
Cineplexes in different locations managed by the vendor.
  • Each Cineplex will have 3 or more cinemas.
  • The movie ticket price can be charged according to the following type :
    a. type of movie (3D, Blockbuster, etc.),
    b. class of cinema (e.g. Platinum Movie Suites)
    c. age of movie-goer (e.g. adult, senior citizen, child)
    d. day of the week or public holiday.
  An example is shown in Appendix A.
  • Movie listings and showtimes can be queried and booking can be made.
  • From the movie listings, movie-goer can also view the information about the movie.
  Information like
    a. Movie title
    b. Showing status [Coming Soon, Preview, Now Showing]
    c. SYNOPSIS – movie abstract
    d. Director
    e. Cast (at least 2)
    f. Overall reviewer rating (1 – 5 [best])
    g. Past reviews and reviewers’ ratings
    Movie-goer can also enter his/her review and rating.
    [The overall rating is the average (to 1 decimal place) of the all individual ratings for
    the particular movie. **Overall reviewer rating will only be displayed if there are more
    than ONE individual rating, else “NA” is displayed**]
  • A layout of each cinema will be presented for seat selections upon booking.
  [the layout will contain aisle and main stairway. Refer to Appendix A for reference]
  • Upon booking, the application will capture the movie-goer’s name, mobile number
  and email address. Each payment will have a transaction id (TID). The TID is of the
  format XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m :
  minutes, XXX : cinema code in letters). [ you will decide on the cinema code]
  
  • Movie-goer can check their history of bookings.
  For cinema staff only :
    a. Cinema staff needs to login to access its functions
    b. Cinema staff can configure the system settings (e.g., ticket prices, holidays,
    etc.)
    c. Cinema staff can enter the forthcoming movies, its type (Blockbuster/3D,
    etc.), movie rating (e.g. PG), show times, the cinema, showing status
    (Coming Soon, Preview, Now Showing, End Of Showing), etc.
    d. Cinema staff can also update the details of the movies or remove the movie
    by changing the status to ‘End of Showing’.
    e. Cinema staff can list the current top 5 ranking movies by
      i. Ticket sales (display the movie title and total sales)
      ii. Overall reviewers’ rating (display the movie title and overall
      rating)
      
Functional Requirements (to be demonstrated):
Admin module
  1. Login
  2. Create/Update/Remove movie listing
  3. Create/Update/Remove cinema showtimes and the movies to be shown
  4. Configure system settings
  5. 
Movie-goer module
  1. Search/List movie
  2. View movie details – including reviews and ratings
  3. Check seat availability and selection of seat/s.
  4. Book and purchase ticket
  5. View booking history
  6. List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings

(Note : you may re-order or re-phrase the above functionalities when displaying your
application menu)

The application is to be developed as a Console-based application (non-Graphical UI).
Data should be stored in flat file format, either in text or binary. Refer to your eLearning
Topics in NTULearn on FileI/O. Samples are provided for the reading/writing of text or
binary (Serializable) file. [ Learn from the fundamentals].
No database application (eg MySQL, MS Access, etc) is to be used. No JSON or XML is to
be used.
You can populate your movies items with data collected from the internet.
*You will create your own test cases and data to test your application thoroughly. However,
you should also create test cases to test for cases of
    • configuring a holiday date and the ticket price is shown correctly when
      booking is done on that date
    • booking on a different day of the week or holiday and type of cinema (eg
      suite to demonstrate the differences in prices
    • configuring “End of Showing” date and the movie should not be listed for
      booking
    • booking only allowed for “Preview” and “Now Showing” status.
    
*The test cases above need to be demonstrated.

Assumptions :
  (1) This is a single-user application and there is no need to consider concurrent access.
  (2) THREE cineplexes will be created for the demonstration.
  (3) The currency will be in Singapore Dollar (SGD) and inclusive of Good and Services Tax
      (GST).
  (4) A simple login for cinema staff is sufficed.
  (5) Payment will always be successful.
  (6) There is no need to interface with external system, e.g. Payment, printer, etc., but you can
      consider it in your design.
  (7) Senior citizen can be purchased online without validation of identity or age. The
  validation will be done upon entering the cinema.
