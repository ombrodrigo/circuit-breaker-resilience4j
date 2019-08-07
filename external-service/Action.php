<?php

class Action
{
    private $response;

    public function __construct(Response $response)
    {
        $this->response = $response;
    }

    public function success()
    {
        $this->response->send(['message' => 'SUCCESS', 'timestamp' => time()], 200);
    }

    public function sleep()
    {
        $this->response->send(['message' => 'SLEEP', 'timestamp' => time()], 200, 5);
    }

    public function error()
    {
        $this->response->send(['message' => 'ERROR', 'timestamp' => time()], 500);
    }
}