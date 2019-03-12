<?php
include 'db_function.php';
$response = array();

if (isset($_REQUEST['username']) && isset($_REQUEST['firstname']) && isset($_REQUEST['cni'])
    && isset($_REQUEST['password']) && isset($_REQUEST['lastname'])&& isset($_REQUEST['email'])
    && isset($_REQUEST['phone'])
)
{
    $username = $_REQUEST['username'];
    $cni = $_REQUEST['cni'];
    $password=$_REQUEST['password'];
    $firstname=$_REQUEST['firstname'];
    $lastname=$_REQUEST['lastname'];
    $phone=$_REQUEST['phone'];
    $email=$_REQUEST['email'];
    $image= isset($_REQUEST['image'])?$_REQUEST['image']:null;
    $upload_path="images/$cni.jpg";

    $result=inscription($username,$firstname,$cni,$password,$lastname,$email,$phone,$upload_path);
    if (!empty($result)) {
        file_put_contents($upload_path,base64_decode($image));
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