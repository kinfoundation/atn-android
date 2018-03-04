package com.kik.atn;


import java.math.BigDecimal;
import java.util.List;

import kin.core.KinAccount;
import kin.core.exception.TransactionFailedException;

class ATNSender {

    private final KinAccount account;
    private final EventLogger eventLogger;
    private final ConfigurationProvider configProvider;

    ATNSender(KinAccount account, EventLogger eventLogger, ConfigurationProvider configProvider) {
        this.account = account;
        this.eventLogger = eventLogger;
        this.configProvider = configProvider;
    }

    void sendATN() {
        Config config = configProvider.getConfig(account.getPublicAddress());

        if (config.isEnabled()) {
            eventLogger.sendEvent("send_atn_started");
            try {
                EventLogger.DurationLogger durationLogger = eventLogger.startDurationLogging();
                account.sendTransactionSync(config.getAtnAddress(), "", new BigDecimal(1.0));
                durationLogger.report("send_atn_succeed");
            } catch (Exception ex) {
                if (ex instanceof TransactionFailedException) {
                    reportUnderfundedError(ex);
                } else {
                    eventLogger.sendErrorEvent("send_atn_failed", ex);
                }
            }
        } else {
            eventLogger.log("sendATN - disabled by configuration");
        }
    }

    private void reportUnderfundedError(Exception ex) {
        TransactionFailedException tfe = (TransactionFailedException) ex;
        List<String> resultCodes = tfe.getOperationsResultCodes();
        if (resultCodes != null && resultCodes.size() > 0 && "underfunded".equals(resultCodes.get(0))) {
            eventLogger.sendEvent("underfunded");
        }
    }
}
