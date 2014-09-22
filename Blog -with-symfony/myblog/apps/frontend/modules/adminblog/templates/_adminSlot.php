<link rel="stylesheet" type="text/css" href="web/css/main.css" />


<?php slot('adminSlot' ) ?>
<div class="randomarticle"><?php echo link_to('add Random article','adminblog/randomArticle')?> </div>
<div class="randomarticle" style="top:70px"><?php echo link_to( 'add new article' , 'adminblog/new' ) ?></div>

<?php end_slot(); ?>