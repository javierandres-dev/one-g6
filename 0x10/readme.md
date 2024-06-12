# 0x10 Curso de Spring Boot 3: desarrollar una API Rest en Java
## Resources
- https://spring.io/projects/spring-boot
- https://www.aluracursos.com/blog/rest-concepto-y-fundamentos
- https://www.aluracursos.com/blog/caracteristica-destacables-java8-delante
- https://www.aluracursos.com/blog/aprenda-todo-sobre-el-ide-entorno-de-desarrollo-integrado
- https://www.aluracursos.com/blog/intellij-idea-para-principiantes
- https://www.aluracursos.com/blog/aumentando-tu-productividad-con-el-eclipse
- https://www.aluracursos.com/blog/desarrollando-aplicaciones-java-code
- https://www.json.org/json-es.html
- https://docs.oracle.com/en/java/javase/16/language/records.html
- https://www.mysql.com/
- https://www.aluracursos.com/blog/mysql-desde-la-descarga-e-instalacion-hasta-su-primera-tabla
- https://12factor.net/es/
- https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints
- https://projectlombok.org/
- https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html

```

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}

delete from flyway_schema_history where success = 0;

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.data.web.pageable.page-parameter=pagina
spring.data.web.pageable.size-parameter=tamano
spring.data.web.sort.sort-parameter=orden

```
