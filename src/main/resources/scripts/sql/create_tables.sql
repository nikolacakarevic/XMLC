CREATE TABLE xmlc.user (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  password VARCHAR(255) NOT NULL DEFAULT '',
  username VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY(id),
  UNIQUE (username)
)
ENGINE = InnoDB;


CREATE TABLE xmlc.user_roles (
  userId BIGINT UNSIGNED NOT NULL,
  role VARCHAR(255) NOT NULL DEFAULT ''
)
ENGINE = InnoDB;