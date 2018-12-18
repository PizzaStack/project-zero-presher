package NewUserService;

import java.util.List;

public class NewUserService implements Runnable{
	
	
		private static int nextId = 0;
		int id;
		String Name;
		String Address;
		String Phone;
		List<String> gifts;
	
//		public NewUserService createUser(String Name, String Address, String Phone, List<String> gifts) {
//			return new NewUserService(id, Address, Phone, Name, gifts);
//		}

	public void createUser(int id, String name, String address, String phone, List<String> gifts) {
			
			this.id = NewUserService.nextId;
			NewUserService.nextId++;
			Name = name;
			Address = address;
			Phone = phone;
			this.gifts = gifts;
			
		}


	//@Override
	public void run() {
		createUser(id, Name, Address, Phone, gifts);
	}


	
}
