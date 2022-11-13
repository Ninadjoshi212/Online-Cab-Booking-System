# FLYWHEEL CABS - Online Cab Booking Application

<p align="center">
<img width="800" height="400" src="https://thumbs.dreamstime.com/b/taxi-online-service-calling-car-via-mobile-app-people-waiting-city-transport-gps-route-tracking-man-woman-use-gadget-map-238545411.jpg">
</p>
<br>

> We have created REST API for Online Cab Booking Application which can be used by Customers and Drivers to login into their profile, update their details and Book Cabs with option to select cab type and the cab or driver availability.<br><br>

> All this is over looked by the Admin who can access the data in the application.<br><br>

> We have implemented data and user validation at every step, for every user.<br><br>

> It has all the basic facilities that are required by an end user to have a convenient and hassle free **Online Cab Booking Experience**. <br><br>

<br>

# *** Team Members ***

-   <a href="https://uditshetty.github.io/" target="_blank" rel="noopener noreferrer" > Udit Varshney </a>
-   <a href="https://ninadjoshi212.github.io/" target="_blank" rel="noopener noreferrer" > Ninad Joshi </a>
-   <a href="https://prathmeshs-0595.github.io/" target="_blank" rel="noopener noreferrer" > Prathmesh Shelar </a>
-   <a href="https://aniket427.github.io/" target="_blank" rel="noopener noreferrer" > Aniket Bhandarkar </a>
-   <a href="https://jagatjit15.github.io/" target="_blank" rel="noopener noreferrer" > Jagatjit Barik </a>

<br>

# *** Tech Stacks ***

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

# *** Installation and Run ***
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

# API / Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`

<br>

# *** ER Diagram ***
![flywheel png](https://user-images.githubusercontent.com/101566760/201507233-0651cce1-c423-4949-86b0-9d0b304a3b6d.png)

<br>

# *** Swagger UI ***
# Login Controller
[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/loginCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/loginCntrl.jpg?raw=true)

<br>

# Admin Controller
- Admin can access all the information of customer, cab driver and cab.
- Admin can access all Trip Details along with specific trip details using a particular cab or a customer.

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/adminCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/adminCntrl.jpg?raw=true)

<br>

# Customer Controller
- Customer can login in the application and update their information using their mobile and password.
- Customer can book trips using pickup location and destination.
- Customer can access the invoice after the trip is completed.
- Customer can rate the driver based on the trip experience.

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/CustomerCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/CustomerCntrl.jpg?raw=true)

<br>

# Driver Controller
- Cab Driver can login in the application and update their information.
- Cab driver can add and update their cab details.
- Cab Driver can mark their availability according to the trips status.

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/driverCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/driverCntrl.jpg?raw=true)

<br>

# Cab Controller
- Cab controller provides functionality to count the cab by type. 
- Cab controller provides functionality to fetch the cab by type.
- Cab controller provides functionality to update cab details.

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/cabCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/cabCntrl.jpg?raw=true)

<br>

# Trip Controller
- Trip controller provides functionality to book, update and cancel trips.
- Trip controller provides functionality to get the list of previous trip data.

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/tripCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/tripCntrl.jpg?raw=true)

<br>
