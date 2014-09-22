<?php

require_once dirname(__FILE__).'/../lib/adminblogGeneratorConfiguration.class.php';
require_once dirname(__FILE__).'/../lib/adminblogGeneratorHelper.class.php';

/**
 * adminblog actions.
 *
 * @package    myblog
 * @subpackage adminblog
 * @author     Your name here
 * @version    SVN: $Id: actions.class.php 12474 2008-10-31 10:41:27Z fabien $
 */
class adminblogActions extends autoAdminblogActions
{
	function executeRandomArticle()
	{
		 $post=new Article();
		$arr = array  ('a','b', 'c', 'd','e','f','g','h','i','j','k','l','m',
		'n','o','p','q','r','s','t','u','v','w','x','y','z');
		for( $i=0;$i<6;$i=$i+1)
		{
		$index=rand(0,Count($arr));
		$title=$title.$arr[$index];
		}
		$post->setTitle($title);
		
		for( $i=0;$i<30;$i=$i+1)
		{
		$index=rand(0,Count($arr));
		$content=$content.$arr[$index];
		}
		$post->setContent($content);
		
		
		
		$post->save();
		
		$this->redirect('adminblog/index');
		
		
	}
}
