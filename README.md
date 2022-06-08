# EasyTresh
## Описание проекта
EasyTresh - мобильное приложение, которое позволяет клиентам заказать вынос мусора. Приложение может работать как в режиме для заказчика, так и в режиме для работника.
### Режим заказчика
Для работы в режиме заказчика, клиенту требуется войти в систему при помощи номера телефона и пароля, если пользователь еще не зарегестрирован, то следует зарегестрироваться. 
В режиме заказчика, приложение предоставляет слдедующие возможности:
- Просмотр профиля пользователя
- Просмотр истории заказов, с информацие о тех заказах которые еще находятся в работе
- Возможность оформить заказ
    - При оформлении заказа, пользователь может выбрать сохраненныый адрес доставки
    - Также пользователь может создать новый адрес доставки, которой в последствии будет сохранен
### Режим работника
Для работы в режиме работника, клиенту требуется выполнить такие же требования как и в случае с режимом заказчика, тольок в пункте работник.
Возможности приложения в режиме работника:
- Просмотр профиля
- Просмотр истории заказов
- Просмотр списка актуальных заказов
    - Просмотр подробной информации об актуальном заказе
    - Возможность взять заказ в работу
- Просмотр списка заказов взятых в работу
    - Просмотр подробной информации о заказе
    - Возможность завершить выполнение заказа
## Использованные технологии
### Языки программирования
![Kotlin](https://img.shields.io/badge/-Kotlin-0E2336?style=for-the-badge&logo=Kotlin)
![Java](https://img.shields.io/badge/-Java-0E2336?style=for-the-badge&logo=Java)
### Библиотеки и зависимости
#### Android
![RxJava](https://img.shields.io/static/v1?style=plastic&logo=reactivex&label=RxJava&message=version:2.2.21&color=blue)
![Dagger2](https://img.shields.io/static/v1?style=plastic&label=Dagger2&message=version:2.41&color=blue)
![Retrofit](https://img.shields.io/static/v1?style=plastic&label=Retrofit&message=version:2.9.0&color=blue)
![Room](https://img.shields.io/static/v1?style=plastic&label=Room&message=version:2.4.2&color=blue)
#### Server
![SpringBoot](https://img.shields.io/static/v1?style=plastic&logo=springboot&label=Spring+Boot&message=version:2.7.0&color=blue)
![MySQL](https://img.shields.io/static/v1?style=plastic&logo=mysql&label=MySQL&message=version:8.0.29&color=blue)
### Архетектура
![MVVM](https://img.shields.io/static/v1?style=plastic&label=MVVM&message=Model+View+ViewModel+|+Clean+Architecture&color=blue)
