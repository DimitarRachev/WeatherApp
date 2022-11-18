del commandoutput.txt
start /W /b both.bat
type  txt1.txt >> commandoutput.txt
type  txt2.txt >> commandoutput.txt
type  txt3.txt >> commandoutput.txt
type  txt4.txt >> commandoutput.txt
type  txt5.txt >> commandoutput.txt
timeout /t 5
del txt1.txt txt2.txt txt3.txt txt4.txt txt5.txt 
notepad commandoutput.txt
exit