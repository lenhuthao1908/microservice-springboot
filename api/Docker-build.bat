@echo off
rem down source code
docker-compose down

rem Build maven
CALL ./Maven-build-dev.bat

rem Build source no cache
docker-compose build --no-cache

rem up container
docker-compose up

rem push image
docker-compose push
