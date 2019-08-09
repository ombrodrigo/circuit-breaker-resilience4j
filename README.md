## Circuit Breaker with Resilience4j
circuit-breaker-resilience4j it's a simple project to test circuit breaker pattern with Resilience4j library.


[CircuitBreaker definition](https://martinfowler.com/bliki/CircuitBreaker.html)

[Resilience4j](https://github.com/resilience4j/resilience4j)


## Getting started

#### In circuit-breaker folder, run project with Maven
```sh
mvn spring-boot:run
```
#### Use docker-compose to start external-service, grafana and prometheus servers.
```sh
docker-compose up
```

## Creating some records
Excute with cURL or browser http://localhost:8080/externalRequest/date-time

## Looking the results

* Open [http://localhost:3000](http://localhost:3000)
* Access Grafana with admin:admin

![alt text](https://i.imgur.com/pJmmmAc.png)
