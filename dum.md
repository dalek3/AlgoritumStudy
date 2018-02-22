추상 자료형(ADT)

배열 이용한 리스트 

- 리스트 초기화
    void ListInit(List * plist);
    - 초기화할 리스트의 주소 값을 인자로 전달한다.
    - 리스트 생성 후 제일 먼저 호출되어야 하는 함수
- 데이터 저장
    void LInsert(List * plist, LData data);
    - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
- 저장된 데이터의 탐색 및 탐색 초기화
    int LFirst(List * plist, LData * pdata);
    - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
    - 데이터의 참조를 위한 초기화가 진행된다.
    - 참조 성공시 TRUE(1), 실패 시 FALSE(0)반환
    - LData는 저장 대상의 자료형을 결정할 수 있도록 typedef로 선언된 자료형의 이름이다.
- 다음 데이터의 참조(반환)을 목적으로 호출
    int LNext(List * plist, LData * pdata);
    - 참조된 데이터의 다음데이터가 pdata가 가리키는 메모리에 저장된다.
    - 순차적인 참조를 위해서 반복 호출이 가능하다.
    - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
    - 참조 성공 시 TRUE(1), 실패 시 FALSE(0)반환
- 바로 이전에 참조(반환)이 이뤄진 데이터의 삭제
    LData LRemove(List * plist);
    - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
    - 삭제된 데이터는 반환된다.
    - 마지막 반환 데이터를 삭제하므로 연이은 반복 호출을 허용하지 않는다.
- 현재 저장되어 있는 데이터의 수를 반환
    int LCount(List * plist);
    - 리스트에 저장되어 있는 데이터의 수를 반환한다.

#define TRUE 1
#define FALSE 0

#defin LIST_LEN
typedef int LData //저장할 대상의 자료형을 변경을 위한 선언
typedef struct __ArrayList  // 저장할 대상의 자료형을 변경하기 위한 typedef
{
    LData arr[LIST_LEN];    // 리스트의 저장소인 배열
    int numOfData;          // 저장된 데이터의 수
    int curPosition;        // 데이터 참조위치를 기록
} ArrayList;                // 배열 기반 리스트를 의미하는 구조체

typef ArrayList List;   //리스트의 변경을 용이하게 하기위한 typdef

연결 리스트


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

- 리스트 초기화
    void ListInit(List * plist);
    - 초기화할 리스트의 주소 값을 인자로 전달한다.
    - 리스트 생성 후 제일 먼저 호출되어야 하는 함수
- 데이터 저장
    void LInsert(List * plist, LData data);
    - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
- 저장된 데이터의 탐색 및 탐색 초기화
    int LFirst(List * plist, LData * pdata);
    - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
    - 데이터의 참조를 위한 초기화가 진행된다.
    - 참조 성공시 TRUE(1), 실패 시 FALSE(0)반환
    - LData는 저장 대상의 자료형을 결정할 수 있도록 typedef로 선언된 자료형의 이름이다.
- 다음 데이터의 참조(반환)을 목적으로 호출
    int LNext(List * plist, LData * pdata);
    - 참조된 데이터의 다음데이터가 pdata가 가리키는 메모리에 저장된다.
    - 순차적인 참조를 위해서 반복 호출이 가능하다.
    - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
    - 참조 성공 시 TRUE(1), 실패 시 FALSE(0)반환
- 바로 이전에 참조(반환)이 이뤄진 데이터의 삭제
    LData LRemove(List * plist);
    - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
    - 삭제된 데이터는 반환된다.
    - 마지막 반환 데이터를 삭제하므로 연이은 반복 호출을 허용하지 않는다.
- 현재 저장되어 있는 데이터의 수를 반환
    int LCount(List * plist);
    - 리스트에 저장되어 있는 데이터의 수를 반환한다.
- 정렬의 기준을 설정하기위해 정의된함수 이 함수의 선언 및 정의를 이해하기 위해서는 '함수 포인터'에대한 이해가 필요하다
    void SetSortRule(List * plist, int (*comp)(LData d1, LData d2));
    - 리스트에 정렬의 기준이 되는 함수를 등록한다.

- 원형 연결 리스트

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

- 리스트 초기화
    void ListInit(List * plist);
    - 초기화할 리스트의 주소 값을 인자로 전달한다.
    - 리스트 생성 후 제일 먼저 호출되어야 하는 함수
- 노드를 꼬리에 추가
    void LInsert(List * plist, Data data);
    - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
- 노드를 머리에 추가
    void LInsertFront(List * plist, Data data);

- 저장된 데이터의 탐색 및 탐색 초기화
    int LFirst(List * plist, Data * pdata);
    - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
    - 데이터의 참조를 위한 초기화가 진행된다.
    - 참조 성공시 TRUE(1), 실패 시 FALSE(0)반환
    - LData는 저장 대상의 자료형을 결정할 수 있도록 typedef로 선언된 자료형의 이름이다.
- 다음 데이터의 참조(반환)을 목적으로 호출
    int LNext(List * plist, Data * pdata);
    - 참조된 데이터의 다음데이터가 pdata가 가리키는 메모리에 저장된다.
    - 순차적인 참조를 위해서 반복 호출이 가능하다.
    - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
    - 참조 성공 시 TRUE(1), 실패 시 FALSE(0)반환
- 바로 이전에 참조(반환)이 이뤄진 데이터의 삭제
    Data LRemove(List * plist);
    - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
    - 삭제된 데이터는 반환된다.
    - 마지막 반환 데이터를 삭제하므로 연이은 반복 호출을 허용하지 않는다.
- 현재 저장되어 있는 데이터의 수를 반환
    int LCount(List * plist);
    - 리스트에 저장되어 있는 데이터의 수를 반환한다.

- 스택
    - 먼저 들어간 것이 나중에 나오는 자료구조
    - LIFO 구조체
    - 스택 기본연산
        - push
        - pop
        - peek
    - 배열 기반의 스택
    - 연결 리스트 기반의 스택

    void StackInit(Stack * pstack);
    - 스택의 초기화를 진행한다.
    - 스택 생성 후 제일 먼저 호출되어야하는 함수이다.

    int SIsEmpty(Stack * pstack);
    - 스택이 빈 경우 TRUE(1)을, 그렇지 않은경우 FALSE(0)을 반환한다.

    void SPush(Stack * pstack, Data data);
    - 스텍에 데이터를 저장한다. 매개변수 data로 전달된 값을 저장한다.

    Data SPop(Stack * pstack);
    - 마지막에 저장된 요소를 삭제한다.
    - 삭제된 데이터는 반환이 된다.
    - 본 함수의 호출을 위해서는 데이터가 하나이 사존재함이 보장되어야 한다.

    Data SPeek(Stack * pstack);
    - 마지막에 저장된 요소를 반환하된 삭제하지 않는다.
    - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.


- 스택기반 타입 선언
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

- 연결 리스트 타입 선언
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

- 큐
    - LIFO구조
    - 기본연산
        - enqueue
        - dequeue
    - 운영체제 관점에서 보면 프로게스나 쓰레드의 관리에 활용이 되는자료구조
    - 배열 기반의 큐
    - 연결리스트 기반의 큐

    void QueueInit(Queue * pq);
    - 큐의 초기화를 진행한다.
    - 큐 생성 후 제일 먼저 호출되어양 하는 함수이다.

    int QIsEmpty(Queue * pq);
    - 큐가 빈 경우 TRUE(1)을, 그렇지않은 경우 FALSE(0)을 반환하다.

    void Enqueue(Queue * pq, Data data);
    - 큐에 데이터를 저장한다. 매개변수 data로 전달된 값을 저장한다.

    Data Dequeue(Queue * pq);
    - 저장순서가 가장 앞선 데이터를 삭제한다.
    - 삭제된데이터는 반환된다.
    - 본함수의 호출을 위해서는 데이터가 하나 이상 돈재함이 보장되어야 한다.

    Data QPeek(Queue * pq);
    - 저장순서가 가장 앞선 데이터를 반환하되 삭제하지 않는다.
    - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.

- 원형큐

- 배열기반
#define QUE_LEN 100
typedef int Data;

typedef struct _cQueue
{
    int front;
    int rear;
    Data queArr[QUE_LEN];
} CQueue;

typedef CQueue Queue;

void QueueInit(Queue * pq);
int QIsEmpty(Queue * pq);

void Enqueue(Queue * p, Data data);
Data Dequeue(Queue * pq);
Data QPeek(Queue * pq);

//
int NextPosIdx(int pos)
{
    if(pos == QUE_LEN-1)
        return 0;
    else
        return pos+1;
}

- 연결리스트 기반

typedef int Data;

typedef struct_node
{
    Data data;
    struct_node * next;
} Node;

typedef struct_lQueue
{
    Node * front;
    Node * rear;
}

typedef LQueue Queue;

void QueueInit(Queue * pq);
int QIsEmpty(Queue * pq);

void Enqueue(Queue * p, Data data);
Data Dequeue(Queue * pq);
Data QPeek(Queue * pq);

- 트리
    - 계층적 관계를 표현하는 자료구조

- 이진트리
    - 조건
        - 루트 노드를 중심으로 두개의 서브 트리로 나뉘어진다.
        - 나뉘어진 두 서브 트리도 모두 이진트리이어야한다.
    - 트리와 이진트리는 구조가 재귀적이다.
    그러므로 관련된연산은 재귀적으로 구현

- 배열기반

    - 노드에 번호를 부여하고 그 번호에 해당하는 값을 배열의 인덱스 값으로 활용
    - **편의상 배열의 첫번째 요소는 사용하지 않는다.**

    - 장점
        - 접근이 용이
// 노드이자 이진트리를 표현한 구조체 정의
- 이진 트리의 모든 노드는 직/간접적으로 연결되어 있다.
- 따라서 루트 노드의 주소 값만 기억하면, 인진 트리 전체를 가리키는것과 다름이 없다.
typedef struct_bTreeNode
{
    BTData data;
    struct _bTreeNode * left;
    struct _bTreeNode * right;
} BTreeNode;

- 하나의 노드는 그 자체로 이진트리이다.

    BTreeNode * MakeBTreeNode(void);    //노드의 생성
    BTData GetData(BTreeNode * bt);     //노드에 저장된 데이터를 반환
    void SetData(BTreeNode * bt, BTData data);  //노드에 데이터를 저장

    //노드에 직접 접근하는 것보다 함수를 통한 접근이 보다 칭찬받을 수 있는 구조

    BTreeNode * GetLeftSubTree(BTreeNode * bt); //왼쪽 서브 트리의 주소 값 반환
    BTreeNode * GetRightSubTree(BTreeNoe * bt);
    //오른쪽 서브 트리의 주소 값 반환

    - 루트 노드를 포함하여 어떠한 노드의 주소 값도 인자로 전달될 수 있다.
    - 전달된 노드의 왼쪽, 오른쪽 '서브 노드의 루트 노드 주소 값' 또는 그냥 '노드의 주소 값'이 반환된다.

    void MakeLeftSubTree(BTreeNode * main, BTreeNode * sub);    //main의 서브 왼쪽 서브 트리로 sub를 연결

    void MakeRightSubTree(BTreeNode * main, BTreeNode * sub);   //main의 오른쪽 서브트리로 sub를 연결

- 우선순위 큐
    - 우선순위를 근거로 작성 위치를 찾아서 데이터를 저장하는 방식
    1 배열 기반
    2 연결 리스트 기반
    3 힙 기반

    1,2 방법은 모두 최악의 겨우 새 데이터릐 위치를 찾기위해서 기존에 저장된 모든 데이터와 비교를 진행해야한다.


- 힙(Heap)
    - 완전 이진트리
    - 최대힙
        - 모든 노드에 저장된 값은 자식 노드에 저장된 값보다 크거나 같아야 한다.
        즉 루트 노드에 저장된 값이 가장 커야 한다.
    - 최소힙
        - 모든 노드에 저장된 값은 자식 노드에 저장된 값보다 작거나 같아야 한다.
        즉 루트 노드에 저장된 값이 가장 작아야 한다.

- 배열기반 데이터 삽입의 시간 복잡도 O(n)
- 배열기반 데이터 삭제의 시간 복잡도 O(1)

- 연결리스트 기반 데이터 삽입의 시간 복잡도 O(n)
- 연결리스트 기반 데이터 삭제의 시간 복잡도 O(1)

- 힙 기반 데이터 삽입의 사간복잡도 O(log2n)
- 힙 기반 데이터 삭제의 사간복잡도 O(log2n)
// 여기서 말하는'완전이진트리'인 힙은 배열을 기반으로 구현

- 배열기반으로 힙 구현
    - 연결리스트를 기반으로 힙을 구현하면, 새로운 노들를 힙의 '마지막 위치에 추가하는 것이 쉽지 않음'

    - 완전이진트리
    - 힙의 구현은 배열을 기반으로 하며 인덱스가 0인 요소는 비워둔다.
    - 따라서 **힙에 저장된 노드의 개수와 마지막 노드의 고유번호는 일치한다.**
    - 노드의 고유번호는 노드가 저장되는 배열의 인덱스 값이 된다.
    - 우선순위를 나타내는 정수 값이 작을수록 높은 우선순위를 나타낸다고 가정한다.

    - 인덱스 값 구하기
        - 왼쪽 자식 노드의 인덱스 값 : 부모노드의 인덱스 값 * 2
        - 오른쪽 자식 노드의 인덱스 값 : 부모노드의 인덱스 값 * 2 + 1
        - 부모 노드의 인덱스 값 : 자식노드의 인덱스 값 / 2
    
    typedef char HData;
    typedef int Priority;

    typedef struct _heapElem
    {
        Priority pr;    //값이 작을수록 높은 우선순위
        HData data;
    } HeapElem;

    typedef struct _heapElem
    {
        int numOfData;
        HeapElem heapArr[HEAP_LEN];
    } Heap;

    void HeapInit(Heap * ph);
    int HIsEmpty(Heap * ph);

    void HInsert(Heap * ph, HData data, Priority pr);
    HData HDelete(Heap * ph);   //우선수위가 가장 높은 데이터 삭제되도록 정의

    int GetParentIDX(int idx);  //부모 노드의 인덱스 값 반환
    int GetLChildIDX(int idx);  //왼쪽 자식 노드의 인덱스 값 반환
    int GetRChilIDX(int idx);   //오른쪽 자식 노드의 인덱스 값 반환
    int GetPriChildIDX(Heap * ph,int idx);  //우선 순위가 높은 자식의 인덱스 값 반환



