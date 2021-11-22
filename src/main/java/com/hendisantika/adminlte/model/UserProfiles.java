package com.hendisantika.adminlte.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profiles")
public class UserProfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "thumbnail", length = 255)
    private String thumbnail;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "fk_user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "id")
    private Users user;

    @CreatedDate
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Builder
    public UserProfiles(String thumbnail, String description){
        this.thumbnail = thumbnail;
        this.description = description;
    }
}
