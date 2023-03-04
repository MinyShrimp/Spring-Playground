package shrimp.playground.member.exception;

public class NotFoundMemberException extends RuntimeException {

    public NotFoundMemberException() {
        super("회원을 찾을 수 없습니다.");
    }

    public NotFoundMemberException(Throwable cause) {
        super("회원을 찾을 수 없습니다.", cause);
    }
}
