package hiquanta.rxjava.operators.create;

import rx.Observable;
import rx.Subscriber;

public class Empty_Never_Throw {
	
	
	public static void main(String[] args) {
		//����һ���������κ����ݵ���������ֹ��Observable
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
		//����һ������������Ҳ����ֹ��Observable
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
		//����һ��������������һ��������ֹ��Observable
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
