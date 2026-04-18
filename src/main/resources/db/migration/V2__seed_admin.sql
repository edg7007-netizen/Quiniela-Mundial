INSERT INTO users (name, email, password, provider, role, created_at)
VALUES (
    'Admin',
    'admin@quinielamundial.com',
    '$2a$10$cM04QJOxmzRzWFZP7McOM.9rrxAeUg/z5wE/H.52wGEv87lQjX3uC',
    'LOCAL',
    'ROLE_ADMIN',
    NOW()
)
ON CONFLICT (email) DO NOTHING;
