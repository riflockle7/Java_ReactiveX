package _step02;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class _03_From_RxFlower {
    public static void main(String[] args) throws InterruptedException {
        // 1. '데이터의 흐름' 을 먼저 정의
        Observable<String> databaseArray = Observable.fromArray("doc1", "doc2", "doc3");

        ArrayList<String> iterable = new ArrayList<>();
        iterable.add("doc1");
        iterable.add("doc2");
        iterable.add("doc3");
        Observable<String> databaseIterable = Observable.fromIterable(iterable);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "doc1";
            }
        };
        Observable<String> databaseCallable = Observable.fromCallable(callable);

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

//        databaseArray
//        databaseIterable
        databaseCallable
                .subscribeOn(Schedulers.newThread())     // Observable will run on parameter thread. (default main)
                .observeOn(Schedulers.io())              // Observer will run on parameter thread.   (default main)
                .subscribe(observer);                    // Subscribe the observer


        Thread.sleep(100L);         // 기타 thread 인 경우 값 배출이 되기전에 프로그램이 종료되어 부득이하게 강제 타이머를 둠
    }
}
