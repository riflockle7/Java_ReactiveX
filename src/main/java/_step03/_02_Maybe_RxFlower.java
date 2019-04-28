package _step03;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class _02_Maybe_RxFlower {
    public static void main(String[] args) {
        //Some Emission
        Maybe<String> singleSource = Maybe.just("single item");

        // example1
        singleSource.subscribe(new MaybeObserver<String>() {
                                   @Override
                                   public void onSubscribe(Disposable d) {

                                   }

                                   @Override
                                   public void onSuccess(String s) {
                                       System.out.println("Item received: from singleSource : (" + s + ")");
                                   }

                                   @Override
                                   public void onError(Throwable e) {
                                       e.printStackTrace();
                                   }

                                   @Override
                                   public void onComplete() {
                                       System.out.println("Done from SingleSource, No items.");
                                   }
                               }
        );

        // example2
        // 위 예제와 똑같이 동작한다.
        singleSource.subscribe(
                s -> System.out.println("Item received: from singleSource : (" + s + ")"),
                Throwable::printStackTrace,
                () -> System.out.println("Done from SingleSource, No items.")
        );

        // No Emission
        // example
        Maybe<Integer> emptySource = Maybe.empty();

        emptySource.subscribe(
                s -> System.out.println("Item received: from emptySource" + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done from EmptySource, No items.")
        );
    }
}
