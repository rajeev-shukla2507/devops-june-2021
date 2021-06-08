#include "hello.h"

void Hello::sayHello() {
	cout << "Hello C++ !" << endl;
}

int main ( void ) {
	Hello hello;
	hello.sayHello();
	
	return 0;
}
