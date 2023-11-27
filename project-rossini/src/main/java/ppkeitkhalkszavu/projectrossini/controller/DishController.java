package ppkeitkhalkszavu.projectrossini.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ppkeitkhalkszavu.projectrossini.domain.Dish;
import ppkeitkhalkszavu.projectrossini.repository.DishRepository;

import java.util.List;

@Slf4j
@Tag(name = "Dish")
@RestController
public class DishController {

    private final DishRepository dishRepository;

    @Autowired
    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Operation(summary = "Get all dishes with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all dishes"),
            @ApiResponse(responseCode = "400", description = "Invalid url parameters supplied"),
    })
    @GetMapping("/dishes")
    public List<Dish> getDishes(@RequestParam(required = false, defaultValue = "100") Integer limit, @RequestParam(required = false, defaultValue = "desc") String sort) {
        log.info("Calling GET /dishes endpoint with limit: {} and sort: {}", limit, sort);

        if(!sort.equals("desc") && !sort.equals("asc")) {
            throw new IllegalArgumentException("Invalid sort parameter supplied");
        }

        var sortParam = sort.equalsIgnoreCase("desc") ? Sort.by("id").descending() : Sort.by("id").ascending();
        Page<Dish> dishes = dishRepository.findAll(PageRequest.of(0, limit, sortParam));

        return dishes.toList();
    }
}
