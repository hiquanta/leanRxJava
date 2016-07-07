package hiquanta.rxjava.operators.create;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * 创建一个Observable，它在一个给定的延迟后发射一个特殊的值。
 * http://blog.csdn.net/lihenair/article/details/50386442
 * @author hiquanta
 *
 */
public class Timer {
	public static void main(String[] args) {
		Observable.timer(4, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                System.out.println(aLong+"");
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
