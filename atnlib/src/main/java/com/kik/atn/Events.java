package com.kik.atn;


final class Events {
    private Events() {
    }

    static final String ONBOARD_STARTED = "onboard_started";
    static final String ONBOARD_SUCCEEDED = "onboard_succeeded";
    static final String ONBOARD_IS_FUNDED_FAILED = "onboard_is_funded_failed";
    static final String ONBOARD_FAILED = "onboard_failed";
    static final String ONBOARD_CREATE_WALLET_STARTED = "onboard_create_wallet_started";
    static final String ONBOARD_CREATE_WALLET_SUCCEEDED = "onboard_create_wallet_succeeded";
    static final String ONBOARD_CREATE_WALLET_FAILED = "onboard_create_wallet_failed";
    static final String ONBOARD_LOAD_WALLET_STARTED = "onboard_load_wallet_started";
    static final String ONBOARD_LOAD_WALLET_SUCCEEDED = "onboard_load_wallet_succeeded";
    static final String ONBOARD_LOAD_WALLET_FAILED = "onboard_load_wallet_failed";
    static final String ONBOARD_ACCOUNT_NOT_FUNDED = "onboard_account_not_funded";
    static final String ACCOUNT_FUNDING_SUCCEEDED = "account_funding_succeeded";
    static final String ACCOUNT_FUNDING_FAILED = "account_funding_failed";
    static final String SEND_ORBS_STARTED = "send_orbs_started";
    static final String SEND_ORBS_SUCCEEDED = "send_orbs_succeeded";
    static final String SEND_ORBS_FAILED = "send_orbs_failed";
}
