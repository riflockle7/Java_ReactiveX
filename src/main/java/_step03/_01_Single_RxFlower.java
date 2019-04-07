package _step03;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class _01_Single_RxFlower {
    public static void main(String[] args) {
        // 1. 기본 사용
        Single<String> single = Single.just("Hello world!");
        single.subscribe(System.out::println);

        System.out.println("====================");

        // 2. Observable -> Single : Single.fromObservable(src1)
        Observable<String> src1 = Observable.just("Hello world");
        Single.fromObservable(src1).subscribe(System.out::println);

        System.out.println("====================");

        // 2. Observable -> Single
        Observable.just("Hello world")
                .single("Hi world")
                .subscribe(System.out::println);

        System.out.println("====================");

        // 빈 Observable에서 Single 객체 생성
        Observable.empty()
                .single("Hello world")
                .subscribe(System.out::println);

        System.out.println("====================");

        // Observable -> Array
        String[] names = {"Thomas", "Tom", "Tommy"};
        Observable.fromArray(names)
                .first("TTT")
                .subscribe(System.out::println);

        System.out.println("====================");

        // take 함수를 사용해 Single 객체 생성
        Observable.just("Hello world", "Hi world")
                .take(1)
                .single("What's up world")
                .subscribe(System.out::println);

    }
}
