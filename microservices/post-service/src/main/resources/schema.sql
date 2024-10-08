CREATE TABLE IF NOT EXISTS `posts` (
  `id` UUID PRIMARY KEY,
  `user_id` UUID NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE
);
