package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;
/**
 * 抑制（过滤掉）重复的数据项
 * http://blog.csdn.net/Job_Hesc/article/details/46495281
 * @author hiquanta
 *
 */
public class Distinct {
	public static void main(String[] args) {
		Observable.just(1, 2, 1, 1, 2, 3)
        .distinct()
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
	}
}
