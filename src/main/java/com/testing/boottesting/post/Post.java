package com.testing.boottesting.post;


import lombok.NonNull;

public record Post(Integer id, @NonNull Integer userId, @NonNull String title, String body) {
}
