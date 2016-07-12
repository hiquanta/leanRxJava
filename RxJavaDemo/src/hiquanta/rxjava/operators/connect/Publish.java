package hiquanta.rxjava.operators.connect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * ����ͨ��Observableת��Ϊ�����ӵ�Observable
 * http://blog.csdn.net/xmxkf/article/details/51692493
 * @author hiquanta
 *
 */
public class Publish {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");	
		Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS).take(5);
		//ʹ��publish����������ͨObservableת��Ϊ�����ӵ�Observable
		ConnectableObservable<Long> connectableObservable = obs.publish();
		//��һ�������߶��ģ����Ὺʼ��������
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
		//��ʼ��������
		System.out.println( "start time:" + sdf.format(new Date()));
		connectableObservable.connect();
		//�ڶ����������ӳ�2s���ģ��⽫���¶�ʧǰ��2s�ڷ��������
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
