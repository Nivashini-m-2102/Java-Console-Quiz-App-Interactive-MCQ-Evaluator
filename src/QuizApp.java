import java.awt.Toolkit;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
class Question
{
    String question,option1,option2,option3,option4,explanation;
    int correctAnswer;
    Question(String q,String o1,String o2,String o3,String o4,int answer,String explain)
    {
        question=q;
        option1=o1;
        option2=o2;
        option3=o3;
        option4=o4;
        correctAnswer=answer;
        explanation=explain;
    }
    boolean askQuestion(Scanner sc)
    {
        System.out.println("\n"+question);
        System.out.println("1. "+option1);
        System.out.println("2. "+option2);
        System.out.println("3. "+option3);
        System.out.println("4. "+option4);
        System.out.print("enter your choice(1-4): ");
        int username=sc.nextInt();
        if(username == correctAnswer)
        {
            System.out.println("Correct! ");
            return true;
        }
        else
        {   Toolkit.getDefaultToolkit().beep();
            System.out.println("Wrong Answer!  \n The Correct Answer is: " + correctAnswer);
            switch(correctAnswer)
            {
                case 1:
                     System.out.println(option1);
                     break;
                case 2:
                     System.out.println(option2);
                     break;
                case 3:
                     System.out.println(option3);
                     break;
                case 4:
                     System.out.println(option4);
                     break;
            }
            System.out.println("explanation:"+explanation);
            return false;
        }
    }

}
public class QuizApp
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Question [] questions={new Question("What will be the output of the following code?\n\n" +
                "public class Test {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = 10;\n" +
                "        System.out.println(a++ + ++a);\n" +
                "    }\n" +
                "}",
                "20", "21", "22", "23",
                3,
                "`a++` is 10, then `++a` becomes 12. So 10 + 12 = 22."),
                new Question("Which of these data types takes the least amount of memory in Java?",
                "int", "short", "byte", "long",
                3,
                "`byte` takes only 1 byte (8 bits), smallest among Java primitive types."),
                new Question("What does the final keyword mean when applied to a method?", "Method can be overridden","Method cannot be inherited","Method cannot be overridden","Method is abstract",3,"A final method cannot be overridden by subclasses."),
                new Question("Which of the following is true about Java?"," Java supports multiple inheritance using classes"," Java supports operator overloading","Java is platform-dependent","Java supports garbage collection",4," Java has an automatic garbage collector, unlike C/C++.")
    };
    int score=0;
    System.out.println("Enter your name:");
    String name=sc.next();
    System.out.println("\n Welcome, "+ name + " lets begin the quiz ! \n");
    List<Question> questionList= Arrays.asList(questions);
    Collections.shuffle(questionList);
    for(Question q:questionList)
    {
        if(q.askQuestion(sc))
        {
            score++;
        }
    }
    try
    {
        Thread.sleep(2000);
    }
    catch(InterruptedException e)
    {
        System.out.println(e + "Opps something went wrong while waiting");
    }
    System.out.println("\n--- Quiz Over---");
    System.out.println("Your Score: " + score + " out of " + questions.length);
    if(score == 4)
    {
        System.out.println("\"Congratulations! You got a perfect score!\"");
    }
    else if(score == 3)
    {
        System.out.println("Great Job! Almost perfect!");
    }
    else if(score == 2)
    {
        System.out.println("Good Effort! Keep practicing!");
    }
    else
    {
        System.out.println("Keep learning! You can do better.");
    }
    int percentage=(score*100)/questions.length;
    System.out.println("Percentage:"+ percentage + " % " );
    if(percentage>=60)
    {
        System.out.println("Result:passed");
    }
    else
    {
        System.out.println("Result:failed");
    }
}
}
