<td class="sf_admin_text sf_admin_list_td_title">
  <?php echo $Article->getTitle() ?>
</td>
<td class="sf_admin_text sf_admin_list_td_summary">
  <?php echo $Article->getSummary() ?>
</td>
<td class="sf_admin_text sf_admin_list_td_nb_comments">
  <?php echo $Article->getNbComments() ?>
</td>
<td class="sf_admin_text sf_admin_list_td_tag">
  <?php echo $Article->getTag() ?>
</td>
<td class="sf_admin_date sf_admin_list_td_created_at">
  <?php echo false !== strtotime($Article->getCreatedAt()) ? format_date($Article->getCreatedAt(), "f") : '&nbsp;' ?>
</td>
