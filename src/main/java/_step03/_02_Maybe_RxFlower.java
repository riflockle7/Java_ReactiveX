package _step03;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class _02_Maybe_RxFlower {
    public static void main(String[] args) {
        // 1. 기본 사용
        //Some Emission
        Maybe<String> singleSource = Maybe.just("single item");

        singleSource.subscribe(new MaybeObserver<String>() {
                                   @Override
                                   public void onSubscribe(Disposable d) {

                                   }

                                   @Override
                                   public void onSuccess(String s) {
                                       System.out.println("Item received: from singleSource " + s);
                                   }

                                   @Override
                                   public void onError(Throwable e) {
                                       e.printStackTrace();
                                   }

                                   @Override
                                   public void onComplete() {
                                       System.out.println("Done from SingleSource");
                                   }
                               }
        );

        singleSource.subscribe(
                s -> System.out.println("Item received: from singleSource " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done from SingleSource")
        );

        //no emission
        Maybe<Integer> emptySource = Maybe.empty();

        emptySource.subscribe(
                s -> System.out.println("Item received: from emptySource" + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done from EmptySource")
        );

    }
}
