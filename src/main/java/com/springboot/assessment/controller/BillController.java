package com.springboot.assessment.controller;

import com.springboot.assessment.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springboot.assessment.models.Bill;

import java.util.List;


/**
 * @author Naresh Kumar
 * <p>
 * To get API request from browser,
 * only deals with fetching the request and returning result
 */
@RestController
@RequestMapping("/api/v1")
public class BillController {
    //Built in component to point to BillController
    @Autowired
    private com.springboot.assessment.service.BillService billController;

    //Get the request in a Bill format, and pass it to Controller
    @PostMapping("/getBill")
    public Bill createBill(@RequestBody Bill bill) {
        return billController.calculateBill(bill);
    }

    @PostMapping("/CreatePersonData")
    public List<Person> createPersonData() {
        return billController.generatePersons();
    }

    @PostMapping("/getDiscount")
    public double getDiscountData(@RequestBody Bill bill) {
		List<Person> people = billController.generatePersons();
		return billController.getDiscount(bill,people);
    }

	@PostMapping("/getTotalBill")
	public double getTotalBill(@RequestBody Bill bill) {
		return billController.getTotal(bill);
	}

	@PostMapping("/getDiscountableTotal")
	public double getDiscountableTotal(@RequestBody Bill bill) {
		return billController.getDiscountableTotal(bill);
	}

}
