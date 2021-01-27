<?php

$db = new mysqli("localhost", "flatAdmin", "admin", "flatchmatch");

if ($db->connect_errno) {
    die("Verbindung fehlgeschlagen: " . $db->connect_error);
}

$sql = "select * from apartment ";
$sql .= "where city = '" . $_GET["city"] . "'";
if(isset($_GET["minSize"]) && $_GET["minSize"] != 0) {
	$sql .= " and size >= " . $_GET["minSize"];
}
if(isset($_GET["maxSize"]) && $_GET["maxSize"] != 0) {
	$sql .= " and size <= " . $_GET["maxSize"];
}
if(isset($_GET["minRooms"]) && $_GET["minRooms"] != 0) {
	$sql .= " and rooms >= " . $_GET["minRooms"];
}
if(isset($_GET["maxRooms"]) && $_GET["maxRooms"] != 0) {
	$sql .= " and rooms <= " . $_GET["maxRooms"];
}
if(isset($_GET["petsAllowed"]) && $_GET["petsAllowed"] != 0) {
	$sql .= " and petsallowed = '" . $_GET["petsAllowed"] . "'";
}
if(isset($_GET["minCosts"]) && $_GET["minCosts"] != 0) {
	$sql .= " and costs >= " . $_GET["minCosts"];
}
if(isset($_GET["maxCosts"]) && $_GET["maxCosts"] != 0) {
	$sql .= " and costs <= " . $_GET["maxCosts"];
}
if(isset($_GET["commercialUsage"]) && $_GET["commercialUsage"] != 0) {
	$sql .= " and commercialusage = '" . $_GET["commercialUsage"] . "'";
}
if(isset($_GET["furnishing"]) && $_GET["furnishing"] != 0) {
	$sql .= " and furnishing = '" . $_GET["furnishing"] . "'";
}

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
   $output .= '"commercialusage":' . $row['commercialusage'];  
   $output .= '"furnishing":' . $row['furnishing'];  
   $output .= '"description":' . $row['description'];  
   $output .= "},";
}

$output .= "]}";

echo str_replace("],}", "]}", $output);

?>
