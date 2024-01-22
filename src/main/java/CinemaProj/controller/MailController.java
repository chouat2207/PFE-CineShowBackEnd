package CinemaProj.controller;

import CinemaProj.entite.MailEntity;
import CinemaProj.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mail")
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/contact-us")
    public void sendContactUsEmail(@RequestBody MailEntity mail) {
        mailService.sendMail(mail);
    }

}