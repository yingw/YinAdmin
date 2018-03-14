# Spring Boot Application

## Setup project

- Setup up this project using IDES's new project guide, or
- Go to http://start.spring.io/ and create project using Spring Initializr.

Select Spring Boot version 2.0.0.RELEASE (2018-3-14)

And choose these dependencies
 ```
 - DevTools
 - Lombok
 - Rest Repositories
 - JPA
 - H2
```

Run with: `mvn spring-boot:run`

Visit [http://localhost:8080](http://localhost:8080)

## Create a simple domain module to test

User
```java
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id @GeneratedValue
    Long id;

    @NonNull @NotNull @Column(unique = true)
    String username;

    @NonNull @NotNull @JsonIgnore
    String password;

    @NotNull @NonNull
    String fullname;

    Boolean enabled = true;

    @NotNull @NonNull
    String email;

    @Enumerated(EnumType.STRING) Gender gender = randomGender();
}
```
User Repo
```java
public interface UserRepository extends JpaRepository<User, Long> {
}
```
Test data
```java
@Component
class UserData implements CommandLineRunner {
    private static final String MAIL_SUFFIX = "@example.com";
    private static final String[] TEST_USER_NAMES = {"Anna", "Jojo", "Gary"};

    private final UserRepository userRepository;

    UserData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of(TEST_USER_NAMES).forEach(name -> userRepository.save(new User(name.toLowerCase(), PASSWORD, name, name.toLowerCase() + MAIL_SUFFIX)));
        userRepository.findAll().forEach(System.out::println);
    }
}

```

Setup properties:
```properties
# log level
logging.level.cn.yinguowei.admin=debug
spring.jpa.show-sql=true
# to fix a warning 
spring.jpa.open-in-view=false
# change to /api for later use of /
spring.data.rest.base-path=/api
```

> About open-is-view, read [This article](https://github.com/spring-projects/spring-boot/issues/7107).

Finally, rebuild (for you choose DevTools) to hot deploy, or rerun to have a test at: http://localhost:8080/api/users

## TODO

dependencies:
```
 - Security
 - Cache
 - Web
 - MySQL
 - Actuator
```

Change to yml?

## Audit
```java
@EntityListeners(AuditingEntityListener.class)
```

```java
@CreatedDate
LocalDateTime createdDate;
@CreatedBy
String createdBy;
@LastModifiedDate
LocalDateTime lastModifiedDate;
@LastModifiedBy
String lastModifiedBy;
```