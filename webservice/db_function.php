<?php
include("db_config.php");

function inscription($username,$name,$cni,$password){
    global $pdo;
    $req= $pdo->prepare
    (
        'INSERT INTO 
                            users 
                        VALUES (null ,?,?,?,?)'
    );
    return $req->execute
    (
        [
            $username,
            $name,
            $cni,
            $password
        ]
    );
}
function login($username,$password)
{
    global $pdo;
    $req=$pdo->prepare
    (
        'SELECT username, FROM users 
                     WHERE username=?'
    );
    $req->execute([$username]);
    return $req;

}
function delete_user($id)
{
    global $pdo;
    $req=$pdo->prepare('DELETE FROM users WHERE id=?');
    $req->execute([$id]);
    return $req;
}
