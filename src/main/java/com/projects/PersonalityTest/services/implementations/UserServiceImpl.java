package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.repositories.UserRepository;
import com.projects.PersonalityTest.services.UserResultsService;
import com.projects.PersonalityTest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserResultsService userResultsService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserResultsService userResultsService) {
        this.userRepository = userRepository;
        this.userResultsService = userResultsService;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user, Long resultsId) throws Exception {
        User updatedUser = getById(id);
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhone(user.getPhone());

        if(resultsId != -1)
            updatedUser.setResults(userResultsService.getById(resultsId));

        return userRepository.save(updatedUser);
    }

    @Override
    public User getById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(()-> {
            return new Exception("No value present in Optional object. Type = User");
        });
    }

    @Override
    public User getByFirstname(String firstname) {
        return userRepository.findByFirstname(firstname);
    }

    @Override
    public User getByLastname(String lastname) {
        return userRepository.findByLastname(lastname);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByPhone(int phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);

        try {
            getById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}