package beans;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class RootBean {

    @Autowired
    private volatile ByField byField;

    private ByConstructor byConstructor;
    private BySetter bySetter;

    @Autowired
    public RootBean(ByConstructor byConstructor) {
        new Thread(() -> {
            while (true) {
                if (byField != null) {
                    System.out.println("Autowired By field");
                    break;
                }
            }
        }).start();
        safetySleep();
        this.byConstructor = byConstructor;
        System.out.println("Autowired by Constructor");

    }

    private void safetySleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException noop) {
        }
    }

    @Autowired
    public void setBySetter(BySetter bySetter) {
        this.bySetter = bySetter;
        System.out.println("Autowired By setter");
    }

    public void init() {
        System.out.println("INIT METHOD");
    }

    public void dest() {
        System.out.println("DESTROY METHOD");
    }

    @PostConstruct
    public void postConstr() {
        System.out.println("POST CONSTRUCT");
    }

    public void printString(String s) {
        System.out.println("Root Bean : " + s);
    }
}
