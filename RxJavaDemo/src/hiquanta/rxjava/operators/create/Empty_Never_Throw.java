package hiquanta.rxjava.operators.create;

import rx.Observable;
import rx.Subscriber;

public class Empty_Never_Throw {
	
	
	public static void main(String[] args) {
		//创建一个不发射任何数据但是正常终止的Observable
		Observable<Integer> emptyObservable=Observable.empty();
		emptyObservable.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				System.out.println("onCompleted");
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(Integer t) {
				 System.out.println("empty result:" + t.toString());
			}
		});
		//创建一个不发射数据也不终止的Observable
		Observable<Integer> nerverObservable=Observable.never();
		nerverObservable.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				System.out.println("onCompleted");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("onError"+e);
			}

			@Override
			public void onNext(Integer t) {
				 System.out.println("empty result:" + t.toString());
			}
		});
		//创建一个不发射数据以一个错误终止的Observable
		Observable<Integer> errorObservable=Observable.error(new Throwable());
		errorObservable.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				System.out.println("onCompleted");
			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onNext(Integer t) {
				 System.out.println("empty result:" + t.toString());
			}
		});
	}
}
