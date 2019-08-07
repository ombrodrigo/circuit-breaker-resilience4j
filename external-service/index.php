<?php

require_once 'Response.php';
require_once 'Action.php';

$action = new Action(new Response);

$methods = [
    'success',
    'sleep',
    'error'
];

shuffle($methods);

call_user_func([$action, current($methods)]);
