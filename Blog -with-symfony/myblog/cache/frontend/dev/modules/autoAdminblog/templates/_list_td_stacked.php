<td colspan="5">
  <?php echo __('%%title%% - %%summary%% - %%nb_comments%% - %%tag%% - %%created_at%%', array('%%title%%' => $Article->getTitle(), '%%summary%%' => $Article->getSummary(), '%%nb_comments%%' => $Article->getNbComments(), '%%tag%%' => $Article->getTag(), '%%created_at%%' => false !== strtotime($Article->getCreatedAt()) ? format_date($Article->getCreatedAt(), "f") : '&nbsp;'), 'messages') ?>
</td>
