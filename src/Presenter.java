import java.util.Scanner;

public class Presenter {
    View v;
    Model m;
    Scanner in = new Scanner(System.in);

    Presenter() {

    }

    Presenter(View v, Model m) {
        this.v = v;
        this.m = m;
    }


    void resultComplex() {
        Complex a = v.getValue();
        Complex b = v.getValue();
        m.setA(a);
        m.setB(b);
        Complex result = m.result();
        System.out.println(v.printComplex("Результат ", result));
    }
    void resultRational() {
        Rational a = v.getValue1();
        Rational b = v.getValue1();
        m.setRatioA(a);
        m.setRatioB(b);
        Rational result = m.result1();
        System.out.println(v.printRational("Результат ", result));
    }


    void menu() {
        boolean b = true;
        while (b) {
            System.out.println("Choose any variant: \n1:Summary\n2:Subtraction\n3:Multiply\n4:Division\n5:Exit");
            Integer key = in.nextInt();
            Presenter p;
            switch (key) {
                case 1:
                    System.out.println("Choose any variant: \n1:Rational\n2:Complex\n3:<--Previous");
                    Integer key1 = in.nextInt();
                    switch (key1) {
                        case 1:
                            p = new Presenter(new View(), new SumModel());
                            p.resultRational();
                            break;
                        case 2:
                            p = new Presenter(new View(), new SumModel());
                            p.resultComplex();
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Choose any variant: \n1:Rational\n2:Complex\n3:<--Previous");
                    Integer key2 = in.nextInt();
                    switch (key2) {
                        case 1:
                            p = new Presenter(new View(), new SubtractionModel());
                            p.resultRational();
                            break;
                        case 2:
                            p = new Presenter(new View(), new SubtractionModel());
                            p.resultComplex();
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Choose any variant: \n1:Rational\n2:Complex\n3:<--Previous");
                    Integer key3 = in.nextInt();
                    switch (key3) {
                        case 1:
                            p = new Presenter(new View(), new MultiplyModel());
                            p.resultRational();
                            break;
                        case 2:
                            p = new Presenter(new View(), new MultiplyModel());
                            p.resultComplex();
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Choose any variant: \n1:Rational\n2:Complex\n3:<--Previous");
                    Integer key4 = in.nextInt();
                    switch (key4) {
                        case 1:
                            p = new Presenter(new View(), new DivideModel());
                            p.resultRational();
                            break;
                        case 2:
                            p = new Presenter(new View(), new DivideModel());
                            p.resultComplex();
                            break;
                        case 3:
                            break;
                    }
                    break;
                default:
                    b = false;
            }
        }
    }
}
