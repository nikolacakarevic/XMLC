DROP TABLE IF EXISTS xmlc.user;
CREATE TABLE  xmlc.user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_jreodf78a7pl5qidfh43axdfb (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS xmlc.userroles;
CREATE TABLE  xmlc.userroles (
  userId bigint(20) NOT NULL,
  role varchar(255) DEFAULT NULL,
  KEY FK_qgwk7huht3b908k7du8hiry7r (userId),
  CONSTRAINT FK_qgwk7huht3b908k7du8hiry7r FOREIGN KEY (userId) REFERENCES user (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;