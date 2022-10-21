package com.cleevio.vexl.module.offer.dto.v2.response;

import com.cleevio.vexl.module.offer.entity.OfferPrivatePart;
import com.cleevio.vexl.module.offer.serializer.DateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class OfferUnifiedResponse {

    @Schema(description = "265-bit Offer ID")
    private final String offerId;

    @Schema(description = "Encrypted public payload. It should be encrypted by client with symmetric encryption.")
    private final String publicPayload;

    @Schema(description = "Encrypted private payload. It should be encrypted by client with asymmetric encryption.")
    private final String privatePayload;

    @Schema(description = "Expiration of an Offer in UNIX Timestamp (eg. 1392577232).")
    private final long expiration;

    @JsonSerialize(using = DateTimeSerializer.class)
    private final ZonedDateTime createdAt;

    @JsonSerialize(using = DateTimeSerializer.class)
    private final ZonedDateTime modifiedAt;

    public OfferUnifiedResponse(OfferPrivatePart offerPrivatePart) {
        this.offerId = offerPrivatePart.getOfferPublicPart().getOfferId();
        this.publicPayload = offerPrivatePart.getOfferPublicPart().getPayloadPublic();
        this.privatePayload = offerPrivatePart.getPayloadPrivate();
        this.expiration = offerPrivatePart.getOfferPublicPart().getExpiration();
        this.createdAt = offerPrivatePart.getOfferPublicPart().getCreatedAt();
        this.modifiedAt = offerPrivatePart.getOfferPublicPart().getModifiedAt();
    }
}
