package _step03;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;

public class _03_Completable_RxFlower {
    public static void main(String[] args) {
        Completable
                .complete()
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    protected void onStart() {
                        System.out.println("Start!");
                        super.onStart();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Complete!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                });

        Completable completable = Single.just("Hello world!").ignoreElement();
        completable.subscribe(
                () -> System.out.println("Complete!"),
                Throwable::printStackTrace
        );
    }
}
