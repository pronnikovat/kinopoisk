# Кинопоиск

Приложение собирает данные с рейтинга Кинопоиска (http://www.kinopoisk.ru/top/) и сохраняет позицию, рейтинг, оригинальное название, год и количество проголосовавших людей.
Соответствующие поля добавляются в БД для выборки рейтинга на определенную дату.

Для доступа к сохраненным данным предоставляется сервлет. Необходимо перейти по адресу http://localhost:8080/movies для отображения информации о первых 10 фильмах, находящихся в ТОП-250 Кинопоиска. 