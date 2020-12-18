# Spring Boot example

## Сборка приложения 
```shell script
# запустить PostgreSQL в docker-контейнере
docker-compose up -d postgres

# загружает gradle wrapper 6.7
./gradlew wrapper

# сборка проекта, прогон unit-тестов, запуск приложения
./gradlew clean build bootRun
```

## Этапы демонстрации
1. Пустое веб-приложение. Ветка master.
1. Простейший CRUD-контроллер, данные хранятся в памяти.
1. Подключается OpenAPI и Spring Boot Actuator.
1. Подключается Spring Security basic-авторизация для всех методов.
1. Подключаем БД, данные пишутся в БД.