# Step02

## Single, Maybe
- Observable의 특수한 형태들이 있다.

### Single
> - Observable의 특수한 형태
> - 데이터를 오직 **한 개**만 발행하도록 제한
> - 결과가 유일한 서버 API를 호출할 때 유용하게 사용
> 
> <pre><code>// default
> Single<String> single = Single.just("Hello world!");
> single.subscribe(System.out::println);
> 
> // Observable -> Single
> Observable<String> src1 = Observable.just("Hello world");
> Single.fromObservable(src1).subscribe(System.out::println); 
> 
> //Observable (empty) -> Single
> Observable.empty()
>         .single("Hello world")
>         .subscribe(System.out::println);
> 
> // Observable -> Array
> String[] names = {"Thomas", "Tom", "Tommy"};
> Observable.fromArray(names).first("TTT").subscribe(System.out::println);
> 
> //take 함수를 사용해 Single 객체 생성
> Observable.just("Hello world", "Hi world")
>         .take(1)
>         .single("What's up world")
>         .subscribe(System.out::println);</code></pre>

### Maybe
> - 데이터의 발행 없이 바로 데이터 발생을 완료
> - Single 개념 + **onComplete()**
>   > onComplete()  
>   > 모든 과정이 성공적으로 수행될 시, 해당 함수가 실행됨


### 참고
> [RxJava: Single, Maybe and Completable](https://android.jlelse.eu/rxjava-single-maybe-and-completable-8686db42bac8)
>  

