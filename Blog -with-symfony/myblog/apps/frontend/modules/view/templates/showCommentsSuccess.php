
<?php slot('adminSlot' ) ?>

<div >My name is Roghaye Feizy</div>



<?php end_slot(); ?>



<?php include_partial("post",array("post"=>$CArticle))?>
<?php foreach ($comments as $comment):?>
<?php include_partial("comment",array("comment"=>$comment))?>
<br/><br/>
<?php endforeach;?>


<?php echo form_tag('view/insertComment?article_id='.$CArticle->getId())?>
<div style="margin-left: 30px"><p>Your Comment</p></div>


<div style="margin-left: 30px">name: <input type="text" name='author'></input> </div>
<div><textarea style="height:100px;width:600px;margin-left: 30px"  name='content'></textarea></div>
<div style="margin-left: 30px"><input type ='submit' value='save'></input></div>
