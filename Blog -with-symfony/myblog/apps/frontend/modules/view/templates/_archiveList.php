<?php $size= sizeof($posts);
$year="y";
$month="m";
$monthName;
if($size!=0){
$firstPostYear=$posts[$size-1]->getCreatedAt($year);
$lastPostYear=$posts[0]->getCreatedAt($year);
}
else
{
$firstPostYear=NULL;
}
?>

<html><ul>
<?php
if($firstPostYear!=NULL ){
for($i=$firstPostYear ; $i<=$lastPostYear;$i++){

$monthsPostArray = array(0,0,0,0,0,0,0,0,0,0,0,0,0,0);

foreach($posts as $post):

if( $post->getCreatedAt($year)==$i){
for( $k=1;$k<=12;$k++){

if($post->getCreatedAt($month)== $k ){

$monthsPostArray[$k]++;
break;
}
}

}
endforeach;
echo "<li> 20".$i."</li>";
for($j=1 ; $j<=12;$j++){
if ($j==1){
$monthName="January";
}
if ($j==1){
$monthName="January";
}elseif ($j==2){
$monthName="February";
}elseif ($j==3){
$monthName="March";
}elseif ($j==4){
$monthName="April";
}elseif ($j==5){
$monthName="May";
}elseif ($j==6){
$monthName="June";
}elseif ($j==7){
$monthName="July";
}elseif ($j==8){
$monthName="August";
}elseif ($j==9){
$monthName="September";
}elseif ($j==10){
$monthName="October";
}elseif ($j==11){
$monthName="November";
}
elseif ($j==12){
$monthName="December";
}
if($monthsPostArray[$j]>0){
echo link_to($monthName."(".$monthsPostArray[$j].")",'view/showArchive?year='.$i.'&month='.$j)."<br/>";}
}


}
}
?></ul></html>