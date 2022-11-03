import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
import java.util.logging.FileHandler.*;

public class Presenter {
    View v;
    Model m;
    Scanner in = new Scanner(System.in);
    Logger logger;
    FileHandler fh;
    SimpleFormatter sFormat;

    Presenter() {

    }

    Presenter(View v, Model m) throws IOException {
        this.v = v;
        this.m = m;
        logger = Logger.getLogger("CalcLog");
        fh = new FileHandler("log.txt",true);
        logger.addHandler(fh);
        sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
    }


    void resultComplex() {
        Complex a = v.getValue();
        Complex b = v.getValue();
        m.setA(a);
        m.setB(b);
        Complex result = m.result();
        System.out.println(v.printComplex("Результат ", result));
        this.logger.log(Level.INFO, v.printComplex("", result));
    }
    void resultRational() {
        Rational a = v.getValue1();
        Rational b = v.getValue1();
        m.setRatioA(a);
        m.setRatioB(b);
        Rational result = m.result1();
        System.out.println(v.printRational("Результат ", result));
        this.logger.log(Level.INFO, v.printRational("", result));
    }


    void menu() throws IOException {
        boolean b = true;
        while (b) {
            System.out.println("Choose any variant: \n1:Summary\n2:Subtraction\n3:Multiply\n4:Division\n5:Exit");
            Presenter p;
            switch (in.nextInt()) {
                case 1:
                    System.out.println("Choose any variant: \n1:Rational\n2:Complex\n3:<--Previous");
                    switch (in.nextInt()) {
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
                    switch (in.nextInt()) {
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
                    switch (in.nextInt()) {
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
                    switch (in.nextInt()) {
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
