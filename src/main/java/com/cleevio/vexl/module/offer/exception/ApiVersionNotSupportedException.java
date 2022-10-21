package com.cleevio.vexl.module.offer.exception;

import com.cleevio.vexl.common.exception.ApiException;
import com.cleevio.vexl.common.exception.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiVersionNotSupportedException extends ApiException {

    @Override
    protected ApiException.Module getModule() {
        return ApiException.Module.OFFER;
    }

    @Override
    protected ErrorType getErrorType() {
        return OfferErrorType.API_VERSION_NOT_SUPPORTED;
    }
}
