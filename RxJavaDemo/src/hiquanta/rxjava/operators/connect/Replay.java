package hiquanta.rxjava.operators.connect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observables.ConnectableObservable;

/**
 * ��֤���еĹ۲����յ���ͬ���������У���ʹ������Observable��ʼ��������֮��Ŷ���
 * http://blog.csdn.net/xmxkf/article/details/51692493
 * @author hiquanta
 *
 */
public class Replay {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println( "start time:" + sdf.format(new Date()));

		//û�л�������
		ConnectableObservable<Long> obs = Observable.interval(1, TimeUnit.SECONDS)
		        .take(5)
		        .publish();
		obs.connect();  //��ʼ��������
		obs.delaySubscription(3, TimeUnit.SECONDS)
		        .subscribe(aLong -> System.out.println( "onNext:"+aLong+"->time:"+ sdf.format(new Date())));


		//����һ������
		ConnectableObservable<Long> obs1 = Observable.interval(1, TimeUnit.SECONDS)
		        .take(5)
		        .replay(1);   //����1������
		obs1.connect();  //��ʼ��������
		obs1.delaySubscription(3, TimeUnit.SECONDS)
		        .subscribe(aLong -> System.out.println(
		                "1.onNext:"+aLong+"->time:"+ sdf.format(new Date())));

		//����3s�ڷ��������
		ConnectableObservable<Long> obs2 = Observable.interval(1, TimeUnit.SECONDS)
		        .take(5)
		        .replay(3, TimeUnit.SECONDS);   //����3s
		obs2.connect();  //��ʼ��������
		obs2.delaySubscription(3, TimeUnit.SECONDS)
		        .subscribe(aLong -> System.out.println(
		                "2.onNext:"+aLong+"->time:"+ sdf.format(new Date())));
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
