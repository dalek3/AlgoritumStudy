## 리스트 
1. 배열 이용한 리스트 

- 리스트 초기화
    - `void ListInit(List * plist);`
        - 초기화할 리스트의 주소 값을 인자로 전달한다.
        - 리스트 생성 후 제일 먼저 호출되어야 하는 함수
- 데이터 저장
    - `void LInsert(List * plist, LData data);`
        - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
- 저장된 데이터의 탐색 및 탐색 초기화
    - `int LFirst(List * plist, LData * pdata);`
        - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
        - 데이터의 참조를 위한 초기화가 진행된다.
        - 참조 성공시 TRUE(1), 실패 시 FALSE(0)반환
        - LData는 저장 대상의 자료형을 결정할 수 있도록 typedef로 선언된 자료형의 이름이다.
- 다음 데이터의 참조(반환)을 목적으로 호출
    - `int LNext(List * plist, LData * pdata);`
        - 참조된 데이터의 다음데이터가 pdata가 가리키는 메모리에 저장된다.
        - 순차적인 참조를 위해서 반복 호출이 가능하다.
        - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
        - 참조 성공 시 TRUE(1), 실패 시 FALSE(0)반환
- 바로 이전에 참조(반환)이 이뤄진 데이터의 삭제
    - `LData LRemove(List * plist);`
        - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
        - 삭제된 데이터는 반환된다.
        - 마지막 반환 데이터를 삭제하므로 연이은 반복 호출을 허용하지 않는다.
- 현재 저장되어 있는 데이터의 수를 반환
    - `int LCount(List * plist);`
        - 리스트에 저장되어 있는 데이터의 수를 반환한다.
```
#define TRUE 1
#define FALSE 0

#definㄷ LIST_LEN
typedef int LData           //저장할 대상의 자료형을 변경을 위한 선언

typedef struct __ArrayList  // 저장할 대상의 자료형을 변경하기 위한 typedef
{
    LData arr[LIST_LEN];    // 리스트의 저장소인 배열
    int numOfData;          // 저장된 데이터의 수
    int curPosition;        // 데이터 참조위치를 기록
} ArrayList;                // 배열 기반 리스트를 의미하는 구조체

typedef ArrayList List;       // 리스트의 변경을 용이하게 하기위한 typdef
```
2. 연결 리스트
```
typedef struct_node
{
    int data;           // 데이터를 담을 공간
    struct_node * next  // 연결의 도구
} Node;

typedef struct _linkedList
{
    Node * head;                        // 더미 노드를 가리키는 멤버
    Node * cur;                         // 참조 및 삭제를 돕는 멤버
    Node * before;                      // 삭제를 돕는 멤버
    int numOfData;                      // 저장된 데이터의 수를 기록하기 위한 멤버
    int (*comp)(LData d1, LData d2);    // 정렬의 기준을 등록하기 위한 멤버
} LinkedList;
```
- 리스트 초기화
    - `void ListInit(List * plist);`
        - 초기화할 리스트의 주소 값을 인자로 전달한다.
        - 리스트 생성 후 제일 먼저 호출되어야 하는 함수
- 데이터 저장
    - `void LInsert(List * plist, LData data);`
        - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
- 저장된 데이터의 탐색 및 탐색 초기화
    - `int LFirst(List * plist, LData * pdata);`
        - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
        - 데이터의 참조를 위한 초기화가 진행된다.
        - 참조 성공시 TRUE(1), 실패 시 FALSE(0)반환
        - LData는 저장 대상의 자료형을 결정할 수 있도록 typedef로 선언된 자료형의 이름이다.
- 다음 데이터의 참조(반환)을 목적으로 호출
    - `int LNext(List * plist, LData * pdata);`
        - 참조된 데이터의 다음데이터가 pdata가 가리키는 메모리에 저장된다.
        - 순차적인 참조를 위해서 반복 호출이 가능하다.
        - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
        - 참조 성공 시 TRUE(1), 실패 시 FALSE(0)반환
- 바로 이전에 참조(반환)이 이뤄진 데이터의 삭제
    - `LData LRemove(List * plist);`
        - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
        - 삭제된 데이터는 반환된다.
        - 마지막 반환 데이터를 삭제하므로 연이은 반복 호출을 허용하지 않는다.
- 현재 저장되어 있는 데이터의 수를 반환
    - `int LCount(List * plist);`
        - 리스트에 저장되어 있는 데이터의 수를 반환한다.
- 정렬의 기준을 설정하기위해 정의된함수 이 함수의 선언 및 정의를 이해하기 위해서는 '함수 포인터'에대한 이해가 필요하다
    - `void SetSortRule(List * plist, int (*comp)(LData d1, LData d2));`
      - 리스트에 정렬의 기준이 되는 함수를 등록한다.

3. 원형 연결 리스트

```
typedef int Data;

typedef struct_node
{
    Data data;
    struct_node * next;
} Node;

typedef struct _CLL
{
    Node * tail;
    Node * cur;
    Node * before;
    int numOfData;
} CList;

typedef CList List;
```
- 리스트 초기화
    - `void ListInit(List * plist);`
        - 초기화할 리스트의 주소 값을 인자로 전달한다.
        - 리스트 생성 후 제일 먼저 호출되어야 하는 함수
- 노드를 꼬리에 추가
    - `void LInsert(List * plist, Data data);`
        - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
- 노드를 머리에 추가
    - `void LInsertFront(List * plist, Data data);`

- 저장된 데이터의 탐색 및 탐색 초기화
    - `int LFirst(List * plist, Data * pdata);`
        - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
        - 데이터의 참조를 위한 초기화가 진행된다.
        - 참조 성공시 TRUE(1), 실패 시 FALSE(0)반환
        - LData는 저장 대상의 자료형을 결정할 수 있도록 typedef로 선언된 자료형의 이름이다.
- 다음 데이터의 참조(반환)을 목적으로 호출
    - `int LNext(List * plist, Data * pdata);`
        - 참조된 데이터의 다음데이터가 pdata가 가리키는 메모리에 저장된다.
        - 순차적인 참조를 위해서 반복 호출이 가능하다.
        - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
        - 참조 성공 시 TRUE(1), 실패 시 FALSE(0)반환
- 바로 이전에 참조(반환)이 이뤄진 데이터의 삭제
    - `Data LRemove(List * plist);`
        - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
        - 삭제된 데이터는 반환된다.
        - 마지막 반환 데이터를 삭제하므로 연이은 반복 호출을 허용하지 않는다.
- 현재 저장되어 있는 데이터의 수를 반환
    - `int LCount(List * plist);`
        - 리스트에 저장되어 있는 데이터의 수를 반환한다.
