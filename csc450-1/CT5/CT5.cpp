#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

// Appends user input to the file
void appendToFile(const std::string& input, const std::string& filename) {
    std::ofstream outFile(filename, std::ios::app); // Opens file in append mode, to add text to the end of the file
    if (outFile) {
        outFile << input << std::endl;
        outFile.close();
        std::cout << "Text appended to " << filename << std::endl;
    }
    else {
        std::cerr << "Error opening file " << filename << std::endl;
    }
}

// Reversesthe contents of the input file and saves it to another file
void reverseFileContent(const std::string& inputFile, const std::string& outputFile) {
    std::ifstream inFile(inputFile);
    std::ofstream outFile(outputFile);

    if (inFile && outFile) {
        std::string content((std::istreambuf_iterator<char>(inFile)), std::istreambuf_iterator<char>());
        std::reverse(content.begin(), content.end());
        outFile << content;
        inFile.close();
        outFile.close();
        std::cout << "Reversed content saved to " << outputFile << std::endl;
    }
    else {
        std::cerr << "Error opening files " << inputFile << " or " << outputFile << std::endl;
    }
}

int main() {
    // Prompts user for input to be used when calling appendToFile
    std::string userInput;
    std::cout << "Enter text to append to the file: ";
    std::getline(std::cin, userInput);

    // Calls appendToFile, using our input file
    appendToFile(userInput, "CSC450_CT5_mod5.txt");

    // calls reverseFileContent, using our input file and destination file
    reverseFileContent("CSC450_CT5_mod5.txt", "CSC450-mod5-reverse.txt");

    return 0;
}
