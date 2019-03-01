<?php
include "db_function.php";
include 'db_config.php';
$response = array();

if (  isset($_REQUEST['id']) && isset($_REQUEST['username']) && isset($_REQUEST['name']) && isset($_REQUEST['cni']) && isset($_REQUEST['password']) )
{
    $id=$_REQUEST['id'];
    $username = $_REQUEST['username'];
    $name = $_REQUEST['name'];
    $cni = $_REQUEST['cni'];
    $password=$_REQUEST['password'];
    $exist=$pdo->prepare('SELECT * FROM users  WHERE id=?');
    $exist->execute([$id]);
    $user=$exist->fetch(PDO::FETCH_OBJ);
    if (!empty($user))
    {
        $result=update_user($id,$username,$name,$cni,$password);
        if ($result) {
            $response["success"] = 1;
            $response["message"] = "Successfully update";
            $response["message"] = $username;
            $response["id"] = $user->id;
            echo json_encode($response);
        }
        else {
            $response["success"] = 0;
            $response["message"] = "Oops An error occurred.";
            echo json_encode($response);
        }

    }
    else
    {
        $response["success"] = 0;
        $response["message"] = "Oops user not exist.";
        echo json_encode($response);
    }

}
else {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
}