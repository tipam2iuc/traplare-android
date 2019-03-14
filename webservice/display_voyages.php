<?php
require_once  'db_config.php';
global $pdo;
$response=[];
$datenow=date('Y-m-d H:i:s');
$DateNow = new DateTime("now",new DateTimezone("Europe/Paris"));

 $req= $pdo->prepare("SELECT * FROM voyage  WHERE date_depart>=NOW()");
 $req->execute();

//$val=$req->fetchAll(PDO::FETCH_ASSOC);
/*
foreach ($val as $v)
{
   array
   (

   );
}*/

$compteur=0;
while ($voyage=$req->fetch())
{
    $response[$compteur]=array(
        "id"=>$voyage["id"],
        "compagnie"=>$voyage["compagnie"],
        "tarif"=>$voyage["tarif"],
        "date_depart"=>$voyage["date_depart"],
        "date_arrivee"=>$voyage["date_arrivee"],
        "depart"=>$voyage["depart"],
        "destination"=>$voyage["destination"],
        "class"=>$voyage["class"],
        "id"=>$voyage["id"],
    );
    $compteur++;
}

/*
$compteur=0;
foreach ($val as $v=>$value)
{
   $response[]= ["compagnie"=>$value["compagnie"],];
   $response[]= ["tarif"=>$value["tarif"],];
   $response[]= ["date_depart"=>$value["date_depart"],];
   $response[]= ["date_arrivee"=>$value["date_arrivee"],];
   $response[]= ["depart"=>$value["depart"],];
   $response[]= ["destination"=>$value["destination"],];
   $response[]= ["class"=>$value["class"],];
    $compteur++;
}*/
 //echo  json_encode($compteur);
// $voyage=$req->fetch();
 //$response["compagnie"]=$voyage["compagnie"];
echo  json_encode($response);
$req->closeCursor();
