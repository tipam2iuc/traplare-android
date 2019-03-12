
<?php
require_once 'db_config.php';

function insert_reservation($idvoyage,$iduser,$date_reservation,$cni,$nom,$prenom,$telephone,$code)
{
    global $pdo;
    $req=$pdo->prepare('INSERT INTO reservation VALUES(null,?,?,?,?,?,?,?,?) ');
    return $req->execute
    (
        [
            $idvoyage,
            $iduser,
            $date_reservation,
            $cni,
            $nom,
            $prenom,
            $telephone,
            $code
        ]
    );
}

function str_random ($length)
{
    $alphabet="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%_#@?!";
    return  substr(str_shuffle(str_repeat($alphabet,$length)),0,$length);
}
