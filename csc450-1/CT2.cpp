#include <iostream>
#include <string>

int main() {
    std::string str1, str2, concatenated;

    // loops 3 times
    for (int i = 1; i <= 3; ++i) {
        std::cout << "Enter first string: ";
        std::getline(std::cin, str1);

        std::cout << "Enter second string: ";
        std::getline(std::cin, str2);

        // concatenates str1 and 2, prints
        concatenated = str1 + str2;
        std::cout << "Concatenated String: " << concatenated << std::endl;
    }

    return 0;
}
