package com.accenture.testkafka.domain.order;

import jakarta.validation.constraints.NotNull;

public record OrderDTO(@NotNull String client, @NotNull String product) {
}
