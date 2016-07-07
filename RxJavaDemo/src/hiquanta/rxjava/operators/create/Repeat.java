package hiquanta.rxjava.operators.create;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * repeat���������Ƕ�ĳһ��Observable�ظ�������ν��,��repeat()
 * ���յ�onComplete()�ᴥ���ض��ģ�Ĭ�������������һ���µ��߳���
 * http://blog.csdn.net/axuanqq/article/details/50695737
 * 
 * ��RxJava��.repeatWhen()��.retryWhen()��������˼��
 * http://www.qingpingshan.com/rjbc/java/49285.html
 * 
 * @author hiquanta
 *
 */
public class Repeat {
	public static void main(String[] args) {
		// Observable.range(1, 5).repeat(5).subscribe(new Subscriber<Integer>()
		// {
		//
		// @Override
		// public void onCompleted() {
		// System.out.println("onCompleted");
		//
		// }
		//
		// @Override
		// public void onError(Throwable e) {
		// System.out.println("onError");
		// }
		//
		// @Override
		// public void onNext(Integer t) {
		// System.out.println("onNext:"+t);
		// }
		// });
		Observable
				.range(1, 5)
				.repeatWhen(
						new Func1<Observable<? extends Void>, Observable<?>>() {
							@Override
							public Observable<?> call(
									Observable<? extends Void> observable) {
								return Observable.timer(6, TimeUnit.SECONDS);
							}
						}).subscribe(new Observer<Integer>() {
					@Override
					public void onCompleted() {
						System.out.println("onCompleted");
					}

					@Override
					public void onError(Throwable e) {
						System.out.println("onError:" + e);
					}

					@Override
					public void onNext(Integer integer) {
						System.out.println("onNext:" + integer);
					}
				});
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
