package hiquanta.rxjava.operators.connect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * 将普通的Observable转换为可连接的Observable
 * http://blog.csdn.net/xmxkf/article/details/51692493
 * @author hiquanta
 *
 */
public class Publish {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");	
		Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS).take(5);
		//使用publish操作符将普通Observable转换为可连接的Observable
		ConnectableObservable<Long> connectableObservable = obs.publish();
		//第一个订阅者订阅，不会开始发射数据
		connectableObservable.subscribe(new Subscriber<Long>() {
		    @Override
		    public void onCompleted() {
		       System.out.println("onCompleted");
		    }
		    @Override
		    public void onError(Throwable e) {
		       System.out.println("Throwable");
		    }
		    @Override
		    public void onNext(Long along) {
		    	System.out.println( "1.onNext:"+along+"->time:"+ sdf.format(new Date()));
		    }
		});
		//开始发射数据
		System.out.println( "start time:" + sdf.format(new Date()));
		connectableObservable.connect();
		//第二个订阅者延迟2s订阅，这将导致丢失前面2s内发射的数据
		connectableObservable
		        .delaySubscription(2, TimeUnit.SECONDS)
		        .subscribe(new Subscriber<Long>() {
		    @Override
		    public void onCompleted() {
		    	System.out.println("2.onCompleted");
		    }
		    @Override
		    public void onError(Throwable e) {
		    	System.out.println( "2.onError");
		    }
		    @Override
		    public void onNext(Long along) {
		    	System.out.println( "2.onNext:"+along+"->time:"+ sdf.format(new Date()));
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
