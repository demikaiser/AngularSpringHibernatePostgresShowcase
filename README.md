# AngularSpringHibernatePostgresShowcase

## Summary

This project is a showcase of a simple CRUD webapp by using full stack technologies (Angular, Java Spring, Java Hibernate, and PostgreSQL database). The front-end is called a rest client because it requests data and processes data modification through the restful calls to the back-end. The back-end is connected to the PostgreSQL database and acts as a proxy between the front-end and the database.

## API Specifications

### GET {address}/users
Returns all users in the database.

### GET {address}/randomusers
Fetches one random record from an online data repository (https://jsonplaceholder.typicode.com/users) and save it to the local database, then returns all users in the database.

### GET {address}/user/{id}
Returns only one user information which corresponds to the provided id.

### Delete {address}/user/{id}
Deletes the user with the id in the database.

### Put {address}/user
Modifies the user information in the database.

### Post {address}/user
Creates a new user with information provided in the database.
