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
        'SELECT * FROM users 
                     WHERE username=? AND password=?'
    );
    $req->execute([$username,$password]);
    return $req->fetch();

}
function delete_user($id)
{
    global $pdo;
    $req=$pdo->prepare('DELETE FROM users WHERE id=?');
    $req->execute([$id]);
    return $req;
}

function update_user($id,$username,$name,$cni,$password)
{
    global $pdo;
    $req=$pdo->prepare('UPDATE users SET SET username=?,name=?,cni=?,password=? 
      WHERE id=? ');
    $req->execute
    (
        [
            $username,
            $name,
            $cni,
            $password,
            $id
        ]
    );
    return $req;
}
