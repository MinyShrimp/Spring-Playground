package shrimp.playground.member.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import shrimp.playground.member.entity.MemberEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@Transactional
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    void addMember() {
        // given
        MemberEntity entity = new MemberEntity("새우", "ksk7584@gmail.com", "qwer1234!");

        // when
        MemberEntity saveEntity = repository.save(entity);

        // then
        assertThat(saveEntity.equals(entity)).isTrue();
    }

    @Test
    void findMember() {
        // given
        MemberEntity entity = new MemberEntity("새우", "ksk7584@gmail.com", "qwer1234!");
        MemberEntity saveEntity = repository.save(entity);

        // when
        Optional<MemberEntity> findEntity = repository.findById(saveEntity.getId());

        // then
        assertThat(findEntity.isPresent()).isTrue();
        assertThat(findEntity.get().equals(saveEntity)).isTrue();
    }

    @Test
    void updateMember() {
        // given
        MemberEntity entity = new MemberEntity("새우", "ksk7584@gmail.com", "qwer1234!");
        MemberEntity saveEntity = repository.save(entity);

        Optional<MemberEntity> optionalMember = repository.findById(saveEntity.getId());
        assertThat(optionalMember.isPresent()).isTrue();

        // when
        MemberEntity findEntity = optionalMember.get();
        findEntity.setEmail("ksk7774@naver.com");
        repository.save(findEntity);

        Optional<MemberEntity> updateEntity = repository.findById(findEntity.getId());

        // then
        assertThat(updateEntity.isPresent()).isTrue();
        assertThat(updateEntity.get().getEmail()).isEqualTo("ksk7774@naver.com");
    }

    @Test
    void deleteMember() {
        // given
        MemberEntity entity = new MemberEntity("새우", "ksk7584@gmail.com", "qwer1234!");
        MemberEntity saveEntity = repository.save(entity);

        // when
        repository.delete(saveEntity);

        // then
        assertThat(
                repository.findById(saveEntity.getId()).isEmpty()
        ).isTrue();
    }
}
