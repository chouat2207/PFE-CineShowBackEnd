package CinemaProj.controller;

import CinemaProj.entite.UserEntity;
import CinemaProj.service.serviceSecurity.SecurityConfigSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class SecurityController {

    @Autowired
    private SecurityConfigSrv securityConfig;

    @GetMapping("/")
    public String login() {
        return "loging";
    }

    @GetMapping("/getUser")
    public List<UserEntity> getUser() {
        return this.securityConfig.getUser();
    }

}