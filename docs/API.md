# API 문서

기본 URL:

```text
http://localhost:8080
```

## 인증 API

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

성공 응답 (`201 Created`):

```json
{
  "memberId": 1,
  "message": "회원가입에 성공했습니다."
}
```

### 로그인

```http
POST /api/auth/login
Content-Type: application/json
```

요청 예시:

```json
{
  "email": "test@example.com",
  "password": "password123!"
}
```

성공 응답 (`200 OK`):

```json
{
  "memberId": 1,
  "email": "test@example.com",
  "nickname": "테스터"
}
```

실패 응답:

- `400 Bad Request`: JSON 형식이 잘못됐거나 요청값 검증에 실패한 경우
- `401 Unauthorized`: 이메일이 존재하지 않거나 비밀번호가 일치하지 않는 경우

보안을 위해 이메일이 존재하지 않는 경우와 비밀번호가 일치하지 않는 경우에 같은 인증 실패 응답을 반환합니다.

## 게시글 API

구현 예정입니다.
