INSERT INTO users (name, email, password, provider, role, created_at)
VALUES (
    'Admin',
    'admin@quinielamundial.com',
    '$2a$10$h7mE7A2l5JupwZZn7BGSgOwrlK9NV5mMsTLVW2fQ2YVqu6I5fQXb2',
    'LOCAL',
    'ROLE_ADMIN',
    NOW()
)
ON CONFLICT (email) DO NOTHING;
