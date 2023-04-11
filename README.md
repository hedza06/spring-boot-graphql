## Spring Boot and GraphQL
This demo project demonstrates integration between Spring Boot and GraphQL.
Integrating GraphQL with Spring Boot is straightforward. Spring Boot provides a range of 
tools and libraries for building GraphQL APIs.

### How to integrate Spring Boot with GraphQL
To integrate GraphQL with Spring Boot, you can follow these general steps:
1. Define your GraphQL schema. Example is located in directory `src/main/resources/graphql`
2. Use the `graphql-spring-boot-starter` library to expose your GraphQL API over HTTP
3. Use the `GraphQL UI` (http://localhost:8080/graphiql) for exploring and testing GraphQL API

### Examples from this demo
GraphQL schema is defined into file `schema.graphqls` located on `src/main/resources/graphql`.
Developed endpoints are:
- Get all users
- Get user by unique identifier (id)
- Get page of users
- Create user
- Get all roles
- Get all departments

Example 1 (Get all users):
```
query {
    allUsers {
        id
        email
        age
        department {
            id
            name
        }
    }
}
```

Example 2 (Get page of users):
```
query {
  usersPage(page: 0, size: 10) {
    data {
      id
      email
      roles {
        name
      }
    }
    totalElements
    totalPages
  }
}
```

Example 3 (Get all departments):
```
query {
    allDepartments {
        id
        name
    }
}
```

Example 4 (Create user):
```
mutation {
    createUser(user: {
        firstName: "Jack"
        lastName: "Sparow"
        email: "jack.sparow@test.com"
        age: 40
        department {
            id: 1
        }
        roles: [{
            id: 1
        }]
    }) {
        id
        email
        age
    }
}
```

### Contribution/Suggestions
If someone is interested in contribution or have some suggestions please contact me on email hedzaprog@gmail.com.

### Author
Heril Muratović  
Software Engineer

Mobile/Viber/WhatsUp: +382 69 657 962  
Email: hedzaprog@gmail.com  
Skype: hedza06  
Twitter: herilmuratovic  
LinkedIn: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
StackOverflow: https://stackoverflow.com/users/4078505/heril-muratovic