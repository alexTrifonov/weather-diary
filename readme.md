Приложение для регистрации погоды с заданным промежутком времени.
На базе Spring Data JDBC.
БД PostrgeSQL 14.
Сервера погоды DarkSky, OpenWeather.
Данные для сервера DarkSky: url - https://api.darksky.net,
current_weather_url - https://api.darksky.net/forecast/[key]/[latitude],[longitude]?units=si&exclude=minutely,hourly,daily,flags
Данные для сервера OpenWeather: url - https://openweathermap.org, current_weather_url - https://api.openweathermap.org/data/2.5/weather?lat=[latitude]&lon=[longitude]&appid=[key]&units=metric