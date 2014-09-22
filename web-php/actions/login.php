<?php

//header('Location:../index1.html');

$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

mysql_select_db("termsaz", $con);





//mysql_close($con);

require_once '../lib/CurlHandler.class.php';
require_once '../lib/simple_html_dom.php';

$url="";//action address//http://ce.sharif.edu/webmail/src/redirect.php
$mycurl=new CurlHandler($url);

// Preparing post data! (username & password & ...)
$post_data=array("username"=>$_POST['username'],"password"=>$_POST['password']);
//echo $_POST['username']. " ".$_POST['password'];


$mycurl->postData($post_data);

/*** Optional *****************************
// if cookie is required
//$mycurl->setCookie("cookie_for_".$_POST['username']);

// if you have set cookie in the previous execution
//$mycurl->readCookie("cookie_for_".$_POST['username']);
*******************************************/
$out=$mycurl->execute();

// check "$out" for both of valid and invalid user
if($out=="")
{
	session_start();
	$_SESSION['user']=$_POST['username'];
	//echo "salam".$_SESSION['user'];
	
	// From now on you have access to username by $_SESSION['user'] in whole of your application
	
	// Insert record to database (if not exists)
	// Before that you should create database, table, and db account in phpMyAdmin
	// ....
	mysql_select_db("termsaz", $con);
	$c_time=time();
	$sql="INSERT INTO users (username, quitTime)
VALUES ('$_POST[username]', '$c_time')";

if (!mysql_query($sql,$con))
  {
  //die('Error: ' . mysql_error());
  }
//echo "1 record added";

  echo "<script type='text/javascript'> window.location='../index1.php';</script>";
	// see: http://www.w3schools.com/php/php_mysql_insert.asp
}
else 
{
	 echo "incorrect username & password";
}


?>