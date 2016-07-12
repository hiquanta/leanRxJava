package hiquanta.rxjava.operators.condition;

import rx.Observable;
import rx.functions.Action1;

/**
 * 判定两个Observables是否发射相同的数据序列。
 * http://blog.chinaunix.net/uid-20771867-id-5208237.htmls
 * 
 * @author hiquanta
 *
 */
public class SequenceEqual {

	public static void main(String[] args) {
		Observable.sequenceEqual(Observable.just(1, 2, 3),
				Observable.just(1, 2, 3)).subscribe(new Action1<Boolean>() {

			@Override
			public void call(Boolean t) {

			}
		});
		Observable.sequenceEqual(Observable.just(1, 2, 3),
				Observable.just(1, 2, 3)).subscribe(new Action1<Boolean>() {

			@Override
			public void call(Boolean t) {
				
			}
		});
	}
}
