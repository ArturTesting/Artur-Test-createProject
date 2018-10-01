package tryDirect;

import java.util.ArrayList;
import java.util.List;

public class SymbolGenerate {

    private List<Integer> l=new ArrayList<>();

    public List<Integer> buildsequenceNumber() {

        l.clear();

        for (int i = 48; i < 58; i++) {
            l.add(i);
        }

        return l;
    }
    public List<Integer> buildsequenceLowerChar(){
        l.clear();

        for (int i = 97; i < 123; i++) {
            l.add(i);
        }

        return l;
    }
    public List<Integer> buildsequenceUpperChar(){

        l.clear();

        for (int i = 65; i < 91; i++) {
            l.add(i);
        }

        return l;
    }
    public List<Integer> buildsequenceSpecSymbol(){

        l.clear();

        for (int i = 32; i < 45; i++) {
            l.add(i);
        }
        for (int i = 58; i < 65; i++) {
            l.add(i);
        }
        for (int i = 91; i < 97; i++) {
            l.add(i);
        }
        for (int i = 123; i < 127; i++) {
            l.add(i);
        }
        l.add(47);

        return l;
    }
    public List<Integer> buildsequenceSpecSymbolExp(){

        l.clear();

        for (int i = 128; i < 255; i++) {
            l.add(i);
        }

        return l;
    }

}
