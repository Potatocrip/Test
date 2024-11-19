#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

int main()
{
    // Defines variables for information
    std::string firstName = "John";

    std::string lastName = "Johnson";

    std::string streetAddress = "123 John St";

    std::string city = "Johnsville";

    std::string zipCode = "12345";


    // Prints information
    cout << "Printing information for: "<< endl;

    cout << firstName + " " + lastName << endl;

    cout << streetAddress << endl;

    cout << city << endl;

    cout << zipCode << endl;

    return 0;
}