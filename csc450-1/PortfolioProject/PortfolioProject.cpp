#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

std::mutex mtx;
std::condition_variable cv; // Important for how I do thread timings here!
bool first_thread_done = false; // Sets this up for later-- cv.wait will check this before starting countDown()

void countUp() {
    for (int i = 1; i <= 20; ++i) {
        std::unique_lock<std::mutex> lock(mtx); // Locks the mutex, protecting std::cout; only t1 will write to the console. Racing isn't allowed!
        std::cout << "Counting up: " << i << std::endl;
    }
    {
        std::unique_lock<std::mutex> lock(mtx); // Ditto, safely updating first_thread_done; a shared variable between the two threads
        first_thread_done = true;
    }
    cv.notify_one(); // Notifies the second thread
}

void countDown() {
    std::unique_lock<std::mutex> lock(mtx);
    cv.wait(lock, [] { return first_thread_done; }); // Waits for the first thread to finish
    for (int i = 20; i >= 0; --i) {
        std::cout << "Counting down: " << i << std::endl;
    }
}

int main() {
    std::thread t1(countUp);
    std::thread t2(countDown);

    t1.join();
    t2.join();

    std::cout << "Both threads completed." << std::endl;
    return 0;
}

// Proper use of concurrency relies on an understanding of its vulnerabilities; avoiding race conditions or AT LEAST ensuring they're
// addressed so that two threads don't reach a deadlock is crucial. This IS a risk with a program like this-- Thankfully, it is mitigated  
// here by making use of std::unique_lock<std::mutex> lock(mtx); to ensure thread-safe management of shared variables and utilities like  
// std::cout and first_thread_done. This also applies if a program were to utilize strings, particularly if two threads use a shared string; 
// for example, if two threads were to try to define the same string at the same time, or if one thread was to try to read and print a string  
// while another thread is still defining it.