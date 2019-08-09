## Resilience4j Prometheus Metrics

#### HELP resilience4j_circuitbreaker_state The states of the circuit breaker
#### TYPE resilience4j_circuitbreaker_state gauge

* resilience4j_circuitbreaker_state{name="externalRequest",state="half_open",}
* resilience4j_circuitbreaker_state{name="externalRequest",state="disabled",}
* resilience4j_circuitbreaker_state{name="externalRequest",state="closed",}
* resilience4j_circuitbreaker_state{name="externalRequest",state="open",}
* resilience4j_circuitbreaker_state{name="externalRequest",state="forced_open",}

---

#### HELP resilience4j_retry_calls The number of successful calls without a retry #attempt
#### TYPE resilience4j_retry_calls gauge

* resilience4j_retry_calls{kind="failed_without_retry",name="externalRequest",}
* resilience4j_retry_calls{kind="successful_with_retry",name="externalRequest",}
* resilience4j_retry_calls{kind="failed_with_retry",name="externalRequest",}
* resilience4j_retry_calls{kind="successful_without_retry",name="externalRequest",}

---

#### HELP resilience4j_bulkhead_available_concurrent_calls The number of available #permissions
#### TYPE resilience4j_bulkhead_available_concurrent_calls gauge

* resilience4j_bulkhead_available_concurrent_calls{name="externalRequest",}

---

#### HELP resilience4j_ratelimiter_waiting_threads The number of waiting threads
#### TYPE resilience4j_ratelimiter_waiting_threads gauge

* resilience4j_ratelimiter_waiting_threads{name="externalRequest",}

---

#### HELP resilience4j_circuitbreaker_calls_total Total number of not permitted #calls
#### TYPE resilience4j_circuitbreaker_calls_total counter

* resilience4j_circuitbreaker_calls_total{kind="not_permitted",name="externalRequest",}

---

#### HELP resilience4j_ratelimiter_available_permissions The number of available #permissions
#### TYPE resilience4j_ratelimiter_available_permissions gauge

* resilience4j_ratelimiter_available_permissions{name="externalRequest",}

---

#### HELP resilience4j_circuitbreaker_failure_rate The failure rate of the circuit #breaker
#### TYPE resilience4j_circuitbreaker_failure_rate gauge

* resilience4j_circuitbreaker_failure_rate{name="externalRequest",}

---

#### HELP resilience4j_circuitbreaker_calls_seconds Total number of successful calls
#### TYPE resilience4j_circuitbreaker_calls_seconds summary

* resilience4j_circuitbreaker_calls_seconds_count{kind="ignored",name="externalRequest",}
* resilience4j_circuitbreaker_calls_seconds_sum{kind="ignored",name="externalRequest",}
* resilience4j_circuitbreaker_calls_seconds_count{kind="failed",name="externalRequest",}
* resilience4j_circuitbreaker_calls_seconds_sum{kind="failed",name="externalRequest",}
* resilience4j_circuitbreaker_calls_seconds_count{kind="successful",name="externalRequest",}
* resilience4j_circuitbreaker_calls_seconds_sum{kind="successful",name="externalRequest",}

---

#### HELP resilience4j_circuitbreaker_calls_seconds_max Total number of successful #calls
### TYPE resilience4j_circuitbreaker_calls_seconds_max gauge

* resilience4j_circuitbreaker_calls_seconds_max{kind="ignored",name="externalRequest",}
* resilience4j_circuitbreaker_calls_seconds_max{kind="failed",name="externalRequest",}
* resilience4j_circuitbreaker_calls_seconds_max{kind="successful",name="externalRequest",}

---

#### HELP resilience4j_circuitbreaker_buffered_calls The number of buffered failed #calls stored in the ring buffer
#### TYPE resilience4j_circuitbreaker_buffered_calls gauge

* resilience4j_circuitbreaker_buffered_calls{kind="failed",name="externalRequest",}
* resilience4j_circuitbreaker_buffered_calls{kind="successful",name="externalRequest",}

#### HELP resilience4j_circuitbreaker_max_buffered_calls The maximum number of #buffered calls which can be stored in the ring buffer
#### TYPE resilience4j_circuitbreaker_max_buffered_calls gauge

* resilience4j_circuitbreaker_max_buffered_calls{name="externalRequest",}

#### HELP resilience4j_bulkhead_max_allowed_concurrent_calls The maximum number of #available permissions
#### TYPE resilience4j_bulkhead_max_allowed_concurrent_calls gauge

* resilience4j_bulkhead_max_allowed_concurrent_calls{name="externalRequest",}