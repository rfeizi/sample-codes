<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    
	<link rel="stylesheet" type="text/css" href="../../../web/css/main.css" />
    
    <?php include_http_metas() ?>
    <?php include_metas() ?>
    <?php include_title() ?>
    <link rel="shortcut icon" href="/favicon.ico" />
    <?php include_stylesheets() ?>
    <?php include_javascripts() ?>
  </head>
  <body>
  
  <div class="tab" ><?php echo link_to('admin', 'adminblog/index') ?></div>
  <div class="tab" style="left:70px"  ><?php echo link_to('view', 'view/index') ?></div> 
  

   <div class="hole"> <?php echo $sf_content ?></div>
    

    
  <div  class="tags" ><?php include_component('view','tagsList')?></div>
  <div style="top:270px" class="tags"><?php include_component('view','archiveList')?></div>
  <div  class="slot"><?php include_slot('adminSlot') ?></div>
  
  
    
  
  </body>
</html>
