package com.tbuk.psd2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Bean
    public Docket produceApi(){
    return new Docket(DocumentationType.SWAGGER_2)
    .apiInfo(apiInfo())
    .select()
    .apis(RequestHandlerSelectors.basePackage("com.tbuk.psd2.rest"))
    .paths(paths())
    .build();
}
// Describe your apis
private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
    .title("TBUK Open Banking/PSD2 APIs")
    .description("This document lists all the rest apis for TBUK PSD2 Services")
    .version("1.0-SNAPSHOT")
    .build();
}
// Only select apis that matches the given Predicates.
private Predicate<String> paths() {
// Match all paths except /error
    return Predicates.and(
    		//PathSelectors.regex("/AccountInformation.*"),Predicates.not(PathSelectors.regex("/error.*")));
    		PathSelectors.regex("/.*"),Predicates.not(PathSelectors.regex("/error.*")));
    }
}