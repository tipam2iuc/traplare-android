<?php
include("db_config.php");


 function inscription($username,$firstname,$cni,$password,$lastname,$email,$phone)
{
    global $pdo;
    if (!empty($username)  && !empty($cni) && !empty($password) && !empty($lastname)
    && !empty($email) && !empty($phone) && !empty($firstname))
    {
        $req= $pdo->prepare
        (
            'INSERT INTO 
                           users 
                        VALUES (null ,?,?,?,?,?,?,?)'
        );
      return   $req->execute
        (
            [
               $username,
                $firstname,
                $cni,
                $password,
                $lastname,
                $email,
                $phone
            ]
        );
    }


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
