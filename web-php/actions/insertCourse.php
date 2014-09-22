<?php

@session_start();
//echo $_SESSION['user']."<br/>";
$group=$_POST['group'];
$name=$_POST['name'];
//echo $group;
//echo $name;

$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }


mysql_select_db("termsaz", $con);
	$q = "SET NAMES 'utf8'";
mysql_query($q) or die('Query failed: ' . mysql_error());
//courseID,courseDay1,courseDay2,startTime,finishTime
	
	$sql="SELECT * FROM course WHERE courseName='$name' AND courseGroup='$group'";
	
	//if($result==mysql_query($sql)) echo "record selected";
	$result=mysql_query($sql);
	$row=mysql_fetch_array($result);
	echo $row['courseName']."-".$row['startTime']."-".$row['finishTime']."-".$row['courseDay1']."-".$row['courseDay2'];
	//$result = mysql_query("SELECT courseNumber FROM course WHERE courseName='$name' AND courseGroup='$group'");
	
	/*while($row=mysql_fetch_array($result))
	{
	
	echo $row['courseID']."<br/>";
	}*/
	//$e=$row['finishTime'];
	//$s=$row['startTime'];
	//$et=(decimal)$e;
	//$st=(int)$s;
	//$et=((80*$e)-483);
	//$st=((80*$s)-483);
	//echo $s."<br/>";
	//echo $e."<br/>";
	//echo $row['courseDay1']."<br/>";
	//echo $row['courseDay2']."<br/>";
	
	//$cday1=$row['courseDay1'];
	//$cday2=$row['courseDay2'];
	//$nday1=(int)$cday1;
	//$nday2=(int)$cday2;
	//echo $nday1."first day <br/>";
	
	
		
	//$sql2="INSERT INTO tags (id,name,day,startTime,endTime,username) VALUES (NULL,'$row[courseName]', '$cday1', '$st','$et','$_SESSION[user]')";
	
	/*if (!mysql_query($sql2,$con))
	{
		die('Error: ' . mysql_error());
	}*/
	
	//if($cday2!=0)
	//{
	//echo "salam";
	//$sql3="INSERT INTO tags (id,name,day,startTime,endTime,username) VALUES (NULL,'$row[courseName]', '$cday2', '$st','$et','$_SESSION[user]')";
	
	//$sql4="INSERT INTO stco (id,coID,stName,cGroup) VALUES (NULL,'$row[courseNumber]','$_SESSION[user]','$group')";
	//if (!mysql_query($sql3,$con))
	//{
		//die('Error: ' . mysql_error());
	//}
	//echo "one record added"; 
	//}
	
	
//mysql_close($con);



//echo $row['name']."-".$row['start']."-".$row['end']."-".$row['day1']."-".$row['day2']."-".$row['tagID']."-*";












?>