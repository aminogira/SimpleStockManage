package com.aminosoft.simplestockmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aminosoft.simplestockmanage.service.MasterService;

@Controller
public class StockController {

	
	private final MasterService masterService;

	@Autowired
	public StockController(MasterService masterService) {
		super();
		this.masterService = masterService;
	}
	
	
	
	
}
