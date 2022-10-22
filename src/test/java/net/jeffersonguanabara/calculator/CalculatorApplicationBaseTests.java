package net.jeffersonguanabara.calculator;

import java.nio.file.Files;
import java.nio.file.Paths;

class CalculatorApplicationBaseTests {

	public static String readFileFromResources(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(file).toURI())));
    }

}
