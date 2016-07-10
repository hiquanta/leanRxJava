package hiquanta.rxjava.operators.filter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * 定期发射Observable最近发射的数据项
 * http://www.myexception.cn/android/1949467.html
 * @author hiquanta
 *
 */
public class Sample {
	public static void main(String[] args) {
		Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(subscriber.isUnsubscribed()) return;
                try {
                    //前8个数字产生的时间间隔为1秒，后一个间隔为3秒
                    for (int i = 1; i < 9; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(1000);
                    }
                    Thread.sleep(2000);
                    subscriber.onNext(9);
                    subscriber.onCompleted();
                } catch(Exception e){
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.newThread())
          .sample(2200, TimeUnit.MILLISECONDS)  //采样间隔时间为2200毫秒
          .subscribe(new Subscriber<Integer>() {
              @Override
              public void onNext(Integer item) {
                  System.out.println("Next: " + item);
              }

              @Override
              public void onError(Throwable error) {
                  System.err.println("Error: " + error.getMessage());
              }

              @Override
              public void onCompleted() {
                  System.out.println("Sequence complete.");
              }
          });
		 try {
				Thread.sleep(Integer.MAX_VALUE);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}
}
