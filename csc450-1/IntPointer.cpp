#include <iostream>

int main() {
    int int1, int2, int3;

        std::cout << "Enter first int: ";
        std::cin >> int1;

        std::cout << "Enter second int: ";
        std::cin >> int2;

        std::cout << "Enter third int: ";
        std::cin >> int3;

        // Creates three new pointers, assigns them to int vars
        int* ptr1 = new int;
        int* ptr2 = new int;
        int* ptr3 = new int;

        *ptr1 = int1;
        *ptr2 = int2;
        *ptr3 = int3;

        std::cout << "Variable int1 value: " << int1 << ", Pointer ptr1 value: " << *ptr1 << ", Pointer ptr1 address: " << ptr1 << std::endl;
        std::cout << "Variable int2 value: " << int2 << ", Pointer ptr2 value: " << *ptr2 << ", Pointer ptr2 address: " << ptr2 << std::endl;
        std::cout << "Variable int3 value: " << int3 << ", Pointer ptr3 value: " << *ptr3 << ", Pointer ptr3 address: " << ptr3 << std::endl;

        // Frees allocated memory
        delete ptr1;
        delete ptr2;
        delete ptr3;

    return 0;
}
