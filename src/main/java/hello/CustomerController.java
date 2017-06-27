package hello;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController { // handles requests in browser

	@Resource
	private CustomerRepository repo;
	
	@RequestMapping("/customers")
	public String fetchCustomer(Model model) {
		model.addAttribute("customerAsCollection", repo.findAll());
		return "customers";
	}

	@RequestMapping(value = "/oneCustomer")
	public String oneCustomer(@RequestParam("id") Long id, Model model) {
		model.addAttribute("customers", repo.findOne(id));
		return "oneCustomer";
	}
}
