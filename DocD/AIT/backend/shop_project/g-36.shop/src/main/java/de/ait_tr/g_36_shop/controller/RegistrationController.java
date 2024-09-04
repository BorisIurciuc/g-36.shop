package de.ait_tr.g_36_shop.controller;

import de.ait_tr.g_36_shop.domain.entity.User;
import de.ait_tr.g_36_shop.exeption_handling.Response;
import de.ait_tr.g_36_shop.service.interfaces.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

  private final UserService service;

  public RegistrationController(UserService service) {
    this.service = service;
  }

  @PostMapping
  public Response register(@RequestBody User user) {

    service.register(user);

    return new Response("User registered successfully. Please check your email.");

  }
}
