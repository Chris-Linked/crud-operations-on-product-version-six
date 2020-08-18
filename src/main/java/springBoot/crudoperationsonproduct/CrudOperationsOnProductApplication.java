package springBoot.crudoperationsonproduct;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springBoot.crudoperationsonproduct.DTO.SlipDTO;
import springBoot.crudoperationsonproduct.DTO.SlipInfoDTO;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CrudOperationsOnProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationsOnProductApplication.class, args);

		System.out.println("good morning!!!!");
		SlipDTO slipDTO = new SlipDTO();
		List<SlipInfoDTO> list = slipDTO.getSlipInfoDTO();

		Date date = new Date();
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
