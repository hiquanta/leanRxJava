package hiquanta.rxjava.operators.create;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
/**
 * �ο�http://blog.csdn.net/job_hesc/article/details/46242117
 * ֱ���й۲��߶���ʱ�Ŵ���Observable������Ϊÿ���۲��ߴ���һ���µ�Observable
 * @author hiquanta
 *
 */
public class Defer {

	static int i;

	public static void main(String[] args) {
		i = 10;
		Observable<Integer> justObservable = Observable.just(i);
		i = 12;
		Observable<Integer> deferObservable = Observable
				.defer(new Func0<Observable<Integer>>() {

					@Override
					public Observable<Integer> call() {
						return Observable.just(i);
					}
				});
		i=15;
		justObservable.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(Integer t) {
				 System.out.println("just result:" + t.toString());
			}
			
		} );
		deferObservable.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(Integer t) {
				 System.out.println("defer result:" + t.toString());
			}
		});
		
	}
}
