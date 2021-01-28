<?php

$db = new mysqli("localhost", "flatAdmin", "admin", "flatchmatch");

if ($db->connect_errno) {
    die("Verbindung fehlgeschlagen: " . $db->connect_error);
}

$sql = "select * from users ";
$sql .= " where email in(SELECT email FROM likes";
$sql .= " WHERE city = '" . $_GET["city"] . "'";
$sql .= " AND zip = " . $_GET["zip"] . "'";
$sql .= " AND street = " . $_GET["street"] . "'";
$sql .= " AND housenumber = " . $_GET["housenumber"] . "'";
$sql .= . ")"

$output = "";

$output .= '{"users":[';

foreach ($db->query($sql) as $row) {
   $output .= '{';
   $output .= '"email":' . $row['email'] . ",";
   $output .= '"firstname":' . $row['Firstname'] . ",";
   $output .= '"lastname":' . $row['Lastname'] . ",";
   $output .= '"age":' . $row['age'] . ",";
   $output .= '"picture":' . $row['picture'] . ",";
   $output .= '"income":' . $row['income'] . ",";  
   $output .= '"job":' . $row['job'] . ",";  
   $output .= '"schufa":' . $row['schufa'] . ",";  
   $output .= '"pet":' . $row['pet'] . ",";  
   $output .= '"persons":' . $row['persons'];  
   $output .= '},';  
}

$output .= "]}";

echo $output;

?>