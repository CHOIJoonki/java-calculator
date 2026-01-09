# java-calculator

# 단계별 기능 상세

## Step 1: 기본 사칙연산기
- 사용자가 **두 개의 양의 정수**와 **사칙연산 기호**를 입력하면 해당 연산을 수행합니다.
- `while` 문을 사용하여 **반복 계산**이 가능하며, `exit`을 입력하면 프로그램이 종료됩니다.
- **예외 처리**:
    - 숫자가 아닌 값 입력 시 예외 처리.
    - `0`으로 나눌 경우 예외 처리.

---

## Step 2: 객체지향적 설계 (Calculator 클래스)
- **역할 분리**
    - 연산 로직은 `Calculator` 클래스,
    - 입출력(UI) 로직은 `App` 클래스로 분리.
- **상태 관리**
    - 계산 결과를 `ArrayList`에 저장하고,
    - `removeResult()` 메서드로 특정 결과를 삭제할 수 있습니다.
- **캡슐화**
    - 모든 필드를 `private`으로 선언하고,
    - `Getter/Setter`를 통해 접근 제한을 구현.

---

## Step 3: 고급 Java 기술 적용
- **Generic 사용**
    - `ArithmeticCalculator<T extends Number>` 클래스를 구현하여  
      `Integer`, `Double` 등 다양한 숫자 타입을 지원.
- **Enum 활용**
    - 사칙연산 기호를 `OperatorType` 열거형으로 관리하여  
      코드의 **가독성**과 **타입 안정성** 향상.
- **Stream API**
    - `stream().filter()`를 사용하여  
      저장된 결과 중 특정 기준보다 큰 값만 추출 가능.
- **심화 예외 처리**
    - `ArithmeticException` 및 잘못된 숫자 형식(`NumberFormatException`)에 대해 세밀한 예외 처리 적용.

---

## 기술 스택
| 구분 | 내용 |
|------|------|
| **Language** | Java 17 (또는 이상) |
| **IDE** | IntelliJ IDEA / Eclipse / VS Code |
| **Features** | Generics, Stream API, Lambda, Collections Framework, Enum |

---

##  실행 방법
1. 저장소를 클론합니다.
2. `src/step3/App.java` 파일을 실행합니다.
3. 안내 메시지에 따라 숫자와 연산자를 입력합니다.
4. 계산 완료 후 다음 명령어로 추가 기능을 테스트하세요:
    - `remove`: 저장된 계산 기록 삭제
    - `biggerthan`: 특정 값보다 큰 결과만 조회
