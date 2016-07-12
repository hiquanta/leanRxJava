package hiquanta.rxjava.operators.connect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observables.ConnectableObservable;

/**
 * 保证所有的观察者收到相同的数据序列，即使它们在Observable开始发射数据之后才订阅
 * http://blog.csdn.net/xmxkf/article/details/51692493
 * @author hiquanta
 *
 */
public class Replay {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println( "start time:" + sdf.format(new Date()));

		//没有缓存的情况
		ConnectableObservable<Long> obs = Observable.interval(1, TimeUnit.SECONDS)
		        .take(5)
		        .publish();
		obs.connect();  //开始发射数据
		obs.delaySubscription(3, TimeUnit.SECONDS)
		        .subscribe(aLong -> System.out.println( "onNext:"+aLong+"->time:"+ sdf.format(new Date())));


		//缓存一个数据
		ConnectableObservable<Long> obs1 = Observable.interval(1, TimeUnit.SECONDS)
		        .take(5)
		        .replay(1);   //缓存1个数据
		obs1.connect();  //开始发射数据
		obs1.delaySubscription(3, TimeUnit.SECONDS)
		        .subscribe(aLong -> System.out.println(
		                "1.onNext:"+aLong+"->time:"+ sdf.format(new Date())));

		//缓存3s内发射的数据
		ConnectableObservable<Long> obs2 = Observable.interval(1, TimeUnit.SECONDS)
		        .take(5)
		        .replay(3, TimeUnit.SECONDS);   //缓存3s
		obs2.connect();  //开始发射数据
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
