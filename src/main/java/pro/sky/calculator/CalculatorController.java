package pro.sky.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalcService calcService;

    @Autowired
    public CalculatorController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public ResponseEntity<String> add(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Для сложения необходимы оба числа.");
        }
        double result = calcService.add(num1, num2);
        return ResponseEntity.ok(num1 + " + " + num2 + " = " + result);
    }

    @GetMapping("/minus")
    public ResponseEntity<String> subtract(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Для вычитания необходимы оба числа.");
        }
        double result = calcService.subtract(num1, num2);
        return ResponseEntity.ok(num1 + " - " + num2 + " = " + result);
    }

    @GetMapping("/multiply")
    public ResponseEntity<String> multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Для умножения необходимы оба числа.");
        }
        double result = calcService.multiply(num1, num2);
        return ResponseEntity.ok(num1 + " * " + num2 + " = " + result);
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return ResponseEntity.badRequest().body("Для деления необходимы оба числа.");
        }
        if (num2 == 0) {
            return ResponseEntity.badRequest().body("Деление на 0 невозможно.");
        }
        double result = calcService.divide(num1, num2);
        return ResponseEntity.ok(num1 + " / " + num2 + " = " + result);
    }
}

