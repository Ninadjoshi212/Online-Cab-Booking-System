> # FLYWHEEL CABS - Online Cab Booking Application

<p align="center">
<img width="800" height="400" src="https://thumbs.dreamstime.com/b/taxi-online-service-calling-car-via-mobile-app-people-waiting-city-transport-gps-route-tracking-man-woman-use-gadget-map-238545411.jpg">
</p>
<br>

> We have created REST API for Online Cab Booking Application which can be used by Customers and Drivers to login into their profile, update their details and Book Cabs with option to select cab type and the cab or driver availability.<br><br>

> All this is over looked by the Admin who can access the data in the application.<br><br>

> We have implemented data and user validation at every step, for every user.<br><br>

> It has all the basic facilities that are required by an end user to have a convenient and hassle free **Online Cab Booking Experience**. <br><br>

<br>

> # *** Team Members ***

-   <a href="https://uditshetty.github.io/" target="_blank" rel="noopener noreferrer" > Udit Varshney </a>
-   <a href="https://ninadjoshi212.github.io/" target="_blank" rel="noopener noreferrer" > Ninad Joshi </a>
-   <a href="https://prathmeshs-0595.github.io/" target="_blank" rel="noopener noreferrer" > Prathmesh Shelar </a>
-   <a href="https://aniket427.github.io/" target="_blank" rel="noopener noreferrer" > Aniket Bhandarkar </a>
-   <a href="https://jagatjit15.github.io/" target="_blank" rel="noopener noreferrer" > Jagatjit Barik </a>

<br>

> # *** Tech Stacks ***

-   Java Core
-   Spring Data JPA
-   Spring web
-   Validation
-   Spring Boot
-   Hibernate
-   MySQL
-   Swagger UI
-   Lombok
-   Postman

<br>


> # Features

This Java based REST API project have featurs like Register, Login, Logout, Update, Booking,  canceling or deleting, giving rating
Some features describes bellow according to their role . 


> ### For Admin
- Admin can register himself.
- For doing next admin tasks with database admin should login himself".
- Assigning any available cab to any driver.
- Can see all tripdetails of a Customer.
- Managing everytrip by cabwise means which cab are booked more.
- Getting data about how many trips are booked per day or for a period of day.
- Update own details and also logout and delete own data.

> ### For Customer
- Customer can register himself.
- For booking any cab or trip he/she should login first".
- Booktrip / A cab.
- Cancel a trip / delete a trip data.
- Viweing own travel history.
- Can rate drive based on trip exxperience.
- Can find bestDriver available by rating.
- Fetching Invoice for total travel details/spends on trip.
- Updating own tripdetails before a timeperiod.
- Logout, update details, delete account.

> ### For Driver
- Driver can register himself.
- Mantaining how many trips have been made by him/her.
- updating own data.
- registering own car and type.


<br>


> # *** Installation and Run ***
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per your local database config.
```
   server.port=8888
   spring.datasource.url=jdbc:mysql://localhost:3306/FlyWheeldb
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.username=**mysql username**
   spring.datasource.password=**mysql password**
   spring.jpa.hibernate.git ddl-auto=update
```

<br>

> # API / Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`

<br>

> # *** ER Diagram ***
![flywheel png](https://user-images.githubusercontent.com/101566760/201507233-0651cce1-c423-4949-86b0-9d0b304a3b6d.png)

<br>

> # *** Swagger UI ***
# Login Controller
-Provides login and logout functionality

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/loginCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/loginCntrl.jpg?raw=true)

<br>

# Admin Controller

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/adminCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/adminCntrl.jpg?raw=true)

<br>

# Customer Controller

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/CustomerCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/CustomerCntrl.jpg?raw=true)

<br>

# Driver Controller

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/driverCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/driverCntrl.jpg?raw=true)

<br>

# Cab Controller

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/cabCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/cabCntrl.jpg?raw=true)

<br>

# Trip Controller

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/tripCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/tripCntrl.jpg?raw=true)

<br>
