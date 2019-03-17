<?php
require_once '../modele/voyage.php';
    $response = [];
    $compteur=0;
    $voyage = new voyage();
    $result = $voyage->get_travels();

    if (!empty($result)) {
        foreach ($result as $voyage)
        {
            $response[$compteur]=array(
                "success" => 1,
                "message"=> "full list",
                "date_debut_voy"=>$voyage["date_debut_voy"],
                "date_arrivee_voy"=>$voyage["date_arrivee_voy"],
                "prix_voy"=>$voyage["prix_voy"],
                "id_chauffeur"=>$voyage["id_chauffeur"],
                "id_hotesse"=>$voyage["id_hotesse"],
                "id_chef"=>$voyage["id_chef"],
                "id_clas"=>$voyage["id_clas"],
                "id_bus"=>$voyage["id_bus"],
                "id_voy"=>$voyage["id_bus"]
            );
            $compteur++;
        }
        echo json_encode($response);
    }
    else {
        $response["success"] = 0;
        $response["message"] = "Oops an error occured";
        echo json_encode($response);
    }
