package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * 抑制Observable发射的前N项数据
 * @author hiquanta
 *
 */
public class Skip {
	public static void main(String[] args) {
		Observable.just(1,2,3,4,5,6,7).skip(3)
        .subscribe(new Subscriber<Integer>() {
            @Override
            public void onNext(Integer item) {
                System.out.println("Next: " + item);
            }

            @Override
            public void onError(Throwable error) {
                System.err.println("Error: " + error.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }
        });
	}
}
