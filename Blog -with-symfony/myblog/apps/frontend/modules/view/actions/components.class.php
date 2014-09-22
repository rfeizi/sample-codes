<?php

    class viewComponents extends sfComponents{
        
        
     public function executeTagsList(){
     	$c=new Criteria();
     	         
        $this->posts=ArticlePeer::doSelect($c);
         
               
           
            
        }
        
    public function executeArchiveList(){
     	$c=new Criteria();
                       $c->addDescendingOrderByColumn('created_at');
                       $this->posts=ArticlePeer::doSelect($c);
         
               
           
            
        }
        
        
        
        
       
        
   
    }




?>