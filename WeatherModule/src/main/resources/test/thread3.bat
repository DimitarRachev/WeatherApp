
for /l %%x in (1, 1, 100) do (curl -X POST localhost:8762/weather_module1/weather/VWR/23)  >> output3.txt