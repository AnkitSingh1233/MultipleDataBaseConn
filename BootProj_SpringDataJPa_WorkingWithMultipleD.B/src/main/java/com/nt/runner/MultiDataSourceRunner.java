package com.nt.runner;


import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;

import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promotions.IOffersRepo;

@Component
public class MultiDataSourceRunner implements CommandLineRunner {

	@Autowired
	private IProductRepo prodRepo;
	
	@Autowired
	private  IOffersRepo offersRepo;
	
	public void run(String... args) throws Exception {

		 prodRepo.saveAll(Arrays.asList(new Product("table",10.0,12000.23),new Product("sofa",10.0,12000.23)));

		 System.out.println("Product are Saved");
		 
		 System.out.println("=======================");
		 
		 
		 offersRepo.saveAll(Arrays.asList(new Offers("Buy-1-Get-1","BIG1",100.0,LocalDateTime.of(2022,12,12,12,15)),
				 new Offers("Buy-1-Get-2","BIG2",1120.0,LocalDateTime.of(2022,10,12,12,10))
				 ));

		 
		 System.out.println("Offer Are Saved");
		 System.out.println("==================");
		 
		 System.out.println("=============Display All Product================");
		 prodRepo.findAll().forEach(System.out::println);
		 System.out.println("---------------------");
		 
		 System.out.println("========Display record Offer============");
		 offersRepo.findAll().forEach(System.out::println);
		 
		 
		 
		 
		 
		 
	}

}
