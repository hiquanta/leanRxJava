package hiquanta.rxjava.operators.condition;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * ��������ԭʼObservable��ֵ�����ԭʼObservableû�з����κ�ֵ���ͷ���һ��Ĭ��ֵ
 * 
 * @author hiquanta
 *
 */
public class DefaultIfEmpty {
	public static void main(String[] args) {
		Observable.create(new Observable.OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> t) {
				t.onCompleted();
				
			}
		}).defaultIfEmpty(10).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
					System.out.println(t);
			}
		
		});
	}

}
