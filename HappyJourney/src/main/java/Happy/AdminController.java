package Happy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {


	@Autowired
	Dao rgDAO;
	
	@RequestMapping(value = "/CreateTrip", method = RequestMethod.GET)
	  public ModelAndView createtrip(HttpServletRequest request, HttpServletResponse response) {
		  
	    ModelAndView mav = new ModelAndView("CreateTrip");
	    BusModel b=new BusModel();
	    //List<BusModel> b=rgDAO.getBustypes();
	    ///BusListModel bl=new BusListModel();
	   // bl.setBList(b);
	    mav.addObject("Trip",b);
	    return mav;
	  }
	  
	  @ModelAttribute("b")
	  public List<BusModel> getbus(){
		  List<BusModel> b=rgDAO.getBustypes();
		  return b;
	  }
	  
	  @ModelAttribute("s")
	  public List<BusModel> getstation(){
		  List<BusModel> b=rgDAO.getstation();
		  return b;
		  
	  }
	  
}
