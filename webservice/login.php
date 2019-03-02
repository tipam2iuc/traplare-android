<?php
include 'db_function.php';
require_once 'db_config.php';
global $pdo;
$response = array();
$mylogin = array();

if (isset($_REQUEST['username']) && isset($_REQUEST['password'])){
    $username = $_REQUEST['username'];
    $password=$_REQUEST['password'];
    $result=login($username,$password);
    if ($result) {
        $exist=$pdo->prepare('SELECT * FROM users  WHERE username=?');
        $exist->execute([$username]);
        $user=$exist->fetch(PDO::FETCH_OBJ);
        $response["success"] = 1;
        $response["message"] = "sucessfull login";
        $response["valuename"]=$user->username;
        $response["valueid"]=$user->id;
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