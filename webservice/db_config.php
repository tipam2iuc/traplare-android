<?php
define("DB_HOST", "localhost");
define("DB_USER", "id8665544_traplare");
define("DB_PASSWORD", "traplare");
define("DB_DATABASE", "id8665544_traplare_db");

//$db = mysqli_connect(DB_HOST,DB_USER,DB_PASSWORD,DB_DATABASE);
//$db= new PDO('mysql:host=localhost;db_name=id8665544_traplare_db','id8665544_traplare','traplare');
$pdo=new PDO('mysql:host=localhost;dbname=id8665544_traplare_db','id8665544_traplare','traplare');

if($pdo == true){
    echo "connection success";
}