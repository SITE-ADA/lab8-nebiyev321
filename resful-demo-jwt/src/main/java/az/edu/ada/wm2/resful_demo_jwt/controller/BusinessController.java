package az.edu.ada.wm2.resful_demo_jwt.controller;

import az.edu.ada.wm2.resful_demo_jwt.model.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @GetMapping("/users")
    public String getUsersHomePage(Authentication authentication) {
        return "This is home for USERS. Welcome " + (User) authentication.getPrincipal();
    }


    @GetMapping("/admins")
    public String getAdminsHomePage(Authentication authentication) {
        return "This is home for ADMINS. Welcome " + (User) authentication.getPrincipal();
    }

}
