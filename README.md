# fullstack-board

Spring Boot와 Next.js를 연동해 회원가입, 로그인, 게시판 CRUD를 구현하는 풀스택 학습 프로젝트입니다.

## 기술 스택

### Backend

- Java 17
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Spring Security
- Bean Validation
- MySQL
- Maven

### Frontend

- Next.js 예정
- TypeScript 예정

### Deployment

- Docker / Docker Compose 예정
- AWS EC2 예정

## 프로젝트 구조

```text
fullstack-board/
├── backend/              # Spring Boot API 서버
├── frontend/             # Next.js 애플리케이션
├── .gitignore
└── README.md
```

현재 백엔드는 기능 단위로 패키지를 구성합니다.

```text
backend/src/main/java/com/yujin/fullstackboard/
├── config/
└── member/
    ├── controller/
    ├── dto/
    ├── entity/
    ├── repository/
    └── service/
```

## 구현 현황

- [x] [백엔드 기반 및 회원가입 API 구축](https://github.com/LeeEugene1/fullstack-board/issues/1)
  - Spring Boot 프로젝트 구성
  - MySQL 및 JPA 연결
  - 회원 엔티티와 권한 Enum 구성
  - 이메일·닉네임 중복 검사
  - BCrypt 비밀번호 암호화
  - 회원가입 API
- [ ] [로그인 API](https://github.com/LeeEugene1/fullstack-board/issues/2)
- [ ] [JWT 인증 및 인가](https://github.com/LeeEugene1/fullstack-board/issues/3)
- [ ] [게시글 CRUD](https://github.com/LeeEugene1/fullstack-board/issues/4)
- [ ] [게시글 작성자 권한 검사](https://github.com/LeeEugene1/fullstack-board/issues/5)
- [ ] [공통 예외 처리](https://github.com/LeeEugene1/fullstack-board/issues/6)
- [ ] [백엔드 테스트 코드](https://github.com/LeeEugene1/fullstack-board/issues/7)
- [ ] [Next.js 프론트엔드](https://github.com/LeeEugene1/fullstack-board/issues/8)
- [ ] [Docker Compose](https://github.com/LeeEugene1/fullstack-board/issues/9)
- [ ] [AWS EC2 배포](https://github.com/LeeEugene1/fullstack-board/issues/10)

## 로컬 실행 방법

### 사전 준비

- JDK 17
- MySQL

### 데이터베이스 생성

MySQL에 접속한 뒤 프로젝트용 데이터베이스와 사용자를 생성합니다.

```sql
CREATE DATABASE fullstack_board
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

CREATE USER 'fullstack_user'@'localhost'
    IDENTIFIED BY 'your_password';

GRANT ALL PRIVILEGES
    ON fullstack_board.*
    TO 'fullstack_user'@'localhost';

FLUSH PRIVILEGES;
```

### 환경변수 설정

애플리케이션 실행 전에 다음 환경변수를 설정합니다.

```text
DB_USERNAME=fullstack_user
DB_PASSWORD=your_password
```

IntelliJ에서는 `Run > Edit Configurations > Environment variables`에서 설정할 수 있습니다.

실제 DB 비밀번호는 Git에 커밋하지 않습니다.

### 백엔드 실행

```bash
cd backend
./mvnw spring-boot:run
```

기본 실행 주소는 `http://localhost:8080`입니다.

## API 문서

요청·응답 형식과 상태 코드는 [API 문서](docs/API.md)에서 관리합니다.

## 보안 원칙

- 비밀번호는 BCrypt로 암호화해 저장합니다.
- DB 비밀번호와 JWT 비밀키는 환경변수로 관리합니다.
- `.env`와 IDE 로컬 설정은 Git에 커밋하지 않습니다.
- 운영 환경의 MySQL 포트는 외부에 공개하지 않습니다.

## 학습 목표

- REST API 계층 구조 이해
- DTO와 Entity 역할 분리
- JPA 기반 CRUD와 연관관계 학습
- Spring Security와 JWT 인증 구현
- Next.js와 Spring Boot 연동
- Docker Compose 및 AWS EC2 배포 경험
