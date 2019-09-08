CREATE TABLE `event` (
    id INT(8) NOT NULL AUTO_INCREMENT,
    start_time INT(8) NOT NULL,
    end_time INT(8) NOT NULL,
    description MEDIUMTEXT NOT NULL,
    PRIMARY KEY(id)
)