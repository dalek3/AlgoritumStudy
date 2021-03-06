## 스택
- 먼저 들어간 것이 나중에 나오는 자료구조
    - LIFO 구조체
    - 스택 기본연산
        - push
        - pop
        - peek
    - 배열 기반의 스택
    - 연결 리스트 기반의 스택

    `void StackInit(Stack * pstack);`
    - 스택의 초기화를 진행한다.
    - 스택 생성 후 제일 먼저 호출되어야하는 함수이다.

    `int SIsEmpty(Stack * pstack);`
    - 스택이 빈 경우 TRUE(1)을, 그렇지 않은경우 FALSE(0)을 반환한다.

    `void SPush(Stack * pstack, Data data);`
    - 스텍에 데이터를 저장한다. 매개변수 data로 전달된 값을 저장한다.

    `Data SPop(Stack * pstack);`
    - 마지막에 저장된 요소를 삭제한다.
    - 삭제된 데이터는 반환이 된다.
    - 본 함수의 호출을 위해서는 데이터가 하나이 사존재함이 보장되어야 한다.

    `Data SPeek(Stack * pstack);`
    - 마지막에 저장된 요소를 반환하된 삭제하지 않는다.
    - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.


1. 스택기반 타입 선언
```C
#define TRUE 1
#define FALSE 0
#define STACK_LEN 100

typedef int Data;
typedef struct_arryStack
{
    Data stackArr[STACK_LEN];
    int topIndex;
} ArrayStack;
typedef ArrayStack Stack;
```
2. 연결 리스트 타입 선언
```C
typedef int Data;

typedef struct_node
{
    Data data;
    struct_node * next;
} Node;

typedef struct_listStack
{
    Node * head;
} ListStack;

typedef ListStack Stack;
```
