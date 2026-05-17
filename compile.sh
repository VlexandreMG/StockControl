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

echo "Compilation successful. Classes generated in ./$OUT_DIR"
