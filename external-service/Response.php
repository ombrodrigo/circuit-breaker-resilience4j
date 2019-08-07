<?php

class Response 
{
    public function send($response, $statusCode, $sleep = 0)
    {
        if ($sleep > 0) {
            sleep($sleep);
        }

        http_response_code($statusCode);

        if (!is_array($response)) {
            $response = [$response];
        }

        echo json_encode($response);
    }
}