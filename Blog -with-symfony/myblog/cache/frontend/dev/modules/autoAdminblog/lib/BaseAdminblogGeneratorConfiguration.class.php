<?php

/**
 * adminblog module configuration.
 *
 * @package    ##PROJECT_NAME##
 * @subpackage adminblog
 * @author     ##AUTHOR_NAME##
 * @version    SVN: $Id: configuration.php 24171 2009-11-19 16:37:50Z Kris.Wallsmith $
 */
abstract class BaseAdminblogGeneratorConfiguration extends sfModelGeneratorConfiguration
{
  public function getActionsDefault()
  {
    return array();
  }

  public function getFormActions()
  {
    return array(  '_delete' => NULL,  '_list' => NULL,  '_save' => NULL,  '_save_and_add' => NULL,);
  }

  public function getNewActions()
  {
    return array();
  }

  public function getEditActions()
  {
    return array();
  }

  public function getListObjectActions()
  {
    return array(  '_edit' => NULL,  '_delete' => NULL,);
  }

  public function getListActions()
  {
    return array(  '_new' => NULL,);
  }

  public function getListBatchActions()
  {
    return array(  '_delete' => NULL,);
  }

  public function getListParams()
  {
    return '%%title%% - %%summary%% - %%nb_comments%% - %%tag%% - %%created_at%%';
  }

  public function getListLayout()
  {
    return 'tabular';
  }

  public function getListTitle()
  {
    return 'Adminblog List';
  }

  public function getEditTitle()
  {
    return 'Edit Adminblog';
  }

  public function getNewTitle()
  {
    return 'New Adminblog';
  }

  public function getFilterDisplay()
  {
    return array(  0 => 'title',  1 => 'content',  2 => 'created_at',  3 => 'tag',  4 => '_adminSlot',);
  }

  public function getFormDisplay()
  {
    return array(  0 => 'title',  1 => 'content',  2 => 'tag',  3 => '_adminSlot',);
  }

  public function getEditDisplay()
  {
    return array(  0 => 'title',  1 => 'content',  2 => 'tag',  3 => '_adminSlot',);
  }

  public function getNewDisplay()
  {
    return array(  0 => 'title',  1 => 'content',  2 => 'tag',  3 => '_adminSlot',);
  }

  public function getListDisplay()
  {
    return array(  0 => 'title',  1 => 'summary',  2 => 'nb_comments',  3 => 'tag',  4 => 'created_at',);
  }

  public function getFieldsDefault()
  {
    return array(
      'id' => array(  'is_link' => true,  'is_real' => true,  'is_partial' => false,  'is_component' => false,  'type' => 'Text',),
      'title' => array(  'is_link' => false,  'is_real' => true,  'is_partial' => false,  'is_component' => false,  'type' => 'Text',),
      'content' => array(  'is_link' => false,  'is_real' => true,  'is_partial' => false,  'is_component' => false,  'type' => 'Text',),
      'created_at' => array(  'is_link' => false,  'is_real' => true,  'is_partial' => false,  'is_component' => false,  'type' => 'Date',),
      'tag' => array(  'is_link' => false,  'is_real' => true,  'is_partial' => false,  'is_component' => false,  'type' => 'Text',),
    );
  }

  public function getFieldsList()
  {
    return array(
      'id' => array(),
      'title' => array(),
      'content' => array(  'params' => 'size=10',),
      'created_at' => array(),
      'tag' => array(),
    );
  }

  public function getFieldsFilter()
  {
    return array(
      'id' => array(),
      'title' => array(),
      'content' => array(),
      'created_at' => array(),
      'tag' => array(),
    );
  }

  public function getFieldsForm()
  {
    return array(
      'id' => array(),
      'title' => array(),
      'content' => array(),
      'created_at' => array(),
      'tag' => array(),
    );
  }

  public function getFieldsEdit()
  {
    return array(
      'id' => array(),
      'title' => array(),
      'content' => array(),
      'created_at' => array(),
      'tag' => array(),
    );
  }

  public function getFieldsNew()
  {
    return array(
      'id' => array(),
      'title' => array(),
      'content' => array(),
      'created_at' => array(),
      'tag' => array(),
    );
  }


  /**
   * Gets the form class name.
   *
   * @return string The form class name
   */
  public function getFormClass()
  {
    return 'ArticleForm';
  }

  public function hasFilterForm()
  {
    return true;
  }

  /**
   * Gets the filter form class name
   *
   * @return string The filter form class name associated with this generator
   */
  public function getFilterFormClass()
  {
    return 'ArticleFormFilter';
  }

  public function getPagerClass()
  {
    return 'sfPropelPager';
  }

  public function getPagerMaxPerPage()
  {
    return 20;
  }

  public function getDefaultSort()
  {
    return array(null, null);
  }

  public function getPeerMethod()
  {
    return 'doSelect';
  }

  public function getPeerCountMethod()
  {
    return 'doCount';
  }
}
