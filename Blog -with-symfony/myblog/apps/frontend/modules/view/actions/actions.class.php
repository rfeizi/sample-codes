<?php

/**
 * view actions.
 *
 * @package    myblog
 * @subpackage view
 * @author     Your name here
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class viewActions extends sfActions
{
 /**
  * Executes index action
  *
  * @param sfRequest $request A request object
  */
  public function executeIndex(sfWebRequest $request)
  {
//    $this->forward('default', 'module');
	//$this->tmp="Salam";
	$c=new Criteria();
            $c->addDescendingOrderByColumn('created_at');
            $c->setLimit(5);
            $this->posts=ArticlePeer::doSelect($c);
                $this->tmp2="ssssssssssssssss2";
  }
  
  public function executeShowComments(sfWebRequest $request)
  {
  		
  		$article_id=$request->getParameter('id');
  		$this->comments=ArticlePeer::getComments($article_id);
  		$this->CArticle=ArticlePeer::getArticle($article_id);
  }
  
  function executeInsertComment(sfWebRequest $request)
  {
  	
  	
  	$name=$request->getParameter('author');
  	$content=$request->getParameter('content');
  	$article_id=$request->getParameter('article_id');
 
  	
  	
  	$comment=new Comment();
  	$comment->setAuthor($name);
  	$comment->setContent($content);
  	$comment->setArticleId($article_id);
  	
  	$comment->save();
  	echo 'ok';
  	$this->redirect('view/showComments?id='.$article_id);
  	//$this->redirect("view/ShowComments",$comment);  	
  }
  
  function executeShowTag(sfWebRequest $request)
  {
  	
   
  $c=new Criteria();
          $tag=$request->getParameter('tag');
      $c->add(ArticlePeer::TAG, $tag);
     
    $this->posts=ArticlePeer::doSelect($c);
       
}  
 
public function executeShowArchive(sfWebRequest $request)
{


$c=new Criteria();
$year=$request->getParameter('year');
$month=$request->getParameter('month');
$nextMonth=mktime( 0,0,0,$month+1,0,$year);
$thisMonth=mktime( 0,0,0,$month,0,$year);
$c->add(ArticlePeer::CREATED_AT,$nextMonth,Criteria::LESS_THAN);
$c->addAnd(ArticlePeer::CREATED_AT,$thisMonth,Criteria::GREATER_THAN);

// $c->addAnd(ArticlePeer::CREATED_AT,$thisMonth,'GREATERTHAN');



$this->posts=ArticlePeer::doSelect($c);

}
  
  	
  
  
  
}
