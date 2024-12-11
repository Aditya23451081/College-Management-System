package com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.prime;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numbers")
public class PrimeNumberController {
    @PostMapping("/validate")
    public String validatePrime(@RequestBody @PrimeNumber Integer number) {
        return number + " is a prime number!";
    }
}
