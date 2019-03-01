<?php
include 'db_function.php';
$response = array();
$username = $_REQUEST['username'];
$name = $_REQUEST['name'];
$cni = $_REQUEST['cni'];
$password=$_REQUEST['password'];
if (isset($_REQUEST['username']) && isset($_REQUEST['name']) && isset($_REQUEST['cni']) && isset($_REQUEST['password'])){

    $result=inscription($username,$name,$cni,$password);
    if ($result) {
        $response["success"] = 1;
        $response["message"] = "Successfully saved";
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