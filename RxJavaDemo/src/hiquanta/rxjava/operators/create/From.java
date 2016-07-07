package hiquanta.rxjava.operators.create;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * 将其它种类的对象和数据类型转换为Observable
 * @author hiquanta
 *
 */
public class From {
	public static void main(String[] args) {
		Integer[] items = { 0, 1, 2, 3, 4, 5 };
		Observable<Integer> myObservable = Observable.from(items);
		myObservable.subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				 System.out.println(t);
			}
		},
	    new Action1<Throwable>() {
	        @Override
	        public void call(Throwable error) {
	            System.out.println("Error encountered: " + error.getMessage());
	        }
	    },
	    new Action0() {
	        @Override
	        public void call() {
	            System.out.println("Sequence complete");
	        }
	    });
		
	}
}
