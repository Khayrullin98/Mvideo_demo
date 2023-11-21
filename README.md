<p align="center">
<a href="https://mvideo.ru/"><img width=40%" src="testartifacts/mvideo.png"> </a></h1>
<p align="center">

# <p align="center"> Проект по автоматизации тестовых сценариев для  Мвидео <p align="center">

## 🧾 Содержание:

- [Использованный стек технологий](#технологии)
- [Тестовые сценарии](#тестовые-сценарии)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Параметры сборки в Jenkins](#параметры-сборки-в-jenkins)
- [Интеграция с Allure Report](#allure-report)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомление в Telegram о результатах выполнения автоматизированных тестов](#уведомление-в-telegram-о-результатах-выполнения-автоматизированных-тестов)
- [Видеопример прохождения тестов Selenoid](#видеопример-прохождения-тестов-selenoid)

<a id="технологии"></a>

## 🔨 Использованный стек технологий:
<p align="center">
<a href="#"><img width="6%" title="IntelliJ IDEA" src="logo/Intelij_IDEA.svg"></a>
<a href="#"><img width="6%" title="Java" src="logo/Java.svg"></a>
<a href="#"><img width="6%" title="Selenide" src="logo/Selenide.svg"></a>
<a href="#"><img width="6%" title="Selenoid" src="logo/Selenoid.svg"></a>
<a href="#"><img width="6%" title="Allure Report" src="logo/Allure_Report.svg"></a>
<a href="#"><img width="5%" title="Allure TestOps" src="logo/AllureTestOps.svg"></a>
<a href="#"><img width="6%" title="Gradle" src="logo/Gradle.svg"></a>
<a href="#"><img width="6%" title="JUnit5" src="logo/JUnit5.svg"></a>
<a href="#"><img width="6%" title="GitHub" src="logo/GitHub.svg"></a>
<a href="#"><img width="6%" title="Jenkins" src="logo/Jenkins.svg"></a>
<a href="#"><img width="5%" title="Jira" src="logo/Jira.svg"></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования  <code>Selenide.</code>
- Для сборки проекта в среде IntelliJ IDEA используется <code>Gradle.</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
- <code>Selenoid</code>используется для запуска браузеров в контейнерах Docker.
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure-отчета</code> и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps </code> и <code>Jira</code>.

<a id="тестовые-сценарии"></a>
## :clipboard: Тестовые сценарии
+ :white_check_mark: Открытие главной страницы
+ :white_check_mark: Переход в разделы из каталога на главной
+ :white_check_mark: Поиск товара на сайте
+ :white_check_mark: Добавление товара в корзину

<a id="сборка-в-jenkins"></a>
## <img alt="Jenkins" height="30" src="/logo/Jenkins.svg" width="30"/>  Сборка в Jenkins

Для запуска сборки необходимо перейти на страницу [проекта Мвидео](https://jenkins.autotests.cloud/job/Khayrullin98_Mvideo_demo/)
в <code>Jenkins</code>, далее в раздел "Собрать с параметрами" (<code>Build with Parameters</code>), выбрать необходимые параметры и нажать
кнопку "Собрать" (<code>Build</code>).
<p>
<img width="100%" title="Jenkins" src="testartifacts/jenkins_dashboard.png">
</p>

<a id="параметры-сборки-в-jenkins"></a>
## Параметры сборки
<p>
<img width="100%" title="Jenkins" src="testartifacts/jenkins_build.png">
</p>

| Параметры          | Значение                                         |
|:-------------------|:-------------------------------------------------|
| BROWSER            | Браузер для запуска тестов (по умолчанию chrome) |
| BROWSER_VERSION    | Версия браузера       (по умолчанию 100.0)       |
| BROWSER_SIZE       | Размер окна браузера  (по умолчанию 1920x1080)   |
| SELENOID_USER      | Пользователь и пароль (по умолчанию user1:1234)  |
| SELENOID_WDHOST    | URL Selenoid          (selenoid.autotests.cloud) |
| TASK               | Задача на запуск      (по умолчанию test)        |


<a id="allure-report"></a>
## Интеграция с Allure Report
При удаленном запуске тестов в <code>Jenkins</code>, автоматически генерируется [Allure Report](https://jenkins.autotests.cloud/job/Khayrullin98_Mvideo_demo/allure/)

##### Все, кроме одного теста падают, так как у Мвидео на сайте стоит ограничение по большому количеству запросов подряд за короткий промежуток времени.

##### [Overview](https://jenkins.autotests.cloud/job/Khayrullin98_Mvideo_demo/allure/#)
<img width="100%" title="Allure Report" src="testartifacts/allure_report.png">

##### [Test details](https://jenkins.autotests.cloud/job/Khayrullin98_Mvideo_demo/allure/#behaviors)

<img width="100%" title="Allure Report" src="testartifacts/allure_testcase.png">

##### [Graphs](https://jenkins.autotests.cloud/job/Khayrullin98_Mvideo_demo/allure/#graph)

<img width="100%" title="Allure Report" src="testartifacts/allure_graphs.png">

<a id="интеграция-с-allure-testops"></a>
### Интеграция с Allure TestOps

В отчете [Allure TestOps](https://allure.autotests.cloud/project/3832/dashboards) можно:

- Просматривать созданные тест-кейсы и чек-листы,
- Запускать ручные и автоматические тестовые прогоны,
- Заводить дефекты,
- Собирать статистику о проделанной работе.

##### [Allure TestOps Dashboard](https://allure.autotests.cloud/project/3832/dashboards)

<img width="100%" title="Allure TestOps" src="testartifacts/testops_dashboards.png">

##### [Ручные и автоматические тест-кейсы](https://allure.autotests.cloud/project/3832/test-cases?treeId=7480)

<img width="100%" title="Allure TestOps" src="testartifacts/allure_tests.png">


<a id="интеграция-с-jira"></a>
### Интеграция с Jira

Интеграция <code>Allure TestOps</code> с <code>Jira</code>, позволяет отображать в [задаче](https://jira.autotests.cloud/browse/HOMEWORK-972), открытой в <code>Jira</code>, какие тест-кейсы были написаны в
рамках задачи и результат их выполнения.

<img width="100%" title="Jira" src="testartifacts/jira_task.png">

<a id="уведомление-в-telegram-о-результатах-выполнения-автоматизированных-тестов"></a>
### Уведомление в Telegram о результатах выполнения автоматизированных тестов

После завершения сборки, автоматически отправляется отчет о результатах выполнения тестов в специально созданный [Telegram чат](https://t.me/+a4NqXqNcXpwwNmZi).

<img width="40%" title="Jira" src="testartifacts/telegram_notifications.png">

<a id="видеопример-прохождения-тестов-selenoid"></a>
### Видеопример прохождения тестов Selenoid

В отчетах Allure для каждого теста создается не только скриншот, но и видео его прохождения.

<p>
<img width="100%" title="Selenoid Video" src="testartifacts/videotest.gif">  
</p>
