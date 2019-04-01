package _step02;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class _02_Create_RxFlower {
    public static void main(String[] args) throws InterruptedException {
        // 1. '데이터의 흐름' 을 먼저 정의
        Observable<String> database = Observable.create(new ObservableOnSubscribe<String>(){
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("doc1");
                emitter.onNext("doc2");
                emitter.onNext("doc3");
                emitter.onComplete();
            }
        });

        // 2. 구독
        Observer<String> observer = new Observer<String>() {
            // 구독 시작 시, 해당 콜백 실행
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe() execute Thread is " + Thread.currentThread().getName());
                System.out.println("구독 시작.");
            }

            // 이전 데이터를 수신 받고 해당 콜백 실행 (이후 다음 데이터로 넘어감)
            @Override
            public void onNext(String value) {
                System.out.println("onNext() execute Thread is " + Thread.currentThread().getName());
                System.out.println(value);
            }

            // 에러 발생 시, 해당 콜백으로 에러 정보 수신
            @Override
            public void onError(Throwable e) {
                System.out.println("onError() execute Thread is " + Thread.currentThread().getName());
                System.out.println(e.toString());
            }

            // 모든 과정이 성공적으로 수행될 시, 아래 콜백이 실행됨
            @Override
            public void onComplete() {
                System.out.println("onComplete() execute Thread is " + Thread.currentThread().getName());
                System.out.println("다 끝났다.");

            }
        };

        database
                .subscribeOn(Schedulers.newThread())     // Observable will run on parameter thread. (default main)
                .observeOn(Schedulers.io())              // Observer will run on parameter thread.   (default main)
                .subscribe(observer);                    // Subscribe the observer

        Thread.sleep(100L);         // 기타 thread 인 경우 값 배출이 되기전에 프로그램이 종료되어 부득이하게 강제 타이머를 둠
    }
}
