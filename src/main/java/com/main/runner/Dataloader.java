package com.main.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.main.entity.Citizenplan;
import com.main.repo.CitizenPlanRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class Dataloader implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Citizenplan c1 = new Citizenplan();
		c1.setCitizenName("Yash");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5600.20);

		Citizenplan c2 = new Citizenplan();
		c2.setCitizenName("Ayush");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Property reason");

		Citizenplan c3 = new Citizenplan();
		c3.setCitizenName("Ritik");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(3600.02);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");

		Citizenplan c4 = new Citizenplan();
		c4.setCitizenName("kashish");
		c4.setGender("Female");
		c4.setPlanName("Cash");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(6600.28);

		Citizenplan c5 = new Citizenplan();
		c5.setCitizenName("Ayushi");
		c5.setGender("Female");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("family reason");

		Citizenplan c6 = new Citizenplan();
		c6.setCitizenName("Ritikia");
		c6.setGender("Female");
		c6.setPlanName("Cash");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(5));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmt(4610.50);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationRsn("Salary");

//        2nd
		Citizenplan c7 = new Citizenplan();
		c7.setCitizenName("Vishwash");
		c7.setGender("Male");
		c7.setPlanName("Food");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(7600.50);

		Citizenplan c8 = new Citizenplan();
		c8.setCitizenName("Sai");
		c8.setGender("Male");
		c8.setPlanName("Food");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Cash reason");

		Citizenplan c9 = new Citizenplan();
		c9.setCitizenName("Amar");
		c9.setGender("Male");
		c9.setPlanName("Food");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(5));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmt(5700.02);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Cash");

		Citizenplan c10 = new Citizenplan();
		c10.setCitizenName("Saloni");
		c10.setGender("Female");
		c10.setPlanName("Food");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmt(6800.28);

		Citizenplan c11 = new Citizenplan();
		c11.setCitizenName("Rani");
		c11.setGender("Female");
		c11.setPlanName("Food");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("other reason");

		Citizenplan c12 = new Citizenplan();
		c12.setCitizenName("Ritikia");
		c12.setGender("Female");
		c12.setPlanName("Food");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(5));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmt(5610.50);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationRsn("Employed");

//		 3rd
		Citizenplan c13 = new Citizenplan();
		c13.setCitizenName("Karthik");
		c13.setGender("Male");
		c13.setPlanName("Medical");
		c13.setPlanStatus("Approved");
		c13.setPlanStartDate(LocalDate.now());
		c13.setPlanEndDate(LocalDate.now().plusMonths(6));
		c13.setBenefitAmt(5300.50);

		Citizenplan c14 = new Citizenplan();
		c14.setCitizenName("AmarSai");
		c14.setGender("Male");
		c14.setPlanName("Medical");
		c14.setPlanStatus("Denied");
		c14.setDenialReason("Property reason");

		Citizenplan c15 = new Citizenplan();
		c15.setCitizenName("Amrish");
		c15.setGender("Male");
		c15.setPlanName("Medical");
		c15.setPlanStatus("Terminated");
		c15.setPlanStartDate(LocalDate.now().minusMonths(2));
		c15.setPlanEndDate(LocalDate.now().plusMonths(6));
		c15.setBenefitAmt(5600.02);
		c15.setTerminatedDate(LocalDate.now());
		c15.setTerminationRsn("Money Problam");

		Citizenplan c16 = new Citizenplan();
		c16.setCitizenName("Mohini");
		c16.setGender("Female");
		c16.setPlanName("Medical");
		c16.setPlanStatus("Approved");
		c16.setPlanStartDate(LocalDate.now());
		c16.setPlanEndDate(LocalDate.now().plusMonths(6));
		c16.setBenefitAmt(5100.28);

		Citizenplan c17 = new Citizenplan();
		c17.setCitizenName("loficia");
		c17.setGender("Female");
		c17.setPlanName("Medical");
		c17.setPlanStatus("Denied");
		c17.setDenialReason("Family reason");

		Citizenplan c18 = new Citizenplan();
		c18.setCitizenName("Subhishi");
		c18.setGender("Female");
		c18.setPlanName("Medical");
		c18.setPlanStatus("Terminated");
		c18.setPlanStartDate(LocalDate.now().minusMonths(3));
		c18.setPlanEndDate(LocalDate.now().plusMonths(6));
		c18.setBenefitAmt(3610.50);
		c18.setTerminatedDate(LocalDate.now());
		c18.setTerminationRsn("Employed");


		//		 4th
		Citizenplan c19 = new Citizenplan();
		c19.setCitizenName("Aryan");
		c19.setGender("Male");
		c19.setPlanName("Employment");
		c19.setPlanStatus("Approved");
		c19.setPlanStartDate(LocalDate.now());
		c19.setPlanEndDate(LocalDate.now().plusMonths(6));
		c19.setBenefitAmt(6100.50);

		Citizenplan c20 = new Citizenplan();
		c20.setCitizenName("Monty");
		c20.setGender("Male");
		c20.setPlanName("Employment");
		c20.setPlanStatus("Denied");
		c20.setDenialReason("Broker reason");

		Citizenplan c21 = new Citizenplan();
		c21.setCitizenName("Jay");
		c21.setGender("Male");
		c21.setPlanName("Employment");
		c21.setPlanStatus("Terminated");
		c21.setPlanStartDate(LocalDate.now().minusMonths(1));
		c21.setPlanEndDate(LocalDate.now().plusMonths(6));
		c21.setBenefitAmt(1600.02);
		c21.setTerminatedDate(LocalDate.now());
		c21.setTerminationRsn("Enjoy");

		Citizenplan c22 = new Citizenplan();
		c22.setCitizenName("Aishwarya");
		c22.setGender("Female");
		c22.setPlanName("Employment");
		c22.setPlanStatus("Approved");
		c22.setPlanStartDate(LocalDate.now());
		c22.setPlanEndDate(LocalDate.now().plusMonths(6));
		c22.setBenefitAmt(7100.28);

		Citizenplan c23 = new Citizenplan();
		c23.setCitizenName("Shuchi");
		c23.setGender("Female");
		c23.setPlanName("Employment");
		c23.setPlanStatus("Denied");
		c23.setDenialReason("Employed");

		Citizenplan c24 = new Citizenplan();
		c24.setCitizenName("Sonamiya");
		c24.setGender("Female");
		c24.setPlanName("Medical");
		c24.setPlanStatus("Terminated");
		c24.setPlanStartDate(LocalDate.now().minusMonths(4));
		c24.setPlanEndDate(LocalDate.now().plusMonths(6));
		c24.setBenefitAmt(4810.50);
		c24.setTerminatedDate(LocalDate.now());
		c24.setTerminationRsn("Marriage");

	    List<Citizenplan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24 );
//		repo.saveAll(list);
	}

	
	
}
