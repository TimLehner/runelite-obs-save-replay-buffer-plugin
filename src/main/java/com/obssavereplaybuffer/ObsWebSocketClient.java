package com.obssavereplaybuffer;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.util.concurrent.TimeUnit;

public class ObsWebSocketClient {
    private final String websocketUrl;
    private final String password;

    private final Gson gson = new Gson();

    private final OkHttpClient client;

    private WebSocket webSocket;

    private class ObsRequest {
        private final int op = 6;
        private final D d;

        public ObsRequest(String requestType, String requestId, Object requestData) {
            this.d = new D(requestType, requestId, requestData);
        }

        private class D {
            private final String requestType;
            private final String requestId;
            private final Object requestData;

            public D(String requestType, String requestId, Object requestData) {
                this.requestType = requestType;
                this.requestId = requestId;
                this.requestData = requestData;
            }
        }
    }

    public ObsWebSocketClient(String host, int port, String password) {
        this.websocketUrl = "ws://" + host + ":" + port;
        this.password = password;

        // Initialize OkHttpClient with a reasonable timeout
        this.client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public void saveReplayBuffer() {
        ObsRequest saveReplayBufferRequest = new ObsRequest("SaveReplayBuffer", "runelite-clip-req", new Object());
        String jsonPayload = gson.toJson(saveReplayBufferRequest);
        this.webSocket.send(jsonPayload);
    }

    public void connect() {
        Request request = new Request.Builder()
                .url(websocketUrl)
                .build();
        this.webSocket = client.newWebSocket(request, new ObsWebSocketListener(password));
    }

    public void disconnect() {
        this.webSocket.close(1000, "Normal Shutdown");
    }
}
