package cn.yinguowei.admin.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static cn.yinguowei.admin.entity.Gender.randomGender;


/**
 * @author yinguowei 2018/3/5.
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
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

//    String mobile;

    @Enumerated(EnumType.STRING) Gender gender = randomGender();
//    String address;

    @CreatedDate
    LocalDateTime createdDate;
    @CreatedBy
    String createdBy;
    @LastModifiedDate
    LocalDateTime lastModifiedDate;
    @LastModifiedBy
    String lastModifiedBy;
}