



<div>
  
  <ul>
  
    
    
     <div class="title" style="border:solid gray 1px;background-color: #99CCFF;width:600px;height:30px;top:140px"> <?php echo $post->getTitle() ?>
     </div>
      
      <div class="content" style="border:solid gray 1px;width:600px;height:90px;overflow: scroll;"><pre><?php echo $post->getContent() ?></pre></div>
      <div class="time" style="border:solid gray 1px;width:600px;height:40px;"><?php echo $post->getCreatedAt()."       tag:  ".$post->getTag()    ?>
     </div>
     
     <?php echo link_to("comments(".$post->countComments().")",'view/showComments?id='.$post->getId()) ?>
      <div style=width:300px;height:40px;> </div>
     
       
       
    
  
  </ul>
</div>

