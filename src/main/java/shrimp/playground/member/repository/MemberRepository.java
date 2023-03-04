package shrimp.playground.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shrimp.playground.member.entity.MemberEntity;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, UUID> {
}
