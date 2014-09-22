<?php

/**
 * Comment filter form base class.
 *
 * @package    myblog
 * @subpackage filter
 * @author     Your name here
 */
abstract class BaseCommentFormFilter extends BaseFormFilterPropel
{
  public function setup()
  {
    $this->setWidgets(array(
      'article_id' => new sfWidgetFormPropelChoice(array('model' => 'Article', 'add_empty' => true)),
      'author'     => new sfWidgetFormFilterInput(),
      'content'    => new sfWidgetFormFilterInput(),
      'created_at' => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
    ));

    $this->setValidators(array(
      'article_id' => new sfValidatorPropelChoice(array('required' => false, 'model' => 'Article', 'column' => 'id')),
      'author'     => new sfValidatorPass(array('required' => false)),
      'content'    => new sfValidatorPass(array('required' => false)),
      'created_at' => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDate(array('required' => false)))),
    ));

    $this->widgetSchema->setNameFormat('comment_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    parent::setup();
  }

  public function getModelName()
  {
    return 'Comment';
  }

  public function getFields()
  {
    return array(
      'id'         => 'Number',
      'article_id' => 'ForeignKey',
      'author'     => 'Text',
      'content'    => 'Text',
      'created_at' => 'Date',
    );
  }
}
