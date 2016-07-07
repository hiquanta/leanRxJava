package hiquanta.rxjava.operators.create;

import rx.Observable;
import rx.Subscriber;

/**
 * 创建一个发射特定整数序列的Observable
 * http://www.bubuko.com/infodetail-847631.html
 * @author hiquanta
 *
 */
public class Range {
	public static void main(String[] args) {
		Observable.range(3, 10).subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				 System.out.println("Sequence complete.");
				
			}

			@Override
			public void onError(Throwable e) {
				 System.out.println("Sequence complete.");
				
			}

			@Override
			public void onNext(Integer t) {
			    System.out.println("Next:" + t.toString());
				
			}
		});
	}
}
