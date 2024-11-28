package com.testing.boottesting.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.testing.boottesting.post.Utils.trimIdToSpecifiedProjectLevel;

class UtilsTest {

    @ParameterizedTest
    @CsvSource({
            "0, '/orgKey/proj123/subProj456/repo123', ",
            "1, '/orgKey', '/orgKey'",
            "2, '/orgKey', '/orgKey'",
            "2, '/orgKey/proj123/subProj456/repo123', '/orgKey/proj123'",
            "3, '/orgKey/proj123/subProj456/repo123', '/orgKey/proj123/subProj456'",
            "4, '/orgKey/proj123/subProj456/repo123', '/orgKey/proj123/subProj456/repo123'"
    })
    void testTrimIdToSpecifiedProjectLevel(int level, String proj, String expected) {
        Assertions.assertEquals(expected, trimIdToSpecifiedProjectLevel(proj, level));
    }

    @Test
    void withTrailing() {
        System.out.println(Utils.withTrailingSlash(null));
    }

    @Test
    void newPerson() {
        String name = "John";
        Person person = new Person();
        person.setName(name);

        name = "Vasya";
        System.out.println(person);
    }
}