 <?php
	@session_start();
	

	$con = mysql_connect("localhost","root","");
	if (!$con)
	{
	die('Could not connect: ' . mysql_error());
	}


  	mysql_select_db("termsaz", $con);
	$q = "SET NAMES 'utf8'";
	 mysql_query($q) or die('Query failed: ' . mysql_error());

	$sql="SELECT * FROM tags WHERE `userName` LIKE '$_SESSION[user]'";
	$result=mysql_query($sql) or die('Query failed: ' . mysql_error());
	while($row=mysql_fetch_array($result) )
 {
	echo $row['name']."-".$row['startTime']."-".$row['endTime']."-".$row['day']."-*";
	//."-".$row['id']
	
	
}
	
	
	//$result=mysql_query($sql);
	$sql="DELETE FROM tags WHERE `userName` LIKE '$_SESSION[user]'";
	mysql_query($sql) or die('Query failed: ' . mysql_error());
		//mysql_query($sql);
	
		
		mysql_close($con);


?>
 
