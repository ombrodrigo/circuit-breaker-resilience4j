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
        $this->response->send(['date_time' => date('Y-m-d H:i:s')], 200);
    }

    public function sleep()
    {
        $this->response->send(['date_time' => date('Y-m-d H:i:s')], 200, 5);
    }

    public function error()
    {
        $this->response->send(['date_time' => date('Y-m-d H:i:s')], 500);
    }
}