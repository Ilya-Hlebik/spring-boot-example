1. Создать контроллер для регистрации и авторизации пользователя.
Всё делаем в памяти. Должен быть мапинг для регистрации и мапинг для авторизации.
2. Сделать калькулятор.
Калькулятор доступен только для авторизованных пользователей.
Нужен отдельный мапинг для каждой операции.
Операции которые требуется:
+ - * /
Флоу:
Мапинг вызывавется через сваггер.
В самом контроллере вызывается нужный сервис.
Сервис возвращает результат операции и сохраняет лог операции(Историю операций) через сервис операций.
Сервис операций оперирует сущностью Операция и сохраняет операцию для каждого действия.
Нужен отдельный контроллер для операций. Операции должны выводится только для конкретного сервиса.