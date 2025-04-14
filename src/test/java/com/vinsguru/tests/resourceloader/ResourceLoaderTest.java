package com.vinsguru.tests.resourceloader;

import com.vinsguru.util.ResourceLoader;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ResourceLoaderTest {

    public static void main(String[] args) throws Exception {
        InputStream stream = ResourceLoader.getResource("src/test/java/com/vinsguru/tests/resourceloader/test-data.txt");
        String content = IOUtils.toString(stream, StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
