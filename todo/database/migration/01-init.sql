CREATE TABLE IF NOT EXISTS todo.user
(
    `id`       BIGINT AUTO_INCREMENT NOT NULL,
    `name`     VARCHAR(500) NOT NULL,
    `username` VARCHAR(500) NOT NULL,
    `password` VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS todo.todo
(
    `id`       BIGINT AUTO_INCREMENT NOT NULL,
    `due_date` DATETIME NOT NULL,
    `password` VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);
