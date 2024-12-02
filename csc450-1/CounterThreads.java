public class CounterThreads {
    public static void main(String[] args) {

	// Simple for loops, iterating 20 times 
        Thread countUp = new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                System.out.println("Counting up: " + i);
            }
        });

        Thread countDown = new Thread(() -> {
            for (int i = 20; i >= 0; i--) {
                System.out.println("Counting down: " + i);
            }
        });

        System.out.println("Starting threads...");
        countUp.start();

        try {
            countUp.join(); // Waits for countUp to finish before proceeding. Keeps countDown from starting prematurely. Thread.join() is kinda just perfect for this tbh
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted while waiting for countUp.");
        }

        countDown.start();

        try {
            countDown.join(); // Likewise, waits for countDown to finish before proceeding. Keeps final "threads completed" from printing prematurely.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted while waiting for countDown.");
        }

        // Once countDown finishes, announces both threads are complete. Confirms proper timing.
        System.out.println("Both threads completed.");
    }
}


// Like with my C++ program, this avoids any potential race conditions by ensuring the second thread doesn't execute before the first has 
// finished executing-- as well as avoiding any shared resources. Threads in Java rely the OS's thread scheduler, which may cause some poor 
// performance if the system is heavily loaded; while this is irrelevant in this scenario due to how threads are managed here, it's something 
// to consider in the future. Strings are also not used in this scenario save for logging purposes (i.e. System.out.println) and are not
// affected by user input, preventing any potential manipulation. Likewise, this program only works with int variables in the counting loops,
// with no potential risk from malicious user-provided input. If such a risk *did* exist, however, there would be potential for an overflow
// vulnerability.