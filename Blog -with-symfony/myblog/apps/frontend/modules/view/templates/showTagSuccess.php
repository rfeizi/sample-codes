
<?php slot('adminSlot' ) ?>

<div >My name is Roghaye Feizy</div>



<?php end_slot(); ?>


<?php foreach ($posts as $post):?>
<?php include_partial("post",array("post"=>$post))?>
<br/><br/>
<?php endforeach;?>
