# TestSimbirSoft
Для того чтобы запустить Selenium Grid необходимо:
1) Скачать Selenium Server (Grid) https://www.selenium.dev/downloads/
2) Скачать необходимые драйвера для браузеров
3) Открыть cmd в директории где лежит Selenium Server (файл из 1 пунтка)
4) Запутсить hub через cmd по следующим шагам: 

java -Dfile.encoding=UTF-8 -jar selenium-server-<version>.jar hub
  
java -jar selenium-server-<version>.jar distributor --sessions http://localhost:5556
  
java -jar selenium-server-<version>.jar router --sessions http://localhost:5556 --distributor http://localhost:5553
  
java -jar selenium-server-<version>.jar node
