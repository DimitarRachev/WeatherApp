
echo FILE2

for /l %%x in (1, 1, 100) do (
@echo off
curl -X POST  http://desolate.asuscomm.com:9002/weather_module/weather/AAaA/45.25 >> txt3.txt) 
exit 