# Sticky Notes

It use the sticky notes to store the data in database.

Keep web application,which allows you to keep the information save in database.

Technology used:
Front End : Angular js, Bootstrap, Javascript, Html, CSS

Back End : JSP/Servlet and MySQL RDBMS

# KEEP Web Application Configuration

SQL Query to create databse in MYSQL:

DROP TABLE IF EXISTS `note`.`keep`;
CREATE TABLE  `note`.`keep` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idhtml` varchar(20) DEFAULT NULL,
  `texts` text,
  `parentid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

Change the username and password:

Change the database config in ConnectionUtil.java class 
