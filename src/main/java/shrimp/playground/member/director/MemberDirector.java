package shrimp.playground.member.director;

import shrimp.playground.member.dto.request.AddRequest;
import shrimp.playground.member.dto.response.AddResponse;
import shrimp.playground.member.entity.MemberEntity;

public class MemberDirector {

    private MemberDirector() {
    }

    public static MemberEntity addRequestToEntity(AddRequest body) {
        return new MemberEntity(
                body.getName(),
                body.getEmail(),
                body.getPassword()
        );
    }

    public static AddResponse entityToAddResponse(MemberEntity entity) {
        return new AddResponse(
                entity.getName(),
                entity.getEmail(),
                entity.getCreateOn()
        );
    }
}
