package com.testing.boottesting.post;

import java.time.LocalTime;


public record ErrorMessage(int statusCode, LocalTime timestamp, String message, String description) {
}