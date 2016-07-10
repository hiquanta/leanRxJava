package hiquanta.rxjava.operators.filter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * ���ڹ���һ��ָ����ʱ�仹û��������ʱ�ŷ���һ������
 * @author hiquanta
 *
 */
public class Debounce {
	public static void main(String[] args) {
		Observable.create(new Observable.OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> t) {
				try {
                    //��������ļ��ʱ��ֱ�Ϊ100��200��300...900����
                    for (int i = 1; i < 10; i++) {
                        t.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    t.onCompleted();
                }catch(Exception e){
                    t.onError(e);
                }
			}
		}).subscribeOn(Schedulers.newThread())
		.debounce(400,TimeUnit.MILLISECONDS)
		.subscribe(  new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("Next:" + integer);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.out.println("Error:" + throwable.getMessage());
            }
        }, new Action0() {
            @Override
            public void call() {
                System.out.println("completed!");
            }
        });
		 try {
				Thread.sleep(Integer.MAX_VALUE);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}
}
