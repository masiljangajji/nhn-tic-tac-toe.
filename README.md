# NHN 과제 tic - tac -toe



# 고려 사항

- MVC 패턴을 기반으로한 패키지 구조 설정 
- 기능들에 대해 Junit5을 사용한 Test Code 작성
- Check Style, Code Style 적용
- Logging 설정

---


# 기능 설명

0. 게임은 3 x 3 배열의 Board판으로 진행한다.


1. Board 판 자동 생성 , 좌표 List 자동 생성 


2. Player는 X,O 중 하나를 고른다 (X - 선턴 , O - 후턴)


3. Board판에 체크한다 
   1.   사용자의 경우 직접 입력 받음
   2.   컴퓨터의 경우 자동으로 입력  
   3.   컴퓨터는 좌표 List를 이용해 입력받는다


4. 가로 , 세로 , 대각선 방향으로 체크된다면 승리 


---

# 입력

### 체크할 Symbol 입력

```
Press 1 : Select O  |  Press 2: Select X 
```

### Y 좌표 입력

```
체크할 Y 좌표를 입력해 주세요
```

### X 좌표 입력

```
체크할 X 좌표를 입력해 주세요
```

---

# 출력

### 게임 시작 문구

```
tic-tac-toe 게임을 시작합니다 
 O | X 중 하나를 선택해주세요
Press 1 : Select O  |  Press 2: Select X
```

### 게임이 진행되는 Board판 

```
   |   |   
---------
 O |   |   
---------
   |   | X 
```

### 게임 결과

```
Player가 이겼습니다 !!
게임 종료
```


# 실행 결과 예시

### 정상 작동 결과

```
tic-tac-toe 게임을 시작합니다 
 O | X 중 하나를 선택해주세요
Press 1 : Select O  |  Press 2: Select X
2
체크할 Y 좌표를 입력해 주세요
3
체크할 X 좌표를 입력해 주세요
3
   |   |   
---------
 O |   |   
---------
   |   | X 
체크할 Y 좌표를 입력해 주세요
2
체크할 X 좌표를 입력해 주세요
2
   |   |   
---------
 O | X | O 
---------
   |   | X 
체크할 Y 좌표를 입력해 주세요
1
체크할 X 좌표를 입력해 주세요
1
Player가 이겼습니다 !!
게임 종료
```

---

## 유효성 검사 목록

### 다음의 경우에 유효성을 검사합니다

#### - Symbol 선택이 올바르지 못한 경우( X = 2 O = 1)

#### - 좌표 값이 올바르지 못한 경우 ( 1<=좌표값<=3 )

#### - 체크할 좌표가 중복일 경우

---

## 테스트 목록

#### - 좌표 값 입력

#### - 좌표 List 삭제

#### - 무승부여부 판별 

#### - 승리여부 판별

