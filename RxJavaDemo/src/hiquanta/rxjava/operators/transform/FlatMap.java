package hiquanta.rxjava.operators.transform;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * FlatMap将一个发射数据的Observable变换为多个Observables，然后将它们发射的数据合并后放进一个单独的Observable
 * http://blog.csdn.net/new_abc/article/details/48025513
 * http://www.jianshu.com/p/6d16805537ef
 * @author hiquanta
 *
 */
public class FlatMap {
	public static void main(String[] args) {
		Observable.just("大","小")
			.flatMap(new Func1<String, Observable<String>>() {

				@Override
				public Observable<String> call(String t) {
					return Observable.just(t+"sb");
				}
			}).subscribe(new Action1<String>() {

				@Override
				public void call(String t) {
					System.out.println(t);
				}
			});
	}
}
