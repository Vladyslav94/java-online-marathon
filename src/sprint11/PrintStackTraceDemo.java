package sprint11;
import java.io.ByteArrayOutputStream;import java.io.FileReader;
import java.io.IOException;import java.io.PrintStream;

public class PrintStackTraceDemo{
    public static void x(){
        try{
            a();
        }
        catch (IOException ioe){//this way of stack trace output is workaround for moodle
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            ioe.printStackTrace(ps);
            System.out.println(byteArrayOutputStream);
        }
    }

    public static void t() throws IOException{
        try { throw new IOException();} catch (IOException e) { e.printStackTrace(); }
    }

    static void a() throws IOException   {
        try { m(); } catch (IOException e) { e.printStackTrace(); }
    }

    static void m() throws IOException   {
        try { t(); } catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        x();
    }
}
