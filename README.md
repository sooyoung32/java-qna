# 질문답변 게시판
## 진행 방법
* 질문답변 게시판에 대한 html template은 src/main/resources 디렉토리의 static에서 확인할 수 있다. html template을 통해 요구사팡을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)
* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtu.be/a5c9ku-_fok)


#요구사항
## 기능 요구사항
* 로그인에 성공하면 HttpStatus.FOUND을 status code로 응답해야 한다. 응답 후에 이동할 경로는 "/users"이다.
로그인에 실패하면 templates/user 디렉토리의 login_failed.html을 응답으로 보낸다.
## 프로그래밍 요구사항
* 로그인 기능을 ATDD 기반으로 구현해야 한다.
* User에 대한 단위 테스트를 구현해야 한다.
* UserService 클래스의 login() 메소드를 구현해 src/test/java의 모든 테스트 메소드가 성공해야 한다.
힌트
* codesquad.web.UserAcceptanceTest 소스 코드를 참고해 LoginAcceptanceTest를 구현하면서 시작한다.
* codesquad.web.UserAcceptanceTest 소스 코드의 create() 테스트 메소드를 참고해 서버에 데이터를 전송한다.

