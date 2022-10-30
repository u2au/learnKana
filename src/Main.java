public class Main {

    public static void main(String[] args)
    {
        Menu m = new Menu();
        Process p = new Process();

        m.showMsg();
        p.process(m.selectMode());

    }
}