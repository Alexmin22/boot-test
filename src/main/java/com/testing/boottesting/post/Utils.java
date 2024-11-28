package com.testing.boottesting.post;

import io.micrometer.common.util.StringUtils;

public class Utils {

    public static String trimIdToSpecifiedProjectLevel(String proj, int level) {
        if (level <1 || level > 4) {
            return null;
        }

        level++;
        int slashCount = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < proj.length(); i++) {
            if (proj.charAt(i) == '/') {
                slashCount++;
                if (slashCount == level) {
                    return result.toString();
                }
            }
            result.append(proj.charAt(i));
        }
        return result.toString();
    }

    public static String withTrailingSlash(final String string) {
        return StringUtils.isBlank(string) || string.endsWith("/")
                ? string
                : string + "/";
    }
}
