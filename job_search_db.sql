CREATE DATABASE job_search_db;

USE job_search_db;

CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_title` varchar(100) NOT NULL,
  `company` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `url_job` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);


GRANT ALL PRIVILEGES ON quizdb.* TO 'student'@'localhost';
