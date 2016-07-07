package hiquanta.rxjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class flatMapTest {
	public static void main(String[] args) {
		Students[] sudents = new Students[100];
		for (int i = 0; i < 100; i++) {
			Students sutent = new Students();
			sutent.setName("sb" + i);
			List<Courses> list=new ArrayList<>();
			for(int j=0;j<10;j++){
				Courses courses=new Courses();
				courses.setName(sutent.getName()+"+:"+j);
				list.add(courses);
			}
			sutent.setCoures(list);
			sudents[i] = sutent;
		}
		Subscriber<Courses> subscriber = new Subscriber<Courses>() {

			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(Courses t) {
					System.out.println(t.getName());
			}
		};
		Observable.from(sudents).flatMap(new Func1<Students, Observable<Courses>>() {

			@Override
			public Observable<Courses> call(Students t) {
				// TODO Auto-generated method stub
				return Observable.from(t.getCoures());
			}
		}).subscribe(subscriber);
	
	}
}
