## 우선순위 큐
- 우선순위를 근거로 작성 위치를 찾아서 데이터를 저장하는 방식
    1. 배열 기반
    2. 연결 리스트 기반
    3. 힙 기반

    1,2 방법은 모두 최악의 겨우 새 데이터릐 위치를 찾기위해서 기존에 저장된 모든 데이터와 비교를 진행해야한다.


- 힙(Heap)
    - 완전 이진트리
    - 최대힙
        - 모든 노드에 저장된 값은 자식 노드에 저장된 값보다 크거나 같아야 한다.
        즉 루트 노드에 저장된 값이 가장 커야 한다.
    - 최소힙
        - 모든 노드에 저장된 값은 자식 노드에 저장된 값보다 작거나 같아야 한다.
        즉 루트 노드에 저장된 값이 가장 작아야 한다.

- 시간복잡도
    - 배열기반 데이터 삽입의 시간 복잡도 O(n)
    - 배열기반 데이터 삭제의 시간 복잡도 O(1)

    - 연결리스트 기반 데이터 삽입의 시간 복잡도 O(n)
    - 연결리스트 기반 데이터 삭제의 시간 복잡도 O(1)

    - 힙 기반 데이터 삽입의 사간복잡도 O(log2n)
    - 힙 기반 데이터 삭제의 사간복잡도 O(log2n)
        - 여기서 말하는'완전이진트리'인 힙은 배열을 기반으로 구현

1. 배열기반으로 힙 구현
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
  ```  
    typedef char HData;
    typedef int Priority;

    typedef struct _heapElem
    {
        Priority pr;                        //값이 작을수록 높은 우선순위
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
    HData HDelete(Heap * ph);               //우선수위가 가장 높은 데이터 삭제되도록 정의

    int GetParentIDX(int idx);              //부모 노드의 인덱스 값 반환
    int GetLChildIDX(int idx);              //왼쪽 자식 노드의 인덱스 값 반환
    int GetRChilIDX(int idx);               //오른쪽 자식 노드의 인덱스 값 반환
    int GetPriChildIDX(Heap * ph,int idx);  //우선 순위가 높은 자식의 인덱스 값 반환
```


