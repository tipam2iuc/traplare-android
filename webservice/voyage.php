<?php
require_once '../tools/db_connect.php';
class voyage
{
    private $date_debut_voy;
    private $date_arrivee_voy;
    private $prix_voy;
    private $id_chauffeur;
    private $id_hotesse;
    private $id_chef;
    private $id_clas;
    private $id_bus;
    private $id_voy;

    /**
     * @return mixed
     */
    public function getIdVoy()
    {
        return $this->id_voy;
    }

    /**
     * @param mixed $id_voy
     */
    public function setIdVoy($id_voy)
    {
        $this->id_voy = $id_voy;
    }

    /**
     * @return mixed
     */
    public function getDateDebutVoy()
    {
        return $this->date_debut_voy;
    }

    /**
     * @param mixed $date_debut_voy
     */
    public function setDateDebutVoy($date_debut_voy)
    {
        $this->date_debut_voy = $date_debut_voy;
    }

    /**
     * @return mixed
     */
    public function getDateArriveeVoy()
    {
        return $this->date_arrivee_voy;
    }

    /**
     * @param mixed $date_arrivee_voy
     */
    public function setDateArriveeVoy($date_arrivee_voy)
    {
        $this->date_arrivee_voy = $date_arrivee_voy;
    }

    /**
     * @return mixed
     */
    public function getPrixVoy()
    {
        return $this->prix_voy;
    }

    /**
     * @param mixed $prix_voy
     */
    public function setPrixVoy($prix_voy)
    {
        $this->prix_voy = $prix_voy;
    }

    /**
     * @return mixed
     */
    public function getIdChauffeur()
    {
        return $this->id_chauffeur;
    }

    /**
     * @param mixed $id_chauffeur
     */
    public function setIdChauffeur($id_chauffeur)
    {
        $this->id_chauffeur = $id_chauffeur;
    }

    /**
     * @return mixed
     */
    public function getIdHotesse()
    {
        return $this->id_hotesse;
    }

    /**
     * @param mixed $id_hotesse
     */
    public function setIdHotesse($id_hotesse)
    {
        $this->id_hotesse = $id_hotesse;
    }

    /**
     * @return mixed
     */
    public function getIdChef()
    {
        return $this->id_chef;
    }

    /**
     * @param mixed $id_chef
     */
    public function setIdChef($id_chef)
    {
        $this->id_chef = $id_chef;
    }

    /**
     * @return mixed
     */
    public function getIdClas()
    {
        return $this->id_clas;
    }

    /**
     * @param mixed $id_clas
     */
    public function setIdClas($id_clas)
    {
        $this->id_clas = $id_clas;
    }

    /**
     * @return mixed
     */
    public function getIdBus()
    {
        return $this->id_bus;
    }

    /**
     * @param mixed $id_bus
     */
    public function setIdBus($id_bus)
    {
        $this->id_bus = $id_bus;
    }


    /**
     * @return mixed
     */
     public function get_travels()
    {
        global $pdo;
           $req= $pdo->prepare("SELECT * FROM voyage  WHERE date_depart>=NOW()");
           $req->execute();
        return $req->fetchAll(PDO::FETCH_OBJ);
    }


}
?>