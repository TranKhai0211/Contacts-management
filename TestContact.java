package lastProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestContact {
	
	static HashMap<Integer, Contact> cus = new HashMap<Integer, Contact>();
	public static void menu() {
		System.out.println("1. Add");
		System.out.println("2. Print");
		System.out.println("3. Edit");
		System.out.println("4. Delete");
		System.out.println("5. Search");
		System.out.println("6. Sort");
		System.out.println("7. Save File");
		System.out.println("8. Read File");
		System.out.println("9. Exit");
		System.out.println("Please choose one of the above functions.");

		int choice = new Scanner(System.in).nextInt();
		switch(choice) {
		case 1:
			add();
			break;
		case 2:
			print();
			break;
		case 3:
			edit();
			break;
		case 4:
			delete();
			break;
		case 5:
			search();
			break;
		case 6:
			sort();
			System.out.println("List after sort");
			print();
			break;
		case 7:
			save();
			break;
		case 8:
			read();
			break;
		case 9:
			System.err.println("Goobye !");
			System.exit(0);
		}
	}
	private static void read() {
		String path = new Scanner(System.in).nextLine();
		cus = SerializeFileFactory.readFile(path);
	}
	private static void save() {
		String path = new Scanner(System.in).nextLine();
		SerializeFileFactory.saveFile(cus, path);
	}
	private static void sort() {
		ArrayList<Contact> c = new ArrayList<Contact>();
		for(int i : cus.keySet()) {
			c.add(cus.get(i));
		}
		Collections.sort(c);
		int i = 0;
		for(int k : cus.keySet()) {
			cus.put(k, c.get(i));
			i++;
		}
		print();
	}
	private static void search() {
		System.out.println("Nhập Phone: ");
		String phone = new Scanner(System.in).nextLine();
		for(Map.Entry<Integer, Contact> item : cus.entrySet()) {
			if(item.getValue().getPhone().startsWith(phone)) {
				System.out.println(item.getValue());
			}
		}
	}
	private static void delete() {
		System.out.println("Input ID: ");
		int id = new Scanner(System.in).nextInt();
		
		if(cus.containsKey(id)) {
			cus.remove(id);
		}
		else {
			System.out.println("there is no id in cus");
		}
		
	}
	private static void edit() {
		// TODO Auto-generated method stub
		System.out.println("Input ID: ");
		int id = new Scanner(System.in).nextInt();
		System.out.println("Input name: ");
		String name = new Scanner(System.in).nextLine();
		System.out.println("Input Phone number: ");
		String phone = new Scanner(System.in).nextLine();
		
		Contact c = new Contact(id, name, phone);
		if(cus.containsKey(c.getId()) == true) {
			cus.put(c.getId(), c);
		}
	}
	private static void print() {
		System.out.println();
		for(Map.Entry<Integer, Contact> item : cus.entrySet()) {
			System.out.println(item.toString());
		}
	}
	private static void add() {
		System.out.println("Input ID: ");
		int id = new Scanner(System.in).nextInt();
		System.out.println("Input name: ");
		String name = new Scanner(System.in).nextLine();
		System.out.println("Input Phone number: ");
		String phone = new Scanner(System.in).nextLine();
		
		Contact c = new Contact(id, name, phone);
		if(cus.containsKey(c.getId()) == false) {
			cus.put(c.getId(), c);
		}
	}
	public static void main(String[] args) {
		cus.put(1, new Contact(1, "Hung", "0941158206"));
		cus.put(2, new Contact(2,"Khai", "0825642156"));
		cus.put(3, new Contact(3, "Thao", "0942727480"));
		cus.put(4, new Contact(4, "Hai", "0324556708"));
		while(true) {menu();}
		
	}

}
