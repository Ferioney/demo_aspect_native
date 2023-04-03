package com.example.demo.logic;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(LogicConfiguration.DashboardPropsResourcesRegistrar.class)
public class LogicConfiguration {

    @Bean
    public HomeService homeService() {
        return new DefaultHomeService();
    }

    @Bean
    public HomeAspect homeAspect() {
        return new HomeAspect();
    }

    static class DashboardPropsResourcesRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection().registerType(
                    HomeAspect.class,
                    builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS)
            );
        }
    }
}
