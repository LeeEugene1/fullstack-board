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

구현 예정입니다.

## 게시글 API

구현 예정입니다.
