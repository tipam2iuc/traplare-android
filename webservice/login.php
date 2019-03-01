<?php
include 'db_function.php';
$response = array();

if (isset($_REQUEST['username']) && isset($_REQUEST['password'])){
    $username = $_REQUEST['username'];
    $password=$_REQUEST['password'];

    $result=login($username,$password);
    if ($result) {
        $user=$result->fetch(PDO::FETCH_ASSOC);
        $response["success"] = 1;
        $response["message"] = "sucessfull login";
        $response["username"]=$username;
        echo json_encode($response);
    }
    else {
        $response["success"] = 0;
        $response["message"] = "Oops An error occurred.";
        echo json_encode($response);
    }
}
else {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
}