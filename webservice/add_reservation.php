<?php
require_once 'reservations_functions.php';
global $pdo;
$response = array();

if ((isset($_REQUEST['idvoyage']) && isset($_REQUEST['iduser'])
&& isset($_REQUEST['date_reservation']) && isset($_REQUEST['cni'])
    && isset($_REQUEST['nom']) && isset($_REQUEST['prenom']) && isset($_REQUEST['telephone'])&&
    ($_REQUEST['idvoyage'] != "N/A" && $_REQUEST['iduser'] != "N/A"
    && $_REQUEST['date_reservation']!= "N/A" && $_REQUEST['cni'] != "N/A"
        && $_REQUEST['nom']!= "N/A" && $_REQUEST['prenom']!= "N/A" && $_REQUEST['telephone']!= "N/A"))
){
    $idvoyage = $_REQUEST['idvoyage'];
    $iduser=$_REQUEST['iduser'];
    $date_reservation = $_REQUEST['date_reservation'];
    $cni = $_REQUEST['cni'];
    $nom = $_REQUEST['nom'];
    $prenom = $_REQUEST['prenom'];
    $telephone = $_REQUEST['telephone'];
    $code=str_random(25);

    $result=insert_reservation( intval($idvoyage),intval($iduser),$date_reservation,$cni,$nom,$prenom,$telephone,$code);
    if ($result) {
        $response["success"] = 1;
        $response["message"] = "your reservation is  sucessfull accept ";
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
    $response["message"] = "Required field(s) is missing or invalid";
    echo json_encode($response);
}

