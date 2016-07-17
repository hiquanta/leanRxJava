package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * 只发射通过了谓词测试的数据项
 * https://mcxiaoke.gitbooks.io/rxdocs/content/operators/Filter.html
 * 
 * @author hiquanta
 *
 */
public class Filter {
	public static void main(String[] args) {
		Observable.just(1, 2, 3, 4, 5).filter(new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer item) {
				return item < 4;
			}
		}).subscribe(new Subscriber<Integer>() {
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
