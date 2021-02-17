package app.gira.service;

import app.gira.domain.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByEmailAndPassword(String email, String password);
}
