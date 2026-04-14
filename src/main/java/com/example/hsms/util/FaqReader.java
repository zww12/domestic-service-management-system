package com.example.hsms.util;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
public class FaqReader {
    public static String readFaq() {
        try (InputStream is = new ClassPathResource("faq.txt").getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read FAQ file", e);
        }
    }
}