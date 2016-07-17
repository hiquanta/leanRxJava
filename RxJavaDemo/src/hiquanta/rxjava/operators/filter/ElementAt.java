package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * 只发射通过了谓词测试的数据项
 * 
 * @author hiquanta
 *
 */
public class ElementAt {
	public static void main(String[] args) {
		Observable.just(1, 2, 3, 4, 5, 6).elementAt(2)
				.subscribe(new Action1<Integer>() {
					@Override
					public void call(Integer integer) {
						System.out.println("Next:" + integer);
					}
				}, new Action1<Throwable>() {
					@Override
					public void call(Throwable throwable) {
						System.out.println("Error:" + throwable.getMessage());
					}
				}, new Action0() {
					@Override
					public void call() {
						System.out.println("completed!");
					}
				});
	}
}
