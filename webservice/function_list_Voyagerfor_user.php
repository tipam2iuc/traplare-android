<?php
require_once 'db_config.php';
function login2($username,$password)
{
    global $pdo;
    $req=$pdo->prepare
    (
        'SELECT  
              reservation.nom,
              reservation.cni,
              reservation.prenom,
              users.username,
              users.lastname ,
              users.firstname ,
              users.email ,
              users.phone ,
              reservation.idvoyage,
              reservation.date_reservation,
              reservation.telephone,
              reservation.code
               FROM reservation 
               JOIN users ON reservation.iduser=users.id
               WHERE username=? AND password=?'
    );
    $req->execute([$username,$password]);
    return $req->fetchAll(PDO::FETCH_OBJ);

}