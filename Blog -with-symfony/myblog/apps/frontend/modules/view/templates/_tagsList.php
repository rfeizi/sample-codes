
<?php $tagsArray = array();?>
<?php $counterArray = array();?>
<?php $flag=false;?>
<?php foreach($posts as $post):

//echo "size: ".sizeof($tagsArray);
   for( $i=0;$i<sizeof($tagsArray);$i++){
      //echo "tagsarray[i]:".$tagsArray[$i]."<br/>";
        if($post->getTag()== $tagsArray[$i]){
                      // echo " if ";
           $counterArray[$i]++;
           $flag=true;
            break;
       }
   }
   if(!$flag & $post->getTag()!=NULL){
       $counterArray[sizeof($tagsArray)]=1;;
       $tagsArray[]=$post->getTag();
       }
       ?>
      <?php endforeach;?>
     
 <?php  
for( $i=0;$i<sizeof($tagsArray);$i++){
     echo link_to($tagsArray[$i].'('.$counterArray[$i].')', 'view/showTag?tag='.$tagsArray[$i])."<br/>";
       }
?>


