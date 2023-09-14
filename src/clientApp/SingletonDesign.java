package clientApp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Connection implements Cloneable{
	
	private static Connection conn;
	
	private  Connection() {	
	}
	
	public static Connection getConnection() {
		if(conn == null) {
			
			synchronized(new Connection()) {
				if(conn == null) {
					conn = new Connection();
				}
			}
			
		}
		return conn;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	
	
}


public class SingletonDesign {

	public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		Thread t1 = new Thread(() -> {
			Connection conn = Connection.getConnection();
			System.out.println("Thread Name"+Thread.currentThread().getName()+" and  "+conn.hashCode());
			
		});
		
		t1.start();
		
		Thread t2 = new Thread(() -> {
			Connection conn1 = Connection.getConnection();
			System.out.println("Thread Name"+Thread.currentThread().getName()+" and  "+conn1.hashCode());
		});
		
		t2.start();
		
		
//		Connection con = Connection.getConnection();
//		System.out.println(con.hashCode());
		
//		Connection con1 = (Connection) con.clone();
//		System.out.println(con1.hashCode());
		
		Connection conn  = Connection.getConnection();
		System.out.println(conn.hashCode());
		Connection con1 = null;
		
		Constructor[] cons=Connection.class.getDeclaredConstructors();
		for(Constructor con :  cons) {
			con.setAccessible(true);
			con1 = (Connection) con.newInstance();
			break;
		}
		System.out.println(con1.hashCode());
	}

}
