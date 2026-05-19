@echo off
REM Script de compilation pour Windows

setlocal enabledelayedexpansion

set OUT_DIR=out

REM Créer le répertoire de sortie
if not exist "%OUT_DIR%" mkdir "%OUT_DIR%"

REM Collecter tous les fichiers Java
setlocal enabledelayedexpansion
set "SOURCES="
for /r . %%F in (*.java) do (
    set "SOURCES=!SOURCES! %%F"
)

if "!SOURCES!"=="" (
    echo Aucun fichier source Java trouvé.
    exit /b 1
)

REM Compiler
javac -d "%OUT_DIR%" !SOURCES!

if errorlevel 1 (
    echo Erreur lors de la compilation.
    exit /b 1
)

REM Chercher Main.class
set "MAIN_CLASS_FILE="
for /r "%OUT_DIR%" %%F in (Main.class) do (
    set "MAIN_CLASS_FILE=%%F"
    goto found_main
)

:found_main
if "!MAIN_CLASS_FILE!"=="" (
    echo Compilation réussie. Main.class non trouvé dans .\%OUT_DIR%
    exit /b 0
)

REM Extraire le nom de la classe
set "MAIN_CLASS=!MAIN_CLASS_FILE:%OUT_DIR%\=!"
set "MAIN_CLASS=!MAIN_CLASS:.class=!"
set "MAIN_CLASS=!MAIN_CLASS:\=.!"

echo Compilation réussie. Exécution de !MAIN_CLASS!...
java -cp "%OUT_DIR%" !MAIN_CLASS!

endlocal
