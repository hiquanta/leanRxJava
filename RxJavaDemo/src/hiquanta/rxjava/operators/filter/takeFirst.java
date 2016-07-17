package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * 
 * http://www.myexception.cn/android/1949467.html
 * 
 * @author hiquanta
 *
 */
public class takeFirst {
	public static void main(String[] args) {
		Observable.just(1, 2, 3, 4, 5, 6, 7)
				.takeFirst(new Func1<Integer, Boolean>() {
					@Override
					public Boolean call(Integer integer) {
						// 获取数值大于3的数据
						return integer > 3;
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
