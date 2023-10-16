package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.UserResults;
import com.projects.PersonalityTest.repositories.UserResultsRepository;
import com.projects.PersonalityTest.services.UserResultsService;
import com.projects.PersonalityTest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserResultsServiceImpl implements UserResultsService {

    private final UserResultsRepository userResultsRepository;
    private final UserService userService;

    @Autowired
    public UserResultsServiceImpl(UserResultsRepository userResultsRepository, UserService userService) {
        this.userResultsRepository = userResultsRepository;
        this.userService = userService;
    }

    @Override
    public UserResults save(UserResults results, Long userId) throws Exception {
        UserResults newUserResults = new UserResults(
                results.getOpenness(),
                results.getPainstakingness(),
                results.getExtroversion(),
                results.getAccommodation(),
                results.getNeuroticism(),
                userService.getById(userId)
        );

        return userResultsRepository.save(newUserResults);
    }

    @Override
    public UserResults update(UserResults results, User user) throws Exception {
        UserResults updatedResults = getById(results.getId());
        updatedResults.setOpenness(results.getOpenness());
        updatedResults.setPainstakingness(results.getPainstakingness());
        updatedResults.setExtroversion(results.getExtroversion());
        updatedResults.setAccommodation(results.getAccommodation());
        updatedResults.setNeuroticism(results.getNeuroticism());
        updatedResults.setUser(results.getUser());

        return userResultsRepository.save(updatedResults);
    }

    @Override
    public UserResults getById(Long id) throws Exception {
        return userResultsRepository.findById(id).orElseThrow(()-> {
            return new Exception("No value present in Optional object. Type = UserResults");
        });
    }

    @Override
    public UserResults getByUser(User user) {
        return userResultsRepository.findByUser(user);
    }

    @Override
    public List<UserResults> getAll() {
        return userResultsRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        userResultsRepository.deleteById(id);

        try {
            getById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}