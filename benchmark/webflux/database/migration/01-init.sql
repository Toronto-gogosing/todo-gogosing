CREATE TABLE benchmark.user (
   id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(500) NOT NULL,
   PRIMARY KEY(id)
);

INSERT INTO benchmark.user (`name`) VALUES ("Jack");
INSERT INTO benchmark.user (`name`) VALUES ("John");
INSERT INTO benchmark.user (`name`) VALUES ("Bradley");
