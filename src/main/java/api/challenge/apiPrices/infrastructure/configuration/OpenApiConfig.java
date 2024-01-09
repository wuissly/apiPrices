package api.challenge.apiPrices.infrastructure.configuration;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Prices API")
                        .description("Challenge - find product/price")
                        .contact(new Contact().email("wuissly.guzman@gmail.com").name("Wuissly Guzmán"))
                        .version("1.0")
                );
    }
}
