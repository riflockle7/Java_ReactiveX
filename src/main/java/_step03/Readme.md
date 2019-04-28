# Step03

## Single, Maybe, Completable
- Observable의 특수한 형태들이 있다.

### Single
> - Observable의 특수한 형태
> - 데이터를 오직 **한 개**만 발행하도록 제한 (보통은 **제한없이** 발행가능)
> - Observable에 데이터가 여러개 있을 시 Exception 발생!!
> - 결과가 유일한 서버 API를 호출할 때 유용하게 사용
> - take를 통해 데이터를 여러 개 호출하려 할 시 Exception 발생!!
> 
> <pre><code>// default
> Single<String> single = Single.just("Hello world!");
> single.subscribe(System.out::println);
> 
> // Observable -> Single 변환 가능
> Observable<String> src1 = Observable.just("Hello world");
> Single.fromObservable(src1).subscribe(System.out::println); 
> 
> //Observable (empty) -> Single
> Observable.empty()
>         .single("Hello world")            // create
>         .subscribe(System.out::println);  // 실행
> 
> // Observable -> Array
> String[] names = {"Thomas", "Tom", "Tommy"};
> String[] empty = {};
> Observable.fromArray(names)
>         .first("TTT")                     // default Value (null 일시 적용됨)
>         .subscribe(System.out::println);  // 실행
> 
> //take 함수를 사용해 Single 객체 생성
> Observable.just("Hello world", "Hi world")    // Observable 생성 (2개짜리 데이터)
>         .take(1)                              // parameter 개수만큼 발행
>         .single("What's up world")            // Observable -> Single (1개만 발행)
>         .subscribe(System.out::println);      // 실행</code></pre>

### Maybe
> - 데이터가 0개 (onComplete) 또는 1개 (Single) 를 발행할 수 있음
> - Single 개념 + **onComplete()**
>   > onComplete()  
>   > - 여기서의 onComplete는 의미가 좀 다름
>   > - 기존 : 모든 과정이 성공적으로 수행될 시, 해당 함수가 실행됨
>   > - Maybe : 데이터가 0개인 경우 해당 함수가 실행됨

### Completable
> - onComplete, onError 만을 가짐
> - 비동기 처리 후 반환되는 결과가 없는 경우, 완료 또는 오류에만 관심이 있는 경우 사용

### 참고
> - [RxJava: Single, Maybe and Completable](https://android.jlelse.eu/rxjava-single-maybe-and-completable-8686db42bac8)
> - [Maybe Type](https://www.baeldung.com/rxjava-maybe)
> - [RxJava Ninja: Single, Maybe and Completable](https://medium.com/tompee/rxjava-ninja-single-maybe-and-completable-b5907dddc5e4)
> - [RxJava: Single, Maybe and Completable](https://android.jlelse.eu/rxjava-single-maybe-and-completable-8686db42bac8)

