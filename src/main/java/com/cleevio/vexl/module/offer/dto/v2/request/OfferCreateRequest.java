package com.cleevio.vexl.module.offer.dto.v2.request;

import com.cleevio.vexl.common.annotation.NullOrNotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public record OfferCreateRequest(

        @Nullable
        @NullOrNotBlank
        String offerType,

        @Positive
        @Schema(required = true,
                description = "The time of expiration of an Offer in UNIX Timestamp (eg. 1392577232). Not encrypted.")
        long expiration,

        @NotBlank
        String payloadPublic,

        @Valid
        @NotEmpty
        List<@NotNull OfferPrivateCreate> offerPrivateList

) {
}
