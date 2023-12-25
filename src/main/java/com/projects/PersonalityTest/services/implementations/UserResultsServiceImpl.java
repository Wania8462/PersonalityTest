package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.dto.UserResultsDTO;
import com.projects.PersonalityTest.exception.UserResultsNotFoundException;
import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.UserResults;
import com.projects.PersonalityTest.repositories.UserResultsRepository;
import com.projects.PersonalityTest.services.UserResultsService;
import com.projects.PersonalityTest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserResultsServiceImpl implements UserResultsService {

    private final UserResultsRepository userResultsRepository;
    private final UserService userService;

    @Override
    public UserResults save(UserResults results) {
        return userResultsRepository.save(results);
    }

    public UserResults create(UserResultsDTO resultsDTO) {
        UserResults userResults = UserResults.builder()
                .openness(resultsDTO.getOpenness())
                .painstakingness(resultsDTO.getPainstakingness())
                .extroversion(resultsDTO.getExtroversion())
                .accommodation(resultsDTO.getAccommodation())
                .neuroticism(resultsDTO.getNeuroticism())
                .build();

        return userResultsRepository.save(userResults);
    }

    @Override
    public UserResults update(UserResultsDTO resultsDTO, Long id) {
        UserResults userResults = UserResults.builder()
                .id(id)
                .openness(resultsDTO.getOpenness())
                .painstakingness(resultsDTO.getPainstakingness())
                .extroversion(resultsDTO.getExtroversion())
                .accommodation(resultsDTO.getAccommodation())
                .neuroticism(resultsDTO.getNeuroticism())
                .build();

        return userResultsRepository.save(userResults);
    }

    @Override
    public UserResults getById(Long userId) {
        return userResultsRepository.findByUser(userService.getById(userId)).orElseThrow(
                () -> new UserResultsNotFoundException("User results mot found by id: " + userId)
        );
    }

    @Override
    public List<UserResults> getAll() {
        return userResultsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userResultsRepository.deleteById(id);
    }
}