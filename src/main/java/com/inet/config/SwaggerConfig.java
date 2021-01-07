package com.inet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
/**
 * SwaggerConfig
 *
 * @author HCY
 * @since 2020/10/27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("Token")
                .description("认证token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build());
        return new Docket(DocumentationType.SWAGGER_2)
                //开启个人信息
                .apiInfo(apiInfo())
                .globalOperationParameters(parameters)
                .select()
                .build();
                //每一个请求都可以添加header
//                .globalRequestParameters(globalRequestParameters());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api文本
                .title("小土狗 api")
                //说明
                .description("更多请咨询小土狗")
                //用户名 + 网址 + 邮箱
                .contact(new Contact("小土狗" ,
                        "https://github.com/woshixiaotugou" ,
                        "2374082336@qq.com"))
                //版本
                .version("1.0")
                //运行
                .build();
    }
//    private List<RequestParameter> globalRequestParameters() {
//        RequestParameterBuilder parameterBuilder = new RequestParameterBuilder()
//                //每次请求加载header
//                .in(ParameterType.HEADER)
//                //头标签
//                .name("Token")
//                .required(false)
//                .query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));
//        return Collections.singletonList(parameterBuilder.build());
//    }
}
