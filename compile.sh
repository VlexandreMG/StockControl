#!/usr/bin/env sh
set -eu

OUT_DIR="out"

mkdir -p "$OUT_DIR"

# Collect all Java source files in the project.
SOURCES=$(find . -type f -name "*.java")

if [ -z "$SOURCES" ]; then
  echo "No Java source files found."
  exit 1
fi

javac -d "$OUT_DIR" $SOURCES

MAIN_CLASS_FILE=$(find "$OUT_DIR" -type f -name "Main.class" | head -n 1)

if [ -z "$MAIN_CLASS_FILE" ]; then
  echo "Compilation successful. Main.class not found in ./$OUT_DIR"
  exit 0
fi

MAIN_CLASS=${MAIN_CLASS_FILE#./}
MAIN_CLASS=${MAIN_CLASS#"$OUT_DIR"/}
MAIN_CLASS=${MAIN_CLASS%.class}
MAIN_CLASS=$(printf '%s' "$MAIN_CLASS" | tr '/' '.')

echo "Compilation successful. Launching $MAIN_CLASS..."
java -cp "$OUT_DIR" "$MAIN_CLASS"
