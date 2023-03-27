package bsu.comp152;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StoryWrite {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String name, city, college, profession, animal, petsName;
        int age;

        FileWriter fw = new FileWriter("dataOut");
        PrintWriter outputFile = new PrintWriter(fw);

        System.out.print("Provide a first name: ");
        name = keyboard.nextLine();
        // name = keyboard.nextLine();
        /* Note that nextLine reads the whole line the user enters, including the newline character;
         * whereas next reads the next String (such as "feline" alone rather than all of "feline trainer").
         * If the user answers "Laura Gross" then next reads "Laura". "Gross" remains in the buffer.
         * Does Java prefill the next question?
         */

        System.out.print("Provide an age: ");
        age = keyboard.nextInt();
        // Note that nextInt reads only the next integer.  It does not read the newline character.
        // The newline character from when the user hit enter is in a buffer waiting to be read.

        // Consume the newline character, so that it doesn't prefill the next question.
        keyboard.nextLine();

        System.out.print("Provide the name of a city: ");
        city = keyboard.nextLine();

        System.out.print("Provide the name of a college: ");
        college = keyboard.nextLine();

        System.out.print("Provide the name of a profession: ");
        profession = keyboard.nextLine();

        System.out.print("State a type of animal: ");
        animal = keyboard.nextLine();

        System.out.print("State a pet's name: ");
        petsName = keyboard.nextLine();

        System.out.println(); // Leave a blank line.

        outputFile.printf("There once was a person named %s who lived in %s.\n", name, city);
        outputFile.printf("At the age of %d, %s went to college at %s.\n", age, name, college);
        outputFile.printf("%s graduated and went to work as %s %s.\n", name, article(profession), profession);
        outputFile.printf("Then, %s adopted %s %s named %s.\n", name, article(animal), animal, petsName);
        outputFile.print("They lived happily ever after!");

        outputFile.close();
    }

    public static String article(String word) {
        String vowels = "aeiouAEIOU";
        String firstLetterOfWord = word.substring(0, 1);
        if (vowels.contains(firstLetterOfWord)) {
            return "an";
        } else {
            return "a";
        }
    }
}