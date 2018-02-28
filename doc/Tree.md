## 트리
- 계층적 관계를 표현하는 자료구조

1. 이진트리
    - 조건
        - 루트 노드를 중심으로 두개의 서브 트리로 나뉘어진다.
        - 나뉘어진 두 서브 트리도 모두 이진트리이어야한다.
    - 트리와 이진트리는 구조가 재귀적이다.
    그러므로 관련된연산은 재귀적으로 구현

2. 배열기반

    - 노드에 번호를 부여하고 그 번호에 해당하는 값을 배열의 인덱스 값으로 활용
    - **편의상 배열의 첫번째 요소는 사용하지 않는다.**

    - 장점
        - 접근이 용이
// 노드이자 이진트리를 표현한 구조체 정의
- 이진 트리의 모든 노드는 직/간접적으로 연결되어 있다.
- 따라서 루트 노드의 주소 값만 기억하면, 인진 트리 전체를 가리키는것과 다름이 없다.

```C
typedef struct_bTreeNode
{
    BTData data;
    struct _bTreeNode * left;
    struct _bTreeNode * right;
} BTreeNode;
```

- 하나의 노드는 그 자체로 이진트리이다.
```C
    BTreeNode * MakeBTreeNode(void);                              //노드의 생성
    BTData GetData(BTreeNode * bt);                               //노드에 저장된 데이터를 반환
    void SetData(BTreeNode * bt, BTData data);                    //노드에 데이터를 저장

    //노드에 직접 접근하는 것보다 함수를 통한 접근이 보다 칭찬받을 수 있는 구조

    BTreeNode * GetLeftSubTree(BTreeNode * bt);                   //왼쪽 서브 트리의 주소 값 반환
    BTreeNode * GetRightSubTree(BTreeNoe * bt);                   //오른쪽 서브 트리의 주소 값 반환
```
- 루트 노드를 포함하여 어떠한 노드의 주소 값도 인자로 전달될 수 있다.
- 전달된 노드의 왼쪽, 오른쪽 '서브 노드의 루트 노드 주소 값' 또는 그냥 '노드의 주소 값'이 반환된다.
```C
    void MakeLeftSubTree(BTreeNode * main, BTreeNode * sub);      //main의 서브 왼쪽 서브 트리로 sub를 연결

    void MakeRightSubTree(BTreeNode * main, BTreeNode * sub);     //main의 오른쪽 서브트리로 sub를 연결
```
