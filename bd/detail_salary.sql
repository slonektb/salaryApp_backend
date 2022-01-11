
CREATE TABLE `detail_salary` (
    `id` int NOT NULL AUTO_INCREMENT,
    `begin` double DEFAULT NULL,
    `end` double DEFAULT NULL,
    `salary_id` int NOT NULL,
    `total` double DEFAULT NULL,
     PRIMARY KEY (`id`),
     KEY `FK4x2418rylyv19wg3bledoc9lq` (`salary_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;