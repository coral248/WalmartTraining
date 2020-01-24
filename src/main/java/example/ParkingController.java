package example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class ParkingController {

	private final ParkingService service;
	
	public ParkingController(ParkingService service) {
		this.service = service;
	}

	@PostMapping("/parking")
	public long enterParking() {
		return service.enterParking();
	}

	@GetMapping("/parking/{code}/amount")
	public double calcPayment(@PathVariable long code) {
		return service.clacPayment(code);
	}

}