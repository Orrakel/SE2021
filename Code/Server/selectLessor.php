<?php

$db = new mysqli("localhost", "flatAdmin", "admin", "flatchmatch");

if ($db->connect_errno) {
    die("Verbindung fehlgeschlagen: " . $db->connect_error);
}

$sql = "select * from Lessor ";
$sql .= " where email = '" . $_GET["email"] . "'";
$sql .= " and password = '" . $_GET["password"] . "'";

$output = "";

$output .= '{';

foreach ($db->query($sql) as $row) {
   $output .= '"email":' . $row['email'];
}

$output .= "}";

echo $output;

?>