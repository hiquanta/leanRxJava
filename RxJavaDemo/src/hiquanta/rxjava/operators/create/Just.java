package hiquanta.rxjava.operators.create;

import rx.Observable;
import rx.Subscriber;
/**
 * 创建一个发射指定值的Observable
 * @author hiquanta
 *
 */
public class Just {
public static void main(String[] args) {
	Observable.just(1, 2, 3)
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
