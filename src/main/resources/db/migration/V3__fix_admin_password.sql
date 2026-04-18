-- Fix admin password hash to match documented password 'Admin123!'
UPDATE users
SET password = '$2a$10$cM04QJOxmzRzWFZP7McOM.9rrxAeUg/z5wE/H.52wGEv87lQjX3uC'
WHERE email = 'admin@quinielamundial.com';
