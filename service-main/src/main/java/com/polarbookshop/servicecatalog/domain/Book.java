package com.polarbookshop.servicecatalog.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public record Book(@NotBlank(message = "The ISBN must be defined.")
                   @Pattern(
                           regexp = "^([0-9]{10}|[0-9]{13})$",
                           message = "The ISBN must be valid."
                   )
                   String isbn,
                   @NotBlank(message = "The book title must be valid")
                   String title,
                   @NotBlank(message = "The author must be defined")
                   String author,
                   @NotNull(message = "The book price must be defined.")
                   @Positive(message = "The price must be greater than zero.")
                   Double price) {
}
