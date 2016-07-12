package hiquanta.rxjava.operators.connect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * 让一个可连接的Observable行为像普通的Observable
 * @author hiquanta
 *
 */
public class RefCount {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS).take(4);
		//使用publish操作符将普通Observable转换为可连接的Observable
		ConnectableObservable<Long> connectableObservable = obs.publish();
		//refCount：将ConnectableObservable转化为普通Observable
		Observable obsRefCount = connectableObservable.refCount();

		obs.subscribe(new Subscriber<Long>() {
		    @Override
		    public void onCompleted() {
		    	System.out.println( "普通obs1：onCompleted");
		    }
		    @Override
		    public void onError(Throwable e) {
		    	System.out.println( "普通obs1：onError");
		    }
		    @Override
		    public void onNext(Long along) {
		    	System.out.println( "普通obs1：onNext:"+along+"->time:"+ sdf.format(new Date()));
		    }
		});
		obs.delaySubscription(3, TimeUnit.SECONDS)
		        .subscribe(new Subscriber<Long>() {
		    @Override
		    public void onCompleted() {
		    	System.out.println( "普通obs2：onCompleted");
		    }
		    @Override
		    public void onError(Throwable e) {
		    	System.out.println( "普通obs2：onError");
		    }
		    @Override
		    public void onNext(Long along) {
		    	System.out.println( "普通obs2：onNext:"+along+"->time:"+ sdf.format(new Date()));
		    }
		});

		obsRefCount.subscribe(new Subscriber<Long>() {
		    @Override
		    public void onCompleted() {
		    	System.out.println( "obsRefCount1：onCompleted");
		    }
		    @Override
		    public void onError(Throwable e) {
		    	System.out.println( "obsRefCount1：onError");
		    }
		    @Override
		    public void onNext(Long along) {
		    	System.out.println( "obsRefCount1：onNext:"+along+"->time:"+ sdf.format(new Date()));
		    }
		});
		obsRefCount.delaySubscription(3, TimeUnit.SECONDS)
		        .subscribe(new Subscriber<Long>() {
		            @Override
		            public void onCompleted() {
		            	System.out.println( "obsRefCount2：onCompleted");
		            }
		            @Override
		            public void onError(Throwable e) {
		            	System.out.println( "obsRefCount2：onError");
		            }
		            @Override
		            public void onNext(Long along) {
		            	System.out.println( "obsRefCount2：onNext:"+along+"->time:"+ sdf.format(new Date()));
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
