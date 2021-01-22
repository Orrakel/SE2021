<?php

$db = new mysqli("localhost", "flatAdmin", "admin", "flatchmatch");

if ($db->connect_errno) {
    die("Verbindung fehlgeschlagen: " . $db->connect_error);
}

$sql = "select * from apartment ";
$sql .= "where city not in(select city from likes)";
$sql .= "and zip not in(select zip from likes)";
$sql .= "and street not in(select street from likes)";
$sql .= "and housenumber not in(select housenumber from likes)";
$sql .= "and city not in(select city from matches)";
$sql .= "and zip not in(select zip from matches)";
$sql .= "and street not in(select street from matches)";
$sql .= "and housenumber not in(select housenumber from matches)";

$output = "";

$output .= '{"apartments":[';

foreach ($db->query($sql) as $row) {
   $output .= "{";
   $output .= '"city":' . $row['city'] . ",";
   $output .= '"zip":' . $row['zip'] . ",";
   $output .= '"street":' . $row['street'] . ",";
   $output .= '"housenumber":' . $row['housenumber'] . ",";
   $output .= '"email":' . $row['email'] . ",";
   $output .= '"size":' . $row['size'] . ",";  
   $output .= '"petallowed":' . $row['petallowed'] . ",";  
   $output .= '"room":' . $row['room'] . ",";  
   $output .= '"costs":' . $row['costs'] . ",";  
   $output .= '"commercialusage":' . $row['commercialusage'] . ",";  
   $output .= '"furnishing":' . $row['furnishing'] . ",";  
   $output .= '"description":' . $row['description'];  
   $output .= "},";
}

$output .= "]}";

echo str_replace("],}", "]}", $output);

?>