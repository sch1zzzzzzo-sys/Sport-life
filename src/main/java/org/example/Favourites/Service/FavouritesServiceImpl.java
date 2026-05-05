package org.example.Favourites.Service;

import lombok.RequiredArgsConstructor;
import org.example.Employee.Employee;
import org.example.Exercise.Exercise;
import org.example.Favourites.Exceptions.FavouritesFoundExceptions;
import org.example.Favourites.Exceptions.FavouritesNotFoundException;
import org.example.Favourites.Favourites;
import org.example.Favourites.FavouritesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavouritesServiceImpl implements FavouritesService {
    private final FavouritesRepository favouritesRepository;
    @Override
    @Transactional
    public void createFavourites(Employee employee, Exercise exercise) {
        boolean presenceFavourites =favouritesRepository.existsByEmployeeAndExercise(employee,exercise);
        if(presenceFavourites) throw new FavouritesFoundExceptions("","favourite");
        Favourites favourite=new Favourites(exercise,employee);
        favouritesRepository.save(favourite);
    }
    @Override
    @Transactional
    public void deleteFavourites(Employee employee,Exercise exercise) {
        Favourites favourite = favouritesRepository.findByEmployeeAndExercise(employee,exercise).orElseThrow(()->new FavouritesNotFoundException("","favourite"));
        favouritesRepository.delete(favourite);
    }
    @Override
    @Transactional(readOnly = true)
    public Page<Exercise> findExerciseByEmployees(Employee employee,int page,int size) {
        Pageable pageable=PageRequest.of(page,size);
        Page<Favourites> favourites = favouritesRepository.findByEmployee(employee,pageable);
        if (favourites.isEmpty()) {
            throw new FavouritesNotFoundException("","result");
        }
        return favourites.map(Favourites::getExercise);
    }

    @Override
    public Map<Exercise, Boolean> getFavouritesByExercise(List<Exercise> exercises, Employee employee) {
        List<Favourites> favourites=favouritesRepository.findFavouritesByEmployeeAndExerciseIn(exercises,employee);
        Map<Exercise,Boolean> favouritesMap=favourites.stream().collect(Collectors.toMap(f->f.getExercise(),f->true));
        return null;
    }
}
