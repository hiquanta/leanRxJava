package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * ֻ�����һ���������ĳ�������ĵ�һ�����
 * https://mcxiaoke.gitbooks.io/rxdocs/content/operators/First.html
 * 
 * @author hiquanta
 *
 */
public class First {
	public static void main(String[] args) {
		Observable.just(1, 2, 3).first().subscribe(new Subscriber<Integer>() {
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
