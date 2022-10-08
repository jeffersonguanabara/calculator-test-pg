package net.jeffersonguanabara.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class DiscountFactorCalculationImplService implements DiscountFactorCalculationService {

	@Override
	public Double calculate(String clientType, Integer quantity) {
		if(quantity >= 1 && quantity < 100) {
			switch (clientType) {
				case "A":
					return 0.90;
				case "B":
					return 0.85;
				case "C":
					return 0.80;
			}
		} else if(quantity >= 100 && quantity < 1000) {
			switch (clientType) {
				case "A":
					return 0.95;
				case "B":
					return 0.90;
				case "C":
					return 0.85;
			}
		} else if (quantity >= 1000) {
			switch (clientType) {
				case "A":
					return 1.0;
				case "B":
					return 0.95;
				case "C":
					return 0.90;
			}
		}
		return null;
	}

}
