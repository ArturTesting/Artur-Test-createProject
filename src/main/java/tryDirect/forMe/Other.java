package tryDirect.forMe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Other {
    public static void main(String[] args) throws Exception {
        Other person = new Other();
        person.cristinNormPatsan();

    }

    void cristinNormPatsan() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Назови свое имя ");
       String name =  reader.readLine();
        System.out.println(name +" Ты серьезно ?, Так себе у тебя имя ");
    }
}
