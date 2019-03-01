<?php
include 'db_function.php';
$response = array();
$id = $_REQUEST['id'];

if ( isset($_REQUEST['id'])){

    $result=delete_user($id);
    if ($result) {
        $response["success"] = 1;
        $response["message"] = "Successfully deleted";
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