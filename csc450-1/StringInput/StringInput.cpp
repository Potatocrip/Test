#include <iostream>
#include <conio.h>
#include <string>

int main()
{
    std::string str1, str2, concatStr;

    for (int i = 1; i <= 3; ++i) {
        std::cout << "Attempt " << i << ": \n";

        std::cout << "Enter your first string: ";
        std::getline(std::cin, str1);

        std::cout << "Enter your second string: ";
        std::getline(std::cin, str2);

        concatStr = str1 + str2;

        std::cout << "The concatenated string is: " << concatStr << "\n\n";
    }
    return 0;
}
