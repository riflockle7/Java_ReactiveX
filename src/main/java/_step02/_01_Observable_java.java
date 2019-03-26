package _step02;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class _01_Observable_java {
    public static void main(String[] args) {
        Observable observable = Observable
                .just("doc1", "doc2", "doc3")
                .flatMap(new Function<String, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(String s) throws Exception {
                        return Observable.just(s + "! " + s);
                    }
                });

        observable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println(o.toString());
            }
        });
    }
}
