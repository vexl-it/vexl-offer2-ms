package com.cleevio.vexl.module.offer.service.scheduled;

import com.cleevio.vexl.module.offer.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RemoveExpiredOffersTask {

    private final OfferService offerService;

    //    @Scheduled(fixedDelay = 30_000)
// Will be restored, once app will be unlocked.
    public void removeExpiredOffers() {
        log.info("Starting task for removing expired offers");

        offerService.removeExpiredOffers();
    }
}
