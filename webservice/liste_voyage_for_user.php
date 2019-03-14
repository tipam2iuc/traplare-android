<?php
require_once 'function_list_Voyagerfor_user.php';
global $pdo;
$response = array();
$mylogin = array();

if (isset($_REQUEST['username']) && isset($_REQUEST['password'])){
    $username = $_REQUEST['username'];
    $password=$_REQUEST['password'];
    $result=login2($username,$password);
    if ($result) {
        $compteur=0;
        foreach ($result as $v)
        {
            $response[$compteur]=array
            (
                "nom"=>$v->nom,
                "cni"=>$v->cni,
                "username"=>$v->username,
                "email"=>$v->email,
                "idvoyage"=>$v->idvoyage,
                "date_reservation"=>$v->date_reservation,
                "telephone"=>$v->telephone,
                "code"=>$v->code
            );
            $compteur++;
        }
       
        $response["success"] = 1;
        $response["message"] = "sucessfull found";
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
