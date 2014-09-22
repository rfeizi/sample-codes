<?php

require_once '../lib/CurlHandler.class.php';
require_once '../lib/simple_html_dom.php';

// Mathematics Department :: Find the other urls using firebug (depID)! 
//$mycurl=new CurlHandler("http://81.31.167.195:8081/edu/newLessonList/newLessonsList.jsp?depID=22");
$mycurl=new CurlHandler("file:///C:/Users/int/Desktop/hw2-web/list/newLessonsList.jsp.htm");

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
// echo tables[0];

	
foreach ($tables as $table)
{	//echo "salam";
	//echo $table;
	$tr=$table->first_child()->children[2];
	while($tr!=null){
	$td=$tr->children[0];
	while($td!=null){
	echo $td."<br/>\n";
		$td=$td->next_sibling();
				

	
	}
		//echo $tr."<br />\n";
		$tr=$tr->next_sibling();
	
	
	}
}
// Parsing...
?>