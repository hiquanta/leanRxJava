package hiquanta.rxjava.operators.aggregate;

import rx.Observable;
import rx.functions.Action1;
import rx.math.operators.OperatorMinMax;

/**
 * 
 * @author hiquanta
 *
 */
public class Max {
public static void main(String[] args) {
	Observable<Integer> obser1 = Observable.just(1, 2, 3);
	OperatorMinMax.max(obser1).subscribe(new Action1<Integer>() {

		@Override
		public void call(Integer t) {
			System.out.println(t);
		}
	});
}
	 
}
