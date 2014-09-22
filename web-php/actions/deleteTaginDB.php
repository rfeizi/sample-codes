<?php




$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }


mysql_select_db("termsaz", $con);
	$q = "SET NAMES 'utf8'";

$q = "SET NAMES 'utf8'";
         mysql_query($q) or die('Query failed: ' . mysql_error());
		 
		 
	$sql="DELETE FROM tags
WHERE startTime='$_POST[start]' AND endTime='$_POST[end]' AND day='$_POST[myday]'";
if (!mysql_query($sql,$con))
	{
		die('Error: ' . mysql_error());
	}
	echo "one record deleted" ; 	 
		 
		 
		 

		 
		 
		 
?>