package com.main;


import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.dto.*;
import com.exception.NorecordFound;
import com.exception.SomethingWentWrong;
import com.dao.*;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		int c;
		do {
			System.out.println("1. Add Medicine");
			System.out.println("2. Update Medicine");
			System.out.println("3. Deletd Medicine");
			System.out.println("4. View Medicine data");
			System.out.println("5. Serch medicine by id");
			System.out.println("6. Find the ");
			System.out.println("0. Exit");
			
			c=sc.nextInt();
			switch(c) {
			case 1:
				Addui(sc);
				break;
			case 2:
				UpdateUi(sc);
				break;
			case 3:
				Deleted(sc);
				break;
			case 4:
			    ViewUi(sc);
			break;
			case 5:
				SerchById(sc);
				break;
			case 6:
				ExpDate();
				break;
			case 0:
				System.out.println("Thanks");
				break;
				default :
					System.out.println("Invalid selection");
			}
		}while(c!=0);
		sc.close();
			
		
	

	}

	private static void ExpDate() {
		Inter b=new ServiceImple();
		try {
			List<Medicine> c=b.View();
			
			System.out.println(c.stream().filter(d -> d.getExpdate().isBefore(LocalDate.now()))
            .collect(Collectors.toList()));
			
		} catch (NorecordFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void SerchById(Scanner sc) {
		
			System.out.println("Eneter med_id");
			String med_id=sc.next();
		Inter b=new ServiceImple();
		try {
			List<Medicine> c=b.View();
			
			System.out.println(c.stream().filter(d -> d.getId().equals(med_id))
            .collect(Collectors.toList()));
			
		} catch (NorecordFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}

	private static void ViewUi(Scanner sc) {
		Inter b=new ServiceImple();
		try {
			List<Medicine> c=b.View();
			
			c.stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName()))
            .collect(Collectors.toList()).forEach(v -> {
				System.out.println(v);
			});
			
		} catch (NorecordFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void Deleted(Scanner sc) {
		System.out.println("Enter id");
		String id=sc.next();
Inter b=new ServiceImple();
		
		try {
			b.Deletd(id);
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void UpdateUi(Scanner sc) {
		System.out.println("Enter id");
		String id=sc.next();
		System.out.println("Enter  Name");
		String Name=sc.next();
		System.out.println("Enter Company");
		String Company=sc.next();
		System.out.println("Enter price");
		double price=sc.nextDouble();
		System.out.println("Enter mfg date");
		LocalDate mfg=LocalDate.parse(sc.next());
		System.out.println("Enter exp date");
		LocalDate exp=LocalDate.parse(sc.next());
		
		Medicine a=new Medicine(id, Name, Company, price, mfg,exp);
		
		Inter b=new ServiceImple();
		
		try {
			b.Update(a);
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void Addui(Scanner sc) {
		System.out.println("Enter id");
		String id=sc.next();
		System.out.println("Enter  Name");
		String Name=sc.next();
		System.out.println("Enter Company");
		String Company=sc.next();
		System.out.println("Enter price");
		double price=sc.nextDouble();
		System.out.println("Enter mfg date");
		LocalDate mfg=LocalDate.parse(sc.next());
		System.out.println("Enter exp date");
		LocalDate exp=LocalDate.parse(sc.next());
		
		Medicine a=new Medicine(id, Name, Company, price, mfg,exp);
		
		Inter b=new ServiceImple();
		
		try {
			b.Add(a);
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
		}
		
	}

}
