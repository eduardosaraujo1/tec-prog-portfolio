OUT = bin
PREFIX = br.edu.fatecpg.polimorfismo

all:
	javac -d $(OUT) $(shell find . -name "*.java")

ex%:
	javac -d $(OUT) $(shell find . -path "*/ex$*/*.java")
	java -cp $(OUT) $(PREFIX).ex$*.view.Main