# Step01

### reactive keyword
- 반응을 보이는, 반응하는
  > - 관찰 가능한 흐름과 함께 비동기 프로그래밍을 위한 api  
  > - 옵저버 pattern 과 이터레이터 pattern, 그리고 함수형 프로그래밍을 이용한 반응형 프로그램

- ~한다면, ~라면
  > - (버튼을 클릭) 한다면 / (로그인이 완료된 상태) 라면 / (데이터가 변경된 상태) 라면  
  > - 위의 조건문을 구독하는 개념
  > - 위의 조건 발생 시, 그 조건에 매치된 명령문들이 실행됨

<pre><code>// 기존 프로그래밍 방식
// 정해진 절차에 따라 순차적으로 코드 실행
System.out.println("doc1");
System.out.println("doc2");
System.out.println("doc3");
</code></pre>

<pre><code>// RxJava를 활용한 프로그래밍 방식
// 데이터의 정의 후 
Observable.just("doc1", "doc2", "doc3").subscribe(System.out::println);
</code></pre>