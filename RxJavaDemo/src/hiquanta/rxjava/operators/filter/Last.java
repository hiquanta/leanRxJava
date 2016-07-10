package hiquanta.rxjava.operators.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * 只发射最后一项（或者满足某个条件的最后一项）数据
 * https://mcxiaoke.gitbooks.io/rxdocs/content/operators/Last.html
 * @author hiquanta
 *
 */
public class Last {
	public static void main(String[] args) {
		Observable.just(1, 2, 3)
        .last()
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
