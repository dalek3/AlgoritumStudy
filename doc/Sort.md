# 정렬(sort)

1. selection sort
2. bubble sort
3. insertion sort
   - simple, slow
--------------------
4. merge sort 
5. quick sort 
6. heap sort
   - fast
------------------------
7. radix sort (기수 정렬)
   - O(N)


## 1. selection sort
```
    selectionSort(A[], n){
        for last <- downto 2{                   ----- 1
            A[1...last] 중 가장 큰 수 A[k]를 찾는다; -- 2
            A[k] <-> A[last];                   ----- 3
        }
    }
```
- 실행시간:
    1의  for 루프는 n-1번 반복
    2에서 가장 큰 수를 찾기 위한 비교횟수:n-1,n-2,...,2,1
    3의 교환은 상수 시간 작업
- 시간복잡도 : O(n^2)

## 2. bubble sort
```
    bubbleSort(A[], n){
        for last <- n downto 2 {                  -------- 1
            for i <- to last-1                    -------- 2
                if(A[i] > A[i+1]) then A[i] <-> A[i+1]; -- 3
        }
    }
```

- 수행시간
    1의 for 루프는 n-1번 반복
    2의 for 루프는 각각 n-1,n-2,...,2,1번 반복
    3의 교환은 상수 시간 작업
- 시간복잡도 :O(n^2)

## 3. insertion sort
```
    insertionSort(A[], n) {
        for i <- 2 to n {                      ----------- 1
            A[1...i]의 적당한 자리에 A[i]를 삽입한다. ------ 2
        }
    }
```
- 수행시간
    1의 for루프는 n-1번 반복
    2의 삽입은 최악의 경우 i-1번 비교
- 시간복잡도 :O(n^2)

## - 분할정복법
- 분할 : 해결하고자 하는 문제를 작은 크기의 동일한 문제들로 분할
- 정복 : 각각의 작은 문제를 순환적으로 해결
- 합병 : 작은 문제의 해를 합하여(merge)원래 문제에 대한 해를 구함

## 4. 합병정렬(merge sort)
- 데이터가 저장된 배열을 절반으로 나눔
- 각각을 순환적으로 정렬
- 정렬된 두 개의 배열을 합쳐 전체를 정렬
```
    mergeSort(A[], p, r){
        if(p<r) then {
            q <- (p+q)/2;
            mergeSort(A,p,q);
            mergeSort(A,q+1 , r);
            merge(A,p,q,r);
        }
    }
    merge(A[], p, q, r){
        정렬되어 있는 두 배열 A[p...q]와 A[q+1...r]을 합하여
        정렬된 하나의 배열 A[p...r]을 만든다.
    }
```
- 시간복잡도 : O(nlog2n)

## 5. Quick sort

- 배열을 다음과 같은 조건이 만족되도록 두 부분으로 나눈다.
    - elements in lower parts <= elements in upper parts
- 각 부분을 순환적으로 정렬한다.
- nothing to do

- 정렬할 배열이 주어짐, 마지막 수를 기준(pivot)으로 삼는다.
- 기준보다 작은 수는 기준의 왼쪽에 나머지는 기준의 오른쪽에 오도록 재배치(분할)한다.
- 기준의 왼쪽과 오른쪽을 각각 **순환적으로** 정렬한다(정렬완료)
```
    quickSort(A[], p, r){
        if (p<r) then {
            q = partition(A, p,r);
            quickSort(A, p,q-1);
            quickSort(A, q+1,r)l
        }
    }

    partition(A[] , p, r){
        배열 A[p...r]의 원소들을 A[r]을 기준으로 양쪽으로 
        재배치하고 A[r]이 자리한 위치를 return한다.
    }
    partition(A,p,r){
        x<-A[r];
        i<-p-1;
        for j<-p to r-1
            if A[j] <= x then
                i <= i+1;
                exchange A[i] and A[j];
            exchange A[i+1] and A[r];
            return i+1;
    }
```
- Pivot의 선택
    - 첫번째 값이나 마지막 값을 피봇으로 선택
        - 이미 정렬된 데이터 혹은 거꾸로 정렬된 데이터가 최악의 경우
        - 현실의 데이터는 랜덤하지 않으므로(거꾸로) 정렬된 데이터가 입력으로 들어올 가능성은 매우 높음
        - 따라서 좋은 방법이라고 할 수 없음
    - "Median of Three"
        - 첫번째 값과 마지막 값, 그리고 가운데 값 중에서 중간값(median)을 피봇으로 선택
        - 최악의 경우 시간 복잡도가 달라지지는 않음
    - Randomized quicksort
        - 피봇을 랜덤하게 선택
        - no worst cse instance , but worst case execution
        - 평균 시간 복잡도 : O(nlogn)
- 시간복잡도
    - 항상 한쪽은 0개, 다른 쪽은 n-1로 분할되는 경우
        
    - 이미 정렬된 입력데이터(마지막 원소를 피봇으로 선택하는 경우)
       - O(^2)
    - 항상 절반으로 분할되는 경우
       - O(nlogn)


