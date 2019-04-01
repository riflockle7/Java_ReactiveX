package _step01;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class _02_Hello_RxJava {
    public static void main(String[] args) {
        // 1. '데이터의 흐름' 을 먼저 정의
        Observable<String> database = Observable.just("doc1", "doc2", "doc3");

        // 2. 구독
        database.subscribe(new Consumer<String>() {
            @Override
            public void accept(String justString) throws Exception {
                System.out.println(justString);
            }
        });
    }
}
