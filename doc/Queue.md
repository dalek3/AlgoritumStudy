## 큐
- LIFO구조
- 기본연산
    - enqueue
    - dequeue
- 운영체제 관점에서 보면 프로게스나 쓰레드의 관리에 활용이 되는자료구조
- 배열 기반의 큐
- 연결리스트 기반의 큐

    `void QueueInit(Queue * pq);`
    - 큐의 초기화를 진행한다.
    - 큐 생성 후 제일 먼저 호출되어양 하는 함수이다.

    `int QIsEmpty(Queue * pq);`
    - 큐가 빈 경우 TRUE(1)을, 그렇지않은 경우 FALSE(0)을 반환하다.

    `void Enqueue(Queue * pq, Data data);`
    - 큐에 데이터를 저장한다. 매개변수 data로 전달된 값을 저장한다.

    `Data Dequeue(Queue * pq);`
    - 저장순서가 가장 앞선 데이터를 삭제한다.
    - 삭제된데이터는 반환된다.
    - 본함수의 호출을 위해서는 데이터가 하나 이상 돈재함이 보장되어야 한다.

    `Data QPeek(Queue * pq);`
    - 저장순서가 가장 앞선 데이터를 반환하되 삭제하지 않는다.
    - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.

### 원형큐

1. 배열기반
```
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
```

2. 연결리스트 기반
```
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
```
