package controller;

public class SingleTon {
	
		 private static SingleTon instance = new SingleTon();
		 private static KeyManager KeyManager = new KeyManager();
		 private   SingleTon() {}
		   public static SingleTon getInstance(){
			      return instance;
			   }
		public static  KeyManager getkeyManager() //return keyManager Object so other classes can access to it 
		{
			return KeyManager;
			
		}

	


}
