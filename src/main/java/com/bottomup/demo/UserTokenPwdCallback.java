package com.bottomup.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UserTokenPwdCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++) {

			WSPasswordCallback wsCallback = (WSPasswordCallback) callbacks[i];
			if (wsCallback != null && wsCallback.getIdentifier().equals("Tim")) {
				wsCallback.setPassword("Tom");
			}

		}

	}

}
