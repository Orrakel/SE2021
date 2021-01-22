<?php

$db = new mysqli("localhost", "flatAdmin", "admin", "flatchmatch");

if ($db->connect_errno) {
    die("Verbindung fehlgeschlagen: " . $db->connect_error);
}

$sql = "select * from users ";
$sql .= " where email = '" . $_GET["email"] . "'";
$sql .= " and password = '" . $_GET["password"] . "'";

$output = "";

$output .= '{';

foreach ($db->query($sql) as $row) {
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
}

$output .= "}";

echo $output;

?>