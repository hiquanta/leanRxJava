package hiquanta.rxjava.operators.aggregate;

import rx.Observable;
import rx.functions.Action1;

/**
 * 
 * @author hiquanta
 *
 */
public class Count {
		public static void main(String[] args) {
			
			 Observable.just(1, 2, 3).count().subscribe(new Action1<Integer>() {

				@Override
				public void call(Integer t) {
					System.out.println(t);
				}
			});
		}
}
