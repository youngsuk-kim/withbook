package com.youngsuk.justbook.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("withbook")
        .build();
  }
  
  @Bean
  public Docket commonApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("youngsuk")
        .apiInfo(this.apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.youngsuk.justbook"))
        .paths(PathSelectors.ant("/api/**"))
        .build();
  }
}
