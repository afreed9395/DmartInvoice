package com.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// we have to import this package to make this class as controller
//controller-it is responsible for handling incoming requests
@Controller
public class Mycontroller {

	@RequestMapping("/")
	public String home() {
		return "bill";
	}
		@RequestMapping("/req1")
		public String home1(@RequestParam int id,@RequestParam String name, @RequestParam String Mblnumb,@RequestParam String pname,@RequestParam double price,@RequestParam int qty,ModelMap m) {
			m.put("k1",id);
			m.put("k2",name);
			m.put("k3",Mblnumb);
			m.put("k4",pname);
			m.put("k5",price);
			m.put("k6",qty);
			double Total=price*qty;
			m.put("k7",Total);
			double Discount;
			if(Total<2000) {
			Discount=Total*0.1;
			}
			else if(Total>2000&Total<5000) {
			 Discount=Total*0.15;
			}
			else
			{
				Discount=Total*0.25;
			}
			m.put("k8",Discount);
			double Gst=(Total-Discount)*0.18;
			m.put("k9",Gst);
			double invoice=Total-Discount+Gst;
			m.put("k10",invoice);
			return "result";
		}
	
}
