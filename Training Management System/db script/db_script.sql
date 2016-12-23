DROP SCHEMA IF EXISTS `tms_db` ;

CREATE SCHEMA IF NOT EXISTS `tms_db` DEFAULT CHARACTER SET UTF8 ;
USE `tms_db` ;
  
CREATE TABLE `users` (
    `id_user` INT NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(20) NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `role` ENUM('admin', 'teacher', 'listener') NOT NULL DEFAULT 'listener',
    PRIMARY KEY (`id_user`),
    UNIQUE (login)
)  ENGINE=INNODB;
  
CREATE TABLE `user_data` (
    `id_user_data` INT NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `middle_name` VARCHAR(45) NOT NULL,
    FOREIGN KEY (id_user_data)
        REFERENCES users (id_user)
        ON DELETE CASCADE 
        ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE `courses_list` (
    `id_course` INT NOT NULL AUTO_INCREMENT,
    `course_name` VARCHAR(100) NOT NULL,
    `description` TEXT NOT NULL,
    `status_course` ENUM('open', 'close') NOT NULL DEFAULT 'open',
    PRIMARY KEY (`id_course`),
    UNIQUE (course_name)
)  ENGINE=INNODB;

CREATE TABLE `groups` (
    `id_group` INT NOT NULL AUTO_INCREMENT,
    `id_teacher` INT NOT NULL,
    `id_course` INT NOT NULL,
    `status_group` ENUM('open', 'started', 'close') NOT NULL DEFAULT 'open',
    PRIMARY KEY (`id_group`),
    FOREIGN KEY (id_teacher)
        REFERENCES user_data (id_user_data)
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    FOREIGN KEY (id_course)
        REFERENCES courses_list (id_course)
        ON DELETE CASCADE 
        ON UPDATE CASCADE
)  ENGINE=INNODB;
  
CREATE TABLE IF NOT EXISTS `data_groups` (
	`id_data_group` INT NOT NULL AUTO_INCREMENT,
    `id_group` INT NOT NULL,
    `id_listener` INT NOT NULL,
    PRIMARY KEY (`id_data_group`),
    FOREIGN KEY (id_group)
        REFERENCES groups (id_group)
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    FOREIGN KEY (id_listener)
        REFERENCES user_data (id_user_data)
        ON DELETE CASCADE 
        ON UPDATE CASCADE
)  ENGINE=INNODB;

START TRANSACTION;
USE `tms_db`;
INSERT INTO `users` (`id_user`, `login`, `password`, `role`) VALUES (1, 'admin', 'admin', 'admin');
INSERT INTO `users` (`id_user`, `login`, `password`, `role`) VALUES (2, 'teacher1', 'teacher1', 'teacher');
INSERT INTO `users` (`id_user`, `login`, `password`, `role`) VALUES (3, 'teacher2', 'teacher2', 'teacher');
INSERT INTO `users` (`id_user`, `login`, `password`, `role`) VALUES (4, 'teacher3', 'teacher3', 'teacher');
INSERT INTO `users` (`id_user`, `login`, `password`, `role`) VALUES (5, 'listener1', 'listener1', 'listener');
INSERT INTO `users` (`id_user`, `login`, `password`, `role`) VALUES (6, 'listener2', 'listener2', 'listener');
INSERT INTO `users` (`id_user`, `login`, `password`, `role`) VALUES (7, 'listener3', 'listener3', 'listener');
COMMIT;

START TRANSACTION;
USE `tms_db`;
INSERT INTO `user_data` (`id_user_data`, `last_name`, `first_name`, `middle_name`) VALUES (1, 'Name admin', 'First name admin', 'Middle name admin');
INSERT INTO `user_data` (`id_user_data`, `last_name`, `first_name`, `middle_name`) VALUES (2, 'Name teacher1', 'First name teacher1', 'Middle name teacher1');
INSERT INTO `user_data` (`id_user_data`, `last_name`, `first_name`, `middle_name`) VALUES (3, 'Name teacher2', 'First name teacher2', 'Middle name teacher2');
INSERT INTO `user_data` (`id_user_data`, `last_name`, `first_name`, `middle_name`) VALUES (4, 'Name teacher3', 'First name teacher3', 'Middle name teacher3');
INSERT INTO `user_data` (`id_user_data`, `last_name`, `first_name`, `middle_name`) VALUES (5, 'Name listener1', 'First name listener1', 'Middle name listener1');
INSERT INTO `user_data` (`id_user_data`, `last_name`, `first_name`, `middle_name`) VALUES (6, 'Name listener2', 'First name listener2', 'Middle name listener2');
INSERT INTO `user_data` (`id_user_data`, `last_name`, `first_name`, `middle_name`) VALUES (7, 'Name listener3', 'First name listener3', 'Middle name listener3');
COMMIT;

START TRANSACTION;
USE `tms_db`;
INSERT INTO `courses_list` (`id_course`, `course_name`, `description`, `status_course`) VALUES (1, 'Java SE courses', 'Description Java SE courses', 'open');
INSERT INTO `courses_list` (`id_course`, `course_name`, `description`, `status_course`) VALUES (2, 'Java EE courses', 'Description Java EE courses', 'open');
INSERT INTO `courses_list` (`id_course`, `course_name`, `description`, `status_course`) VALUES (3, 'C++ courses', 'Description C++ courses', 'open');
COMMIT;

START TRANSACTION;
USE `tms_db`;
INSERT INTO `groups` (`id_group`, `id_teacher`, `id_course`, `status_group`) VALUES (1, 2, 1, 'open');
INSERT INTO `groups` (`id_group`, `id_teacher`, `id_course`, `status_group`) VALUES (2, 3, 2, 'open');
INSERT INTO `groups` (`id_group`, `id_teacher`, `id_course`, `status_group`) VALUES (3, 4, 3, 'open');
COMMIT;

START TRANSACTION;
USE `tms_db`;
INSERT INTO `data_groups` (`id_group`, `id_listener`) VALUES (1, 5);
INSERT INTO `data_groups` (`id_group`, `id_listener`) VALUES (2, 6);
INSERT INTO `data_groups` (`id_group`, `id_listener`) VALUES (3, 7);
COMMIT;