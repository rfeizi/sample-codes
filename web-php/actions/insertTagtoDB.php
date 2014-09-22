<?php

session_start();
echo $_SESSION['user'];

$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }


mysql_select_db("termsaz", $con);
	$q = "SET NAMES 'utf8'";

$q = "SET NAMES 'utf8'";
         mysql_query($q) or die('Query failed: ' . mysql_error());
	
	$sql="INSERT INTO tags (id, name, day, startTime, endTime, username) VALUES (NULL,'$_POST[name]', '$_POST[day]', '$_POST[start]','$_POST[end]','$_SESSION[user]')";
	
	if (!mysql_query($sql,$con))
	{
		die('Error: ' . mysql_error());
	}
	echo "one record added"; 












?>