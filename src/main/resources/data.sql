-- =========================================
-- PERSONAL INFO
-- =========================================
INSERT INTO personal_info
(first_name, last_name, title, profile_description, profile_image_url, years_of_experience, email, phone, linkedin_url, github_url)
VALUES
('Juan David', 'Colorado Montenegro', 'Software Developer',
 'Desarrollador de software con experiencia en desarrollo backend con Java y Spring Boot, así como en desarrollo frontend con Angular. Experiencia en diseño de APIs, manejo de bases de datos SQL y desarrollo de aplicaciones web empresariales. Apasionado por aprender nuevas tecnologías y construir soluciones eficientes.',
 'img/portafolio.jpeg', 2, 'juandavidcolorado123@gmail.com', '+573227340091', 'https://www.linkedin.com/in/juan-david-colorado-montenegro-210a33313/', 'https://github.com/JuanColorado123');

-- =========================================
-- SKILLS
-- =========================================
INSERT INTO skills (name, level_percentage, icon_class, personal_info_id) VALUES
 ('Java', 90, '/img/logos/java.png', 1),
 ('Spring Boot', 85, '/img/logos/springBoot.png', 1),
 ('Angular', 80, '/img/logos/angular.png', 1),
 ('SQL Server', 85, '/img/logos/servidor-sql.png', 1),
 ('Docker', 70, '/img/logos/docker.png', 1),
 ('HTML', 90, '/img/logos/html-5.png', 1),
 ('CSS', 85, '/img/logos/css-3.png', 1),
 ('JavaScript', 80, '/img/logos/js.png', 1),
 ('Git', 85, '/img/logos/github.png', 1);

-- =========================================
-- EDUCATION
-- =========================================
INSERT INTO educations (degree, institution, start_date, end_date, description, personal_info_id) VALUES
('Ingeniería de Software', 'Fundación Universitaria Compensar (UCompensar)', '2023-02-15', NULL, 'Formación en desarrollo de software, bases de datos, arquitectura de software y metodologías ágiles.', 1),
('Curso de Angular', 'Udemy', '2024-01-10', '2024-04-10', 'Curso práctico de Angular para desarrollo de aplicaciones web modernas.', 1);

-- =========================================
-- EXPERIENCE
-- =========================================
INSERT INTO experiences (job_title, company_name, start_date, end_date, description, personal_info_id) VALUES
('Java Developer', 'Cobis Topaz', '2025-05-01', NULL,
 'Desarrollo y mantenimiento de aplicaciones empresariales utilizando Java y Node.js. Implementación de nuevas funcionalidades, optimización de código y resolución de incidencias dentro de sistemas financieros.', 1),

('Software Developer', 'SOAINT', '2024-09-01', '2025-05-01',
 'Desarrollo y mantenimiento de un sistema de gestión documental. Resolución de errores reportados por usuarios, depuración de código para identificar problemas y desarrollo de nuevas funcionalidades utilizando Angular, Java y SQL Server.', 1);

-- =========================================
-- PROJECTS
-- =========================================
INSERT INTO projects (title, description, image_url, project_url, personal_info_id) VALUES
('Portafolio Web Personal', 'Aplicación web desarrollada con Spring Boot, Thymeleaf y Bootstrap para mostrar experiencia, proyectos y habilidades.', 'img/projects/project2.jpg', 'https://github.com/jdcolorado/portfolio', 1),
('Sistema de Gestión de Productos', 'Aplicación backend con Spring Boot y base de datos SQL para gestionar productos, ventas y estadísticas.', 'img/projects/project1.jpg', 'https://github.com/jdcolorado/product-system', 1);

-- =========================================
-- USERS
-- =========================================

INSERT INTO users (username, password, enabled) VALUES ( 'admin', '$2a$10$T/Pl894OvYtfkJs8IY.wKeFC.z6./phGL6k3JVPvD1I0LMGCKGFXm', TRUE);