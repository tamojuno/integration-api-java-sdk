package br.com.juno.integration.api.services;

import java.util.LinkedList;
import java.util.List;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.utils.Clock;
import kong.unirest.HttpResponse;

public abstract class BaseService {

    public void validateSuccess(HttpResponse<?> httpResponse) {
        if (!httpResponse.isSuccess()) {
            throw new JunoApiException(httpResponse.getStatusText());
        }
    }

    public static class CachedResource<T> {

        private Long timestamp = 0L;
        private List<T> cache = new LinkedList<>();

        public void setCache(List<T> cache) {
            this.cache = cache;
            resetTimestamp();
        }

        public List<T> getCache() {
            return cache;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public boolean isExpired() {
            return Clock.getTimeInMillis() - timestamp > JunoApiConfig.CACHE_TIMEOUT;
        }

        public void resetTimestamp() {
            setTimestamp(Clock.getTimeInMillis());
        }
    }

}
