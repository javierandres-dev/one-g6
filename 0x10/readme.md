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

```
