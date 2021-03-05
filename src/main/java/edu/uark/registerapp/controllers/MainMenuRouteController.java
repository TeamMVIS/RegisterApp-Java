package edu.uark.registerapp.controllers;


import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

@Controller
@RequestMapping(value = "/mainMenu")
public class MainMenuRouteController extends BaseRouteController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(@RequestParam final Map<String, String> queryParameters, final HttpServletRequest serverRequest) {

        final Optional<ActiveUserEntity> activeUserEntity = this.getCurrentUser(serverRequest);
        //Returns the user to the sign in
        if(activeUserEntity.isPresent() == false)
            return this.buildInvalidSessionResponse();

        ModelAndView modelandview = this.setErrorMessageFromQueryString(new ModelAndView(ViewNames.MAIN_MENU.getViewName()), queryParameters);

        modelandview.addObject(ViewModelNames.IS_ELEVATED_USER.getValue(), this.isElevatedUser(activeUserEntity.get()));

        return modelandview;
    }

}
