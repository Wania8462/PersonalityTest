package com.projects.PersonalityTest.services.database.implementations;

import com.projects.PersonalityTest.models.UserResults;
import com.projects.PersonalityTest.repositories.UserResultsRepository;
import com.projects.PersonalityTest.services.database.UserResultsService;
import com.projects.PersonalityTest.services.database.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
                userService.getById(userId),
                results.getOpenness(),
                results.getPainstakingness(),
                results.getExtroversion(),
                results.getAccommodation(),
                results.getNeuroticism()
        );

        return userResultsRepository.save(newUserResults);
    }

    @Override
    public UserResults update(UserResults results, Long userId) throws Exception {
        UserResults updatedResults = getById(userId);
        updatedResults.setOpenness(results.getOpenness());
        updatedResults.setPainstakingness(results.getPainstakingness());
        updatedResults.setExtroversion(results.getExtroversion());
        updatedResults.setAccommodation(results.getAccommodation());
        updatedResults.setNeuroticism(results.getNeuroticism());

        return userResultsRepository.save(updatedResults);
    }

    @Override
    public UserResults getById(Long userId) throws Exception{
        return userResultsRepository.findByUser(userService.getById(userId));
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