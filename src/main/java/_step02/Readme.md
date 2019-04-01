# Step02

## ReactiveX 3대 keyword
> ### **RX** = OBSERVABLE + OBSERVER + SCHEDULERS  
>

#### Observable (공급자)
> - 데이터 스트림
> - 하나의 스레드에서 다른 스레드로 전달 할 데이터를 압축
> - 생애주기동안 한번만 데이터를 방출
><pre><code>// 1. '데이터의 흐름' 을 먼저 정의
>Observable<String> database = Observable.just("doc1", "doc2", "doc3");</code></pre>
> 
> Observable의 factory 함수
> ##### 단일 데이터
> - just : 인자로 넣은 데이터를 차례로 발행
>   <pre><code>Observable.just("doc1", "doc2", "doc3");</code></pre>
> - create : onNext, onComplete를 개발자가 직접 호출
>   <pre><code>Observable<String> database = Observable.create(new ObservableOnSubscribe<String>(){
>       @Override
>       public void subscribe(ObservableEmitter<String> emitter) throws Exception {
>           emitter.onNext("doc1");
>           emitter.onNext("doc2");
>           emitter.onNext("doc3");
>           emitter.onComplete();
>       }
>   });</code></pre>
>
> ##### 여러 데이터
> - fromArray : 인자로 배열 데이터
>   <pre><code>Observable.just("doc1", "doc2", "doc3");</code></pre>
> - fromIterable : 인자로 넣은 Collection 데이터 (ArrayList, Hashmap 등)
>   <pre><code>Observable<String> databaseIterable = Observable.fromIterable(iterable);</code></pre>
> - fromCallable : Callable 변수 (함수) 
>   <pre><code>Callable<String> callable = new Callable<String>() {
>       @Override
>       public String call() throws Exception {
>           return "doc1";
>       }
>   };
>
>   Observable<String> databaseCallable = Observable.fromCallable(callable);</code></pre>
>
> - 기타 factory 함수
>   (), fromFuture(), fromPublisher(), interval(), range(), timer(), defer()

#### Observers (소비자)
> - Observable에 의해 방출된 데이터 스트림을 소비
> - subscribeOn() 메서드를 사용해서 observable을 구독 및 방출(emit)하는 데이터 수신
> - 방출될 때마다, onNext() 콜백으로 데이터를 수신 
> - Observable에서 에러 발생 시, onError()에서 에러를 수신
>
>   **implement method**  
>   - onSubscribe : 구독 시작 시, 해당 콜백 실행  
>   - onNext : 이전 데이터를 수신 받고 해당 콜백 실행 (이후 다음 데이터로 넘어감)
>   - onError : 중도 에러 발생 시, 해당 콜백으로 에러 정보 수신
>   - onComplete : 모든 과정이 성공적으로 수행될 시, 아래 콜백이 실행됨 (onError 발생 시 실행되지 않음)

><pre><code>// 2. Observable 내 데이터를 구독
>Observer<String> observer = new Observer<String>() {
>    // 구독 시작 시, 해당 콜백 실행
>    @Override
>    public void onSubscribe(Disposable d) {
>        System.out.println("onSubscribe() execute Thread is " + Thread.currentThread().getName());
>        System.out.println("구독 시작.");
>    }
>
>    // 이전 데이터를 수신 받고 해당 콜백 실행 (이후 다음 데이터로 넘어감)
>    @Override
>    public void onNext(String value) {
>        System.out.println("onNext() execute Thread is " + Thread.currentThread().getName());
>        System.out.println(value);
>    }
>
>    // 에러 발생 시, 해당 콜백으로 에러 정보 수신
>    @Override
>    public void onError(Throwable e) {
>        System.out.println("onError() execute Thread is " + Thread.currentThread().getName());
>        System.out.println(e.toString());
>    }
>
>    // 모든 과정이 성공적으로 수행될 시, 아래 콜백이 실행됨
>    @Override
>    public void onComplete() {
>        System.out.println("onComplete() execute Thread is " + Thread.currentThread().getName());
>        System.out.println("다 끝났다.");
>
>    }
>};</code></pre>

#### Schedulers (매니저)
> - Observable 과 Observers 에게 그들이 실행되어야 할 스레드를 알려주는 Rx의 구성요소
> - subscribeOn(), observeOn() 메서드를 통해 Observable / Observers 에게 관찰해야 할 스레드를 알려줄 수 있다.
>
>   **extension function**      
>   - subscribeOn : observable 이 어느 스레드에서 동작할 것인지 정의  
>   - observeOn : observer 가 어느 스레드에서 동작할 것인지 정의
><pre><code>database
>    .subscribeOn(Schedulers.newThread())   // Observable will run on parameter thread. (default main)
>    .observeOn(Schedulers.io())            // Observer will run on parameter thread.   (default main)
>    .subscribe(observer);                  // Subscribe the observer</code></pre>


