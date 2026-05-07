# Primeiro uso de um Makefile: não utilizarei optimized building por classe, será apenas um alias para `javac -d bin ...`
OUT := bin
PREFIX_RFQN := br.edu.fatecpg.atvheranca

# AI-assisted: aparently this makes those special names bypass make's timestamp check
.PHONY: all clean ex% build_ex%

_build_ex%:
	javac -d $(OUT) $(shell find src -path "*/ex$*/*.java")

all:
	javac -d $(OUT) $(shell find src -name "*.java")

ex%: _build_ex%
	java -cp $(OUT) $(PREFIX_RFQN).ex$*.view.Main

clean:
	rm -rf $(OUT)