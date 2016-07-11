package hiquanta.rxjava.operators.helper;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * 延迟一段指定的时间再发射来自Observable的发射物
 * http://www.jianshu.com/p/7e28c8216c7d
 * http://blog.chinaunix.net/uid-20771867-id-5206187.html
 * @author hiquanta
 *
 */
public class Delay {
	public static void main(String[] args) {
		Observable.just(1,2,3,4).delaySubscription(5, TimeUnit.SECONDS).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer t) {
				System.out.println(t+"");
				
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
