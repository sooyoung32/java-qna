package codesquad.domain;

import codesquad.UnAuthorizedException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuestionTest {
    /**
     * 힌트 - 애플리케이션 개발 순서
     요구사항을 분석한 후 인수 테스트에서 테스트할 Test Case, Service Layer(QnaService)에서 테스트할 Test Case, 도메인 클래스(Question)에서 테스트할 Test Case를 결정한다.
     각 영역에서 테스트할 Test Case를 결정하기 힘들면 가장 간단한 성공 케이스에서 시작한다.
     정상적으로 삭제되는 경우에 대한 인수 테스트 구현
     QuestionController에서 인수 테스트 요청을 처리하는 로직 구현
     QnaService와 Question 로직 구현을 설계하고, 테스트 추가한 후 구현
     먼저 QuestionTest 구현 후 Question 구현, 또는 QnaServiceTest 구현 후 QnaService 구현
     다른 예외 상황에 대한 인수 테스트를 구현한 후 Controller 이후 추가 구현
     */
    private Question question;
    private User user1;
    private User user2;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1L, "javajigi", "password", "name", "javajigi@slipp.net");
        user2 = new User(2L, "sanjigi", "password", "name", "sanjigi@slipp.net");
        question = new Question("title", "content");
        question.writeBy(user1);
    }

    @Test
    public void isOwner() {
        assertThat(question.isOwner(user1)).isTrue();
        assertThat(question.isOwner(user2)).isFalse();
    }

    @Test
    public void update() {
        question.update(user1, new Question("update", "update"));
        assertThat(question.getTitle()).isEqualTo("update");
    }

    @Test(expected = UnAuthorizedException.class)
    public void update_unauthorized() {
        question.update(user2, new Question("update", "update"));
    }

    @Test
    public void delete() {
        question.addAnswer(new Answer(user1, "answer"));
        List<DeleteHistory> histories = question.delete(user1);
        assertThat(question.isDeleted()).isTrue();
        assertThat(histories.size()).isEqualTo(2);
    }

    @Test(expected = UnAuthorizedException.class)
    public void delete_unauthorized() {
        question.delete(user2);

    }

    @Test
    public void addAnswer() {
        question.addAnswer(new Answer(user2,"answer"));
        assertThat(question.getAnswer(0).getContents()).isEqualTo("answer");
    }
}
