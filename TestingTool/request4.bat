
echo FILE2

for /l %%x in (1, 1, 100) do (
@echo off
curl -X POST  http://localhost:8762/weather_module/weather/AAaA/45.25 >> txt4.txt)
exit 