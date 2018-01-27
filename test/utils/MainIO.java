package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class MainIO {

    private ByteArrayOutputStream output;
    private ByteArrayOutputStream error;

    private MainIO() {}

    public MainIO(String text) {
        InputStream input = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        this.output =  new ByteArrayOutputStream();
        this.error =  new ByteArrayOutputStream();
        System.setIn(input);
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(error));
    }

    public ByteArrayOutputStream getOutput() {
        return this.output;
    }

    public ByteArrayOutputStream getError() {
        return this.error;
    }
}