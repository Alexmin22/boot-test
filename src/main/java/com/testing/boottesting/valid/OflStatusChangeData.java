package com.testing.boottesting.valid;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OflStatusChangeData(
        @NotBlank
        String orderId,
        @NotNull
        Long mdmId,
        @Valid
//        @Nullable
        AdditionalAttributes additionalAttributes
) {
    public record AdditionalAttributes(@Valid Confirmation confirmation) {

        public record Confirmation(
                String confirmationAvailability,
                List<@Valid ConfirmationData> confirmationData
        ) {
            private static final String ALIVE_AVAILABILITY_STATUS = "ALIVE";

            public boolean isSuccess() {
                return ALIVE_AVAILABILITY_STATUS.equalsIgnoreCase(confirmationAvailability);
            }
        }

        public record ConfirmationData(
                @NotNull
                Boolean successful,
                @NotBlank
                String type
        ) {
        }
    }
}
