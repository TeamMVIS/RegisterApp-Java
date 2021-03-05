package edu.uark.registerapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;

import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.controllers.enums.QueryParameterNames;
import edu.uark.registerapp.commands.employees.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.EmployeeSignInCommand;
import edu.uark.registerapp.models.api.EmployeeSignIn;


@Controller
@RequestMapping(value = "/")
public class SignInRouteController extends BaseRouteController {
	@Autowired
	private ActiveEmployeeExistsQuery activeEmployeeExistsQuery;

	@Autowired
	private EmployeeSignInCommand employeeSignInCommand;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView defaultSignin(
		@RequestParam final Map<String, String> queryParameters
	) {
		//looking for if employees exist
		try {
			//search for if employees exist
			this.activeEmployeeExistsQuery.execute();
		} catch (NotFoundException e) {
			//if they don't exist, go to Employee Detail
			return new ModelAndView(REDIRECT_PREPEND.concat(ViewNames.EMPLOYEE_DETAIL.getRoute()));
		}
		//if they do exist

		
		ModelAndView mav = this.setErrorMessageFromQueryString(
			new ModelAndView(ViewNames.SIGN_IN.getViewName()), queryParameters);

		//Chandler replace "Employee_ID" with whatever variable name you call it in QueryParameterNames for this "if" statement
		//if (queryParameters.containsKey(QueryParameterNames.EMPLOYEE_ID.getValue()))
		//{
		//	mav.addObject(ViewModelNames.EMPLOYEE_ID.getValue(), queryParameters.get(QueryParameterNames.EMPLOYEE_ID.getValue()));
		//}
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(
		// TODO: Define an object that will represent the sign in request and add it as a parameter here
		EmployeeSignIn esi,
		HttpServletRequest request
	) {
		//if not correct
		try {
			//sign in
			//AKEEM this is from the EmployeeSignInCommand you made, make sure these names are right
			this.employeeSignInCommand.setSessionId(request.getSession().getId());
			this.employeeSignInCommand.setEmployeeSignIn(esi);
			this.employeeSignInCommand.execute();
		}catch (Exception e) {
			ModelAndView mav = new ModelAndView(ViewNames.SIGN_IN.getViewName());
			//add 2 objects, employee id and error message Chandler
			//mav.addObject(ViewModelNames.EMPLOYEE_ID.getValue(),esi.getEmployeeId());
			mav.addObject(ViewModelNames.ERROR_MESSAGE.getValue(), e.getMessage());

			return mav;
		}
		//if correct
		return new ModelAndView(
			REDIRECT_PREPEND.concat(
				ViewNames.MAIN_MENU.getRoute()));
	}
}
