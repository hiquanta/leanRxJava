package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * 只发射前面的N项数据
 * https://mcxiaoke.gitbooks.io/rxdocs/content/operators/Take.html
 * @author hiquanta
 *
 */
public class take {
public static void main(String[] args) {
	Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
    .take(4)
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
