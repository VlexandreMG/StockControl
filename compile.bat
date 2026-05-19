@echo off
REM Script de compilation pour Windows
setlocal enabledelayedexpansion

set OUT_DIR=out

REM Créer le répertoire de sortie s'il n'existe pas
if not exist "%OUT_DIR%" mkdir "%OUT_DIR%"

REM Collecter tous les fichiers Java récursivement
set "SOURCES="
for /r . %%F in (*.java) do (
    set "SOURCES=!SOURCES! "%%F""
)

if "!SOURCES!"=="" (
    echo Aucun fichier source Java trouvé.
    exit /b 1
)

REM Compiler les fichiers dans le dossier out
javac -d "%OUT_DIR%" !SOURCES!

if errorlevel 1 (
    echo Erreur lors de la compilation.
    exit /b 1
)

REM Se déplacer temporairement dans le dossier de sortie pour exécuter proprement
cd "%OUT_DIR%"

REM Chercher le fichier Main.class à partir d'ici
set "MAIN_CLASS_FILE="
for /r . %%F in (Main.class) do (
    set "MAIN_CLASS_FILE=%%F"
    goto found_main
)

:found_main
if "!MAIN_CLASS_FILE!"=="" (
    echo Compilation réussie. Main.class non trouvé dans .\%OUT_DIR%
    cd ..
    exit /b 0
)

REM Extraire proprement le package de la classe par rapport au dossier courant
set "RELATIVE_PATH="
for /f "tokens=1* delims=." %%A in ("%MAIN_CLASS_FILE%") do (
    set "FULL_PATH=%%A"
)

REM Supprimer le chemin du dossier de sortie actuel pour ne garder que le package
set "CURRENT_DIR=%CD%\"
set "MAIN_CLASS=!FULL_PATH:%CURRENT_DIR%=!"
set "MAIN_CLASS=!MAIN_CLASS:\=.!"

echo Compilation réussie. Exécution de !MAIN_CLASS!...
java !MAIN_CLASS!

REM Revenir au dossier d'origine
cd ..

endlocal