# ДЗ #5: Мобильное тестирование
___

&nbsp;
### Настройка окружения: 
Для запуска тестов из командной строки необходимо:
1. Установить Java, желательно не ниже 11 версии
2. Установить Maven, если он у вас еще не установлен, это странно, вот инструкция https://maven.apache.org/install.html

&nbsp;
### Запуск тестов:
По-умолчанию запуск настроен запуск тестов на удаленное машине/в докер-контейнере в 3 потока
* `mvn clean test` - запустить все тесты
* `mvn clean test -Ddriver.remote.url=url` - запустить все тесты на удаленном appium с указанным url
* `mvn clean test -Dapk.remote=false` - апк для тестов будет взят из файла
* `mvn clean test -Dapk.link=link` - апк для тестов будет скачан по указанной ссылке
* `mvn clean test -Dthread.count=X` - запустить все тесты в X потоков
* `mvn clean test -Ddevice.name=device.name` - запустить тесты на device.name
* `mvn clean test -Dplatform.version=version` - запуск тестов на конкретной версии андроида
* `mvn clean test -Dtest=TestClassName` - запуск конкретного тестового класса
* `mvn clean test -Dtest=TestClassName#testName` - запуск конкретного теста