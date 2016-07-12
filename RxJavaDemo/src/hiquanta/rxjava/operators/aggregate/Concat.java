package hiquanta.rxjava.operators.aggregate;

import rx.Observable;
import rx.functions.Action1;

/**
 * 
 * @author hiquanta
 *
 */
public class Concat {
	public static void main(String[] args) {
		Observable<Integer> obser1 = Observable.just(1, 2, 3);
        Observable<Integer> obser2 = Observable.just(4, 5, 6);
        Observable<Integer> obser3 = Observable.just(7, 8, 9);
        Observable.concat(obser1,obser2,obser3).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t);
			}
		});
	}
}
