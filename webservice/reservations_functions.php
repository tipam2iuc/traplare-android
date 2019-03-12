<?php
require_once "db_config.php;";

function add_reservertion($idvoyage,$date_reservation,$confirmation,$iduser,$nom,$prenom,$cni,$phone)
{

    global  $pdo;
    if (!empty($idvoyage)&& !empty($date_reservation)&& !empty($confirmation)&& !empty($iduser)
    && !empty($nom)&& !empty($prenom)&&!empty($cni) && !empty($phone)
    )
    {
         $req =$pdo->prepare
         (
             'INSERT INTO reservation VALUES (null ,?,?,?,?,?,?,?,?)'
         );
       return  $req->execute([$idvoyage,$date_reservation,$confirmation,$iduser,$nom,$prenom,$cni,$phone]);
    }
}