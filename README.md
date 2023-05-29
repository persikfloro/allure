[![Build status](https://ci.appveyor.com/api/projects/status/govccc5lc6mxe90k?svg=true)](https://ci.appveyor.com/project/persikfloro/carddelivery)

# Домашнее задание к занятию «4.1. Репортинг»
## Задача №1: проснулись (Allure)
<details>
В одном из предыдущих проектов [Patterns](https://github.com/netology-code/aqa-homeworks/tree/master/patterns) вы тестировали функциональности заказа карт.

Ваше руководство узнало на конференции про такой замечательный инструмент, как Allure, который позволяет делать репортинг более наглядным и требует от вас интегрировать его в ваши тесты.

Начать решили именно с функции доставки карт:

![pic/order.png](https://github.com/netology-code/aqa-homeworks/raw/master/reporting/pic/order.png)

Вам нужно: взять ваш проект (см. «Как сдавать задачи») и прикрутить туда Allure, интегрированный с Selenide. Удостоверьтесь, что при локальном запуске всё работает, отчёты генерируются, скриншоты прикрепляются, и вы можете их посмотреть через Allure.
</details>

## Решение
В проект был [подключен](https://github.com/persikfloro/allure/blob/main/build.gradle) фреймворк Allure и сформирован отчёт:
![img.png](img.png)
