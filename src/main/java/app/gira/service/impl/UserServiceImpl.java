package app.gira.service.impl;

import app.gira.domain.entities.User;
import app.gira.domain.models.service.UserServiceModel;
import app.gira.repository.UserRepository;
import app.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
         return modelMapper.map(userRepository.save(
                modelMapper.map(userServiceModel, User.class)
        ), UserServiceModel.class);
    }
}
