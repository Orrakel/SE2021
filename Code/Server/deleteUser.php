<?php

$db = new mysqli("localhost", "flatAdmin", "admin", "flatchmatch");

if ($db->connect_errno) {
    die("Verbindung fehlgeschlagen: " . $db->connect_error);
}

$sql = "DELETE FROM Users ";
$sql .= "WHERE email = '" . $_GET['email'] . "' ";

$db->query($sql);

echo $sql;

?>