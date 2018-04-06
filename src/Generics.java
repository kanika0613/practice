import java.util.ArrayList;
import java.util.List;

class Generics {

	public static void main(String[] args) {
		Generics gen = new Generics();
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		
		/*System.out.println(list.get(0));
		
		System.out.println(list.get(0) + 5);*/
		
		B b = gen.new B();
		b.test();
		
		A a = gen.new A();
		a.test();
		
		A a1 = gen.new B();
		a1.test();
		
		
		
	}
	
	
	
	class A {
		void test () {
			System.out.println("A test");
		}
	}
	
	class B extends A {
		void test () {
			System.out.println("B test");
		}
	}

}
