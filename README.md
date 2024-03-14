# API

## Benchmark
Spring MVC 버젼과 Spring WebFlux 버젼을 만들어서 JMeter로 부하테스트 진행하기
*Request*
> GET POST /benchmark HTTP/2
10000번 정도 loop을 도는 코드 적기

## 인증
### 로그인
*Request*
> POST /login HTTP/2
```json
{
    "id": "jerry901",
    "pw": "qwer1234"
}
```

*Response* 
> 200 OK
```json
{
    "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```

## 유저
### 생성
*Request*
> POST /users HTTP/2
```json
{
    "name": "Jerry",
    "id": "jerry901",
    "pw": "qwer1234",
}
```
*Response*
> 201 Created

## 캘린더
### 조회
*Request*
> GET /calendars/{:month} HTTP/2
> Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

*Response*
```json
[
    "2024-01-24",
    "2024-01-25",
]
```

## 일정
### 생성
*Request*
> POST /todos HTTP/2
> Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```json
{
    "datetime": "2024-01-24T05:00",
    "description": "강아지 밥주기"
}
```
*Response*
> 201 Created


### 조회
*Request*
> GET /todos/{:date} HTTP/2
> Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

*Response*
```json
[
    {
        "id": 1,
        "datetime": "2024-01-24T05:00",
        "description": "강아지 밥주기"
    },
    {
        "id": 2,
        "datetime": "2024-01-24T06:00",
        "description": "강아지 놀아주기"
    }
]
```

### 삭제
*Request*
> DELETE /todos/{:id} HTTP/2
> Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

*Response*
```json
[
    {
        "date": "2024-01-24",
        "todos": [
            {
                "datetime": "2024-01-24T05:00",
                "description": "강아지 밥주기"
            }
        ]
    },
    {
        "date": "2024-01-25",
        "todos": [
            {
                "datetime": "2024-01-25T06:00",
                "description": "강아지 놀아주기"
            }
        ]
    }
]
```

### 업데이트
*Request*
> PUT /todos/{:id} HTTP/2
> Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

*Response*
```json
{
    "datetime": "2024-01-25T06:00",
    "description": "강아지 놀아주기"
}
```
