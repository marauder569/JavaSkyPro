package pro.sky.JavaSkyPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@RestController
	public class CalculatorController {

		@GetMapping("/calculator")
		public String welcome() {
			return "Добро пожаловать в калькулятор";
		}

		@GetMapping("/calculator/plus")
		public String add(@RequestParam int num1, @RequestParam int num2) {
			return num1 + " + " + num2 + " = " + (num1 + num2);
		}

		@GetMapping("/calculator/minus")
		public String subtract(@RequestParam int num1, @RequestParam int num2) {
			return num1 + " - " + num2 + " = " + (num1 - num2);
		}

		@GetMapping("/calculator/multiply")
		public String multiply(@RequestParam int num1, @RequestParam int num2) {
			return num1 + " * " + num2 + " = " + (num1 * num2);
		}

		@GetMapping("/calculator/divide")
		public String divide(@RequestParam int num1, @RequestParam int num2) {
			if (num2 == 0) {
				return "Ошибка: Деление на ноль недопустимо";
			} else {
				return num1 + " / " + num2 + " = " + (num1 / num2);
			}
		}
	}
}