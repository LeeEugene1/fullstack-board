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

- [x] Spring Boot 프로젝트 구성
- [x] MySQL 및 JPA 연결
- [x] 회원 엔티티와 권한 Enum 구성
- [x] 이메일·닉네임 중복 검사
- [x] BCrypt 비밀번호 암호화
- [x] 회원가입 API
- [ ] 로그인 API
- [ ] JWT 인증 및 인가
- [ ] 게시글 CRUD
- [ ] 작성자 권한 검사
- [ ] 공통 예외 처리
- [ ] 테스트 코드
- [ ] Next.js 프론트엔드
- [ ] Docker Compose
- [ ] AWS EC2 배포

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

## API

### 회원가입

```http
POST /api/auth/signup
Content-Type: application/json
```

요청 예시:

```json
{
  "email": "test@example.com",
  "password": "password123!",
  "nickname": "테스터"
}
```

성공 응답 예시 (`201 Created`):

```json
{
  "memberId": 1,
  "message": "회원가입에 성공했습니다."
}
```

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
