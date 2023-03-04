package shrimp.playground.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import shrimp.playground.member.dto.AddRequestDto;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE member SET delete_on = now() where id=? and delete_on is null")
@Where(clause = "delete_on is null")
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String password;

    @CreationTimestamp
    private Timestamp createOn;

    private Timestamp deleteOn;

    public MemberEntity(
            AddRequestDto dto
    ) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }
}
