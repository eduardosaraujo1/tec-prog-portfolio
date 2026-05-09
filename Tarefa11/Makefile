OUT = bin
PREFIX = br.edu.fatecpg.empresa

.PHONY = run clean

run:
	javac -d $(OUT) $(shell find . -name "*.java")
	java -cp $(OUT) $(PREFIX).view.Main

clean:
	rm -rf $(OUT)