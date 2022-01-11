
CREATE TABLE `salary` (
    `id` int NOT NULL AUTO_INCREMENT,
    `date` datetime DEFAULT NULL,
    `hourly_rate` double DEFAULT NULL,
    `operator_id` int DEFAULT NULL,
    `total_hours` double DEFAULT NULL,
    `total_salary` double DEFAULT NULL,
     PRIMARY KEY (`id`),
     KEY `FK93dffoefne62wxb5rqsedh98c` (`operator_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;