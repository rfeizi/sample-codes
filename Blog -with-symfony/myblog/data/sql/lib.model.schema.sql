
# This is a fix for InnoDB in MySQL >= 4.1.x
# It "suspends judgement" for fkey relationships until are tables are set.
SET FOREIGN_KEY_CHECKS = 0;

#-----------------------------------------------------------------------------
#-- blog_article
#-----------------------------------------------------------------------------

DROP TABLE IF EXISTS `blog_article`;


CREATE TABLE `blog_article`
(
	`id` INTEGER  NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255),
	`content` TEXT,
	`created_at` DATETIME,
	`tag` VARCHAR(255),
	PRIMARY KEY (`id`)
)Type=InnoDB;

#-----------------------------------------------------------------------------
#-- blog_comment
#-----------------------------------------------------------------------------

DROP TABLE IF EXISTS `blog_comment`;


CREATE TABLE `blog_comment`
(
	`id` INTEGER  NOT NULL AUTO_INCREMENT,
	`article_id` INTEGER,
	`author` VARCHAR(255),
	`content` TEXT,
	`created_at` DATETIME,
	PRIMARY KEY (`id`),
	INDEX `blog_comment_FI_1` (`article_id`),
	CONSTRAINT `blog_comment_FK_1`
		FOREIGN KEY (`article_id`)
		REFERENCES `blog_article` (`id`)
)Type=InnoDB;

# This restores the fkey checks, after having unset them earlier
SET FOREIGN_KEY_CHECKS = 1;
