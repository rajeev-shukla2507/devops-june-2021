all: bin/hello.o
	g++ bin/hello.o -o bin/hello.exe

bin/hello.o: src/hello.cpp
	g++ -c src/hello.cpp -o bin/hello.o
 
clean:
	rm -f bin/*
