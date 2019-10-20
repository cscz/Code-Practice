public class SingletonLazy {
	private static volatile SingletonLazy st = null; 
	private SingletonLazy() {}

	public static SingletonLazy getInstance() {
		if(st == null) {
			synchronized(SingletonLazy.class) {
				if(st == null) {
					st = new SingletonLazy();
				}
			}
		}
		return st;
	}
}
