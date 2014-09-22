<?php


$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

mysql_select_db("", $con);


require_once '../lib/CurlHandler.class.php';
require_once '../lib/simple_html_dom.php';
//$uni_url=$_POST['code'];

// Mathematics Department :: Find the other urls using firebug (depID)! 
//echo $uni_url."<br/>";
//$url=http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=$uni_code;
//echo "URL=......................".$url;
//$mycurl=new CurlHandler("http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=40");
$mycurl=new CurlHandler($_POST[code]);

//$mycurl->readCookie();	
$post_data=array("depID"=>"25","hashMapParametersValue"=>"null");
$mycurl->postData($post_data);

$out=$mycurl->execute();
$mycurl->close();

// page content
//echo $out;

// Root object
$dom=str_get_html($out);
// Finding tables!
$tables = $dom->find('table[class=contentTable]');

//clear table
$table="course";
	mysql_query("TRUNCATE $table");
	
foreach ($tables as $table)
{	
	//$tr=$table->first_child()->children[2];
	$tr=$table->children[2];
	while($tr!=null){
	
	
	
	
	$td=$tr->children[3];
	$td2=$tr->children[1];
	$td3=$tr->children[7];
	$name=$tr->children[3]->children[0]->innertext;
	$profname=$tr->children[7]->innertext;
	$unit=$tr->children[2]->children[0]->innertext;
	$group=$tr->children[1]->children[0]->innertext;
	$number=$tr->children[0]->children[0]->innertext;
	
	//echo "***********";
	$cont=$tr->children[9];
	
	
	$datas = preg_split("/[\s,]+/", $cont);
	
	
	
	
	if($datas[3]=="و")
	{
		
		$day1=$datas[2];
		
		
		//check day....
		if($day1=="شنبه")
		{
			$day1=7;
			//echo "<br/>it is shanbe<br/>";
			//echo "<br/>".$day1."<br/>";
		}
		
		
		if($day1=="يکشنبه")
		{
		
			$day1=1;
			//echo "<br/>it is 1shanbe<br/>";
			//echo "<br/>".$day1."<br/>";
			
		}
			
		
		
		
		if($day1=="دوشنبه")
			$day1=2;
		
		if($day1=="سه شنبه")
			$day1=3;
		
		if($day1=="چهار شنبه")
			$day1=4;
		
		
			
		//end of check day
		
		$day2=$datas[4];
		
		//check day....
		if($day2=="شنبه")
			$day2=7;
		if($day2=="يکشنبه")
			$day2=1;
		
		if($day2=="دوشنبه")
			$day2=2;
		
		if($day2=="سه شنبه")
			$day2=3;
		
		if($day2=="چهار شنبه")
			$day2=4;
		
		
			
		//end of check day
		$stime=$datas[5];
		//checking stime
		$roundTime=preg_split("/[:,]+/", $stime);
		
		if($roundTime[1]==30)
		 
		 $stime=$roundTime[0]+.5;
		 
		 if($roundTime[1]==0)
		 {
		 
		 $stime=$roundTime[0]+0;
		 }
		 //end of checking stime
		 
		 //echo "yooooohooooo".$stime."<br/>";
		$ftime=$datas[7];
		//checking ftime
		$roundTimef=preg_split("/[:,]+/", $ftime);
		
		if($roundTimef[1]==30)
		 
		 $ftime=$roundTimef[0]+.5;
		 
		 if($roundTimef[1]==0)
		 {
		 
		 $ftime=$roundTimef[0]+0;
		 }
		 //end of checking ftime
		if($datas[4]=="سه")
		{
			//echo "kkkk<br/>";
			//$day2="سه شنبه";
			$day2=3;
			$stime=$datas[6];
			$roundTime=preg_split("/[:,]+/", $stime);
		//checking stime
		if($roundTime[1]==30)
		{
		 
		 $stime=$roundTime[0]+.5;
		 }
		 if($roundTime[1]==0)
		 {
		 
		 $stime=$roundTime[0]+0;
		 }
		 //endof checking stime
		 //echo "yooooohooooo".$stime."<br/>";
			$ftime=$datas[8];
			//checking ftime
		$roundTimef=preg_split("/[:,]+/", $ftime);
		
		if($roundTimef[1]==30)
		 
		 $ftime=$roundTimef[0]+.5;
		 
		 if($roundTimef[1]==0)
		 {
		 
		 $ftime=$roundTimef[0]+0;
		 }
		 //end of checking ftime
			
		}
		
		if($datas[4]=="چهار")
		{
			//echo "kkkk<br/>";
			//$day2="چهار شنبه";
			$day2=4;
			$stime=$datas[6];
			$roundTime=preg_split("/[:,]+/", $stime);
		//checking stime
		if($roundTime[1]==30)
		{
		 
		 $stime=$roundTime[0]+.5;
		 }
		 
		 if($roundTime[1]==0)
		 {
		 
		 $stime=$roundTime[0]+0;
		 }
		 //end of checking stime
		 //echo "yooooohooooo".$stime."<br/>";
			$ftime=$datas[8];
			//checking ftime
		$roundTimef=preg_split("/[:,]+/", $ftime);
		
		if($roundTimef[1]==30)
		 
		 $ftime=$roundTimef[0]+.5;
		 
		 if($roundTimef[1]==0)
		 {
		 
		 $ftime=$roundTimef[0]+0;
		 }
		 //end of checking ftime
			
		}
		
		
		echo "<option> $td-$td2-$td3</option><br/>";
		//echo "day1: $day1 day2: $day2 stime: $stime ftime: $ftime<br/>\n";
		//echo"________";
		
		
	}
	else 
	{
	
	$day1=$datas[2];
	//check day....
		if($day1=="شنبه")
			$day1=7;
		if($day1=="يکشنبه")
			$day1=1;
		
		if($day1=="دوشنبه")
			$day1=2;
		
		if($day1=="سه شنبه")
			$day1=3;
		
		if($day1=="چهار شنبه")
			$day1=4;
		
		
			
		//end of check day
	$stime=$datas[3];
	$roundTime=preg_split("/[:,]+/", $stime);
		//checking stime
		if($roundTime[1]==30)
		{
		 
		 $stime=$roundTime[0]+.5;
		 
		 }
		 if($roundTime[1]==0)
		 {
		 
		 $stime=$roundTime[0]+0;
		 }
		 //end of checking stime
		 //echo "yooooohooooo".$stime."<br/>";
	$ftime=$datas[5];
	//checking ftime
		$roundTimef=preg_split("/[:,]+/", $ftime);
		
		if($roundTimef[1]==30)
		 
		 $ftime=$roundTimef[0]+.5;
		 
		 if($roundTimef[1]==0)
		 {
		 
		 $ftime=$roundTimef[0]+0;
		 }
		 //end of checking ftime
	if($datas[2]=="چهار")
		{
			//echo "kkkk<br/>";
			//$day1="چهار شنبه";
			$day1=4;
			$stime=$datas[4];
			$roundTime=preg_split("/[:,]+/", $stime);
		//checking stime
		if($roundTime[1]==30)
		{
		 
		 $stime=$roundTime[0]+.5;
		 
		 }
		 if($roundTime[1]==0)
		 {
		 
		 $stime=$roundTime[0]+0;
		 }
		 //endof checking stime
		 //echo "yooooohooooo".$stime."<br/>";
			$ftime=$datas[6];
		//checking ftime
		$roundTimef=preg_split("/[:,]+/", $ftime);
		
		if($roundTimef[1]==30)
		 
		 $ftime=$roundTimef[0]+.5;
		 
		 if($roundTimef[1]==0)
		 {
		 
		 $ftime=$roundTimef[0]+0;
		 }
		 //end of checking ftime
			
			
		}
		
	if($datas[2]=="سه")
		{
			
			//$day1="سه شنبه";
			$day1=3;
			$stime=$datas[4];
			$roundTime=preg_split("/[:,]+/", $stime);
		//checking stime
		if($roundTime[1]==30)
		{
		 
		 $stime=$roundTime[0]+.5;
		 }
		 
		 if($roundTime[1]==0)
		 {
		 
		 $stime=$roundTime[0]+0;
		 }
		 //end of checking stime
		 //echo "yooooohooooo".$stime."<br/>";
			$ftime=$datas[6];
			//checking ftime
		$roundTimef=preg_split("/[:,]+/", $ftime);
		
		if($roundTimef[1]==30)
		 
		 $ftime=$roundTimef[0]+.5;
		 
		 if($roundTimef[1]==0)
		 {
		 
		 $ftime=$roundTimef[0]+0;
		 }
		 //end of checking ftime
			
			
		}
	$day2=NULL;
	
	echo "<option> $td-$td2-$td3</option><br/>";
	//echo "day1: $day1 day2: $day2 stime: $stime ftime: $ftime<br/>\n";
	//echo "_______";
	}
	
	
	
	//// inserting to DB
	
	mysql_select_db("termsaz", $con);
	$q = "SET NAMES 'utf8'";
         mysql_query($q) or die('Query failed: ' . mysql_error());
	
	$sql="INSERT INTO course (courseID, courseNumber, courseName, courseGroup, courseUnit, courseDay1, courseDay2, startTime, finishTime, profName) VALUES (NULL,'$number', '$name', '$group','$unit','$day1','$day2','$stime' , '$ftime','$profname')";
	
	if (!mysql_query($sql,$con))
	{
		die('Error: ' . mysql_error());
	}
	//echo "one record added"; 
	//end of inserting to DB
	
	
	
	
	
	
	
	
	
	//list($stime,$ta, $ftime) = split(" ", $data);
	//echo "stime: $stime ftime: $ftime<br/>\n";
	
	//echo "<option> $td</option>";
	
	
	
	
	
	
	
	
	
	$td=$td->next_sibling();
	
	/*$array=str_split($day);
	if($array[0]== "Ԣ)
	{
		echo "hfajd<br/>";
	}*/
	
	//echo $td=$tr->children[0];
	
	
	
	
	
		
				

	
	
		
	$tr=$tr->next_sibling();
	
	
	}
	
	//$tr=$tr->next_sibling();
}
// Parsing...
?>