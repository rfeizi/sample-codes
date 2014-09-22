<?php

/**
 * adminblog module configuration.
 *
 * @package    ##PROJECT_NAME##
 * @subpackage adminblog
 * @author     ##AUTHOR_NAME##
 */
abstract class BaseAdminblogGeneratorHelper extends sfModelGeneratorHelper
{
  public function getUrlForAction($action)
  {
    return 'list' == $action ? 'article' : 'article_'.$action;
  }
}
