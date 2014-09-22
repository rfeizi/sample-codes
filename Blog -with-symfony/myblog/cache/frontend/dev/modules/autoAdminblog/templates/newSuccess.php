<?php use_helper('I18N', 'Date') ?>
<?php include_partial('adminblog/assets') ?>

<div id="sf_admin_container">
  <h1><?php echo __('New Adminblog', array(), 'messages') ?></h1>

  <?php include_partial('adminblog/flashes') ?>

  <div id="sf_admin_header">
    <?php include_partial('adminblog/form_header', array('Article' => $Article, 'form' => $form, 'configuration' => $configuration)) ?>
  </div>

  <div id="sf_admin_content">
    <?php include_partial('adminblog/form', array('Article' => $Article, 'form' => $form, 'configuration' => $configuration, 'helper' => $helper)) ?>
  </div>

  <div id="sf_admin_footer">
    <?php include_partial('adminblog/form_footer', array('Article' => $Article, 'form' => $form, 'configuration' => $configuration)) ?>
  </div>
</div>
