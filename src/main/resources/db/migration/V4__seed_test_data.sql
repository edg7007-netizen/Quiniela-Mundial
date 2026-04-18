-- ============================================================
-- V4: Seed test data for manual QA
-- FIFA World Cup 2026 (USA / Mexico / Canada)
-- ============================================================

-- ----------------------------------------------------------
-- 1. TEAMS – All 48 qualified nations (12 groups of 4)
-- ----------------------------------------------------------
INSERT INTO teams (name, fifa_code, group_name, flag_url) VALUES
-- Group A
('United States',  'USA', 'A', 'https://flagcdn.com/w80/us.png'),
('Mexico',         'MEX', 'A', 'https://flagcdn.com/w80/mx.png'),
('Canada',         'CAN', 'A', 'https://flagcdn.com/w80/ca.png'),
('Jamaica',        'JAM', 'A', 'https://flagcdn.com/w80/jm.png'),
-- Group B
('Brazil',         'BRA', 'B', 'https://flagcdn.com/w80/br.png'),
('Colombia',       'COL', 'B', 'https://flagcdn.com/w80/co.png'),
('Paraguay',       'PAR', 'B', 'https://flagcdn.com/w80/py.png'),
('New Zealand',    'NZL', 'B', 'https://flagcdn.com/w80/nz.png'),
-- Group C
('Argentina',      'ARG', 'C', 'https://flagcdn.com/w80/ar.png'),
('Peru',           'PER', 'C', 'https://flagcdn.com/w80/pe.png'),
('Chile',          'CHI', 'C', 'https://flagcdn.com/w80/cl.png'),
('Bolivia',        'BOL', 'C', 'https://flagcdn.com/w80/bo.png'),
-- Group D
('Germany',        'GER', 'D', 'https://flagcdn.com/w80/de.png'),
('Japan',          'JPN', 'D', 'https://flagcdn.com/w80/jp.png'),
('South Korea',    'KOR', 'D', 'https://flagcdn.com/w80/kr.png'),
('Indonesia',      'IDN', 'D', 'https://flagcdn.com/w80/id.png'),
-- Group E
('France',         'FRA', 'E', 'https://flagcdn.com/w80/fr.png'),
('Australia',      'AUS', 'E', 'https://flagcdn.com/w80/au.png'),
('Saudi Arabia',   'KSA', 'E', 'https://flagcdn.com/w80/sa.png'),
('Denmark',        'DEN', 'E', 'https://flagcdn.com/w80/dk.png'),
-- Group F
('England',        'ENG', 'F', 'https://flagcdn.com/w80/gb-eng.png'),
('Netherlands',    'NED', 'F', 'https://flagcdn.com/w80/nl.png'),
('Wales',          'WAL', 'F', 'https://flagcdn.com/w80/gb-wls.png'),
('Iran',           'IRN', 'F', 'https://flagcdn.com/w80/ir.png'),
-- Group G
('Spain',          'ESP', 'G', 'https://flagcdn.com/w80/es.png'),
('Portugal',       'POR', 'G', 'https://flagcdn.com/w80/pt.png'),
('Morocco',        'MAR', 'G', 'https://flagcdn.com/w80/ma.png'),
('Uruguay',        'URU', 'G', 'https://flagcdn.com/w80/uy.png'),
-- Group H
('Italy',          'ITA', 'H', 'https://flagcdn.com/w80/it.png'),
('Senegal',        'SEN', 'H', 'https://flagcdn.com/w80/sn.png'),
('Ecuador',        'ECU', 'H', 'https://flagcdn.com/w80/ec.png'),
('Tunisia',        'TUN', 'H', 'https://flagcdn.com/w80/tn.png'),
-- Group I
('Belgium',        'BEL', 'I', 'https://flagcdn.com/w80/be.png'),
('Croatia',        'CRO', 'I', 'https://flagcdn.com/w80/hr.png'),
('Serbia',         'SRB', 'I', 'https://flagcdn.com/w80/rs.png'),
('Cameroon',       'CMR', 'I', 'https://flagcdn.com/w80/cm.png'),
-- Group J
('Nigeria',        'NGA', 'J', 'https://flagcdn.com/w80/ng.png'),
('Egypt',          'EGY', 'J', 'https://flagcdn.com/w80/eg.png'),
('Ghana',          'GHA', 'J', 'https://flagcdn.com/w80/gh.png'),
('Costa Rica',     'CRC', 'J', 'https://flagcdn.com/w80/cr.png'),
-- Group K
('Switzerland',    'SUI', 'K', 'https://flagcdn.com/w80/ch.png'),
('Poland',         'POL', 'K', 'https://flagcdn.com/w80/pl.png'),
('Sweden',         'SWE', 'K', 'https://flagcdn.com/w80/se.png'),
('Honduras',       'HON', 'K', 'https://flagcdn.com/w80/hn.png'),
-- Group L
('Austria',        'AUT', 'L', 'https://flagcdn.com/w80/at.png'),
('Ukraine',        'UKR', 'L', 'https://flagcdn.com/w80/ua.png'),
('Panama',         'PAN', 'L', 'https://flagcdn.com/w80/pa.png'),
('Trinidad and Tobago', 'TRI', 'L', 'https://flagcdn.com/w80/tt.png')
ON CONFLICT (fifa_code) DO NOTHING;

-- ----------------------------------------------------------
-- 2. TEST USERS (password for all: Admin123!)
-- BCrypt hash of 'Admin123!'
-- ----------------------------------------------------------
INSERT INTO users (name, email, password, provider, role, created_at) VALUES
('Carlos López',   'carlos@test.com',  '$2a$10$cM04QJOxmzRzWFZP7McOM.9rrxAeUg/z5wE/H.52wGEv87lQjX3uC', 'LOCAL', 'ROLE_USER', NOW() - INTERVAL '5 days'),
('María García',   'maria@test.com',   '$2a$10$cM04QJOxmzRzWFZP7McOM.9rrxAeUg/z5wE/H.52wGEv87lQjX3uC', 'LOCAL', 'ROLE_USER', NOW() - INTERVAL '4 days'),
('Pedro Martínez', 'pedro@test.com',   '$2a$10$cM04QJOxmzRzWFZP7McOM.9rrxAeUg/z5wE/H.52wGEv87lQjX3uC', 'LOCAL', 'ROLE_USER', NOW() - INTERVAL '3 days'),
('Ana Rodríguez',  'ana@test.com',     '$2a$10$cM04QJOxmzRzWFZP7McOM.9rrxAeUg/z5wE/H.52wGEv87lQjX3uC', 'LOCAL', 'ROLE_USER', NOW() - INTERVAL '2 days'),
('Luis Hernández', 'luis@test.com',    '$2a$10$cM04QJOxmzRzWFZP7McOM.9rrxAeUg/z5wE/H.52wGEv87lQjX3uC', 'LOCAL', 'ROLE_USER', NOW() - INTERVAL '1 day')
ON CONFLICT (email) DO NOTHING;

-- ----------------------------------------------------------
-- 3. MATCHES
-- 3a. FINISHED matches (past dates, with scores) — for leaderboard
-- 3b. UPCOMING matches (future dates)            — for predictions
-- ----------------------------------------------------------

-- ---- 3a. FINISHED GROUP STAGE MATCHES ---
-- Group A – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'USA'),
    (SELECT id FROM teams WHERE fifa_code = 'JAM'),
    3, 0, 'GROUP_STAGE', 'MetLife Stadium, New Jersey',
    NOW() - INTERVAL '10 days', 'FINISHED'
);
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'MEX'),
    (SELECT id FROM teams WHERE fifa_code = 'CAN'),
    2, 1, 'GROUP_STAGE', 'Estadio Azteca, Mexico City',
    NOW() - INTERVAL '10 days', 'FINISHED'
);

-- Group B – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'BRA'),
    (SELECT id FROM teams WHERE fifa_code = 'NZL'),
    4, 0, 'GROUP_STAGE', 'Rose Bowl, Los Angeles',
    NOW() - INTERVAL '9 days', 'FINISHED'
);
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'COL'),
    (SELECT id FROM teams WHERE fifa_code = 'PAR'),
    1, 1, 'GROUP_STAGE', 'AT&T Stadium, Dallas',
    NOW() - INTERVAL '9 days', 'FINISHED'
);

-- Group C – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'ARG'),
    (SELECT id FROM teams WHERE fifa_code = 'BOL'),
    3, 1, 'GROUP_STAGE', 'Hard Rock Stadium, Miami',
    NOW() - INTERVAL '8 days', 'FINISHED'
);
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'PER'),
    (SELECT id FROM teams WHERE fifa_code = 'CHI'),
    0, 0, 'GROUP_STAGE', 'Lumen Field, Seattle',
    NOW() - INTERVAL '8 days', 'FINISHED'
);

-- Group D – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'GER'),
    (SELECT id FROM teams WHERE fifa_code = 'IDN'),
    5, 1, 'GROUP_STAGE', 'Lincoln Financial Field, Philadelphia',
    NOW() - INTERVAL '7 days', 'FINISHED'
);
INSERT INTO matches (home_team_id, away_team_id, home_score, away_score, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'JPN'),
    (SELECT id FROM teams WHERE fifa_code = 'KOR'),
    2, 2, 'GROUP_STAGE', 'BMO Field, Toronto',
    NOW() - INTERVAL '7 days', 'FINISHED'
);

-- ---- 3b. UPCOMING GROUP STAGE MATCHES ---
-- Group A – Matchday 2
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'USA'),
    (SELECT id FROM teams WHERE fifa_code = 'MEX'),
    'GROUP_STAGE', 'MetLife Stadium, New Jersey',
    NOW() + INTERVAL '2 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'CAN'),
    (SELECT id FROM teams WHERE fifa_code = 'JAM'),
    'GROUP_STAGE', 'BC Place, Vancouver',
    NOW() + INTERVAL '2 days', 'SCHEDULED'
);

-- Group B – Matchday 2
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'BRA'),
    (SELECT id FROM teams WHERE fifa_code = 'COL'),
    'GROUP_STAGE', 'Rose Bowl, Los Angeles',
    NOW() + INTERVAL '3 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'PAR'),
    (SELECT id FROM teams WHERE fifa_code = 'NZL'),
    'GROUP_STAGE', 'AT&T Stadium, Dallas',
    NOW() + INTERVAL '3 days', 'SCHEDULED'
);

-- Group C – Matchday 2
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'ARG'),
    (SELECT id FROM teams WHERE fifa_code = 'CHI'),
    'GROUP_STAGE', 'Hard Rock Stadium, Miami',
    NOW() + INTERVAL '4 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'BOL'),
    (SELECT id FROM teams WHERE fifa_code = 'PER'),
    'GROUP_STAGE', 'Lumen Field, Seattle',
    NOW() + INTERVAL '4 days', 'SCHEDULED'
);

-- Group D – Matchday 2
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'GER'),
    (SELECT id FROM teams WHERE fifa_code = 'KOR'),
    'GROUP_STAGE', 'Lincoln Financial Field, Philadelphia',
    NOW() + INTERVAL '5 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'IDN'),
    (SELECT id FROM teams WHERE fifa_code = 'JPN'),
    'GROUP_STAGE', 'BMO Field, Toronto',
    NOW() + INTERVAL '5 days', 'SCHEDULED'
);

-- Group E – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'FRA'),
    (SELECT id FROM teams WHERE fifa_code = 'DEN'),
    'GROUP_STAGE', 'Mercedes-Benz Stadium, Atlanta',
    NOW() + INTERVAL '6 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'AUS'),
    (SELECT id FROM teams WHERE fifa_code = 'KSA'),
    'GROUP_STAGE', 'NRG Stadium, Houston',
    NOW() + INTERVAL '6 days', 'SCHEDULED'
);

-- Group F – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'ENG'),
    (SELECT id FROM teams WHERE fifa_code = 'IRN'),
    'GROUP_STAGE', 'Gillette Stadium, Boston',
    NOW() + INTERVAL '7 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'NED'),
    (SELECT id FROM teams WHERE fifa_code = 'WAL'),
    'GROUP_STAGE', 'SoFi Stadium, Los Angeles',
    NOW() + INTERVAL '7 days', 'SCHEDULED'
);

-- Group G – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'ESP'),
    (SELECT id FROM teams WHERE fifa_code = 'URU'),
    'GROUP_STAGE', 'Estadio BBVA, Monterrey',
    NOW() + INTERVAL '8 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'POR'),
    (SELECT id FROM teams WHERE fifa_code = 'MAR'),
    'GROUP_STAGE', 'Estadio Akron, Guadalajara',
    NOW() + INTERVAL '8 days', 'SCHEDULED'
);

-- Group H – Matchday 1
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'ITA'),
    (SELECT id FROM teams WHERE fifa_code = 'TUN'),
    'GROUP_STAGE', 'Arrowhead Stadium, Kansas City',
    NOW() + INTERVAL '9 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'SEN'),
    (SELECT id FROM teams WHERE fifa_code = 'ECU'),
    'GROUP_STAGE', 'Geodis Park, Nashville',
    NOW() + INTERVAL '9 days', 'SCHEDULED'
);

-- Group A – Matchday 3
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'USA'),
    (SELECT id FROM teams WHERE fifa_code = 'CAN'),
    'GROUP_STAGE', 'MetLife Stadium, New Jersey',
    NOW() + INTERVAL '12 days', 'SCHEDULED'
);
INSERT INTO matches (home_team_id, away_team_id, phase, venue, start_time, status)
VALUES (
    (SELECT id FROM teams WHERE fifa_code = 'JAM'),
    (SELECT id FROM teams WHERE fifa_code = 'MEX'),
    'GROUP_STAGE', 'Estadio Azteca, Mexico City',
    NOW() + INTERVAL '12 days', 'SCHEDULED'
);

-- ----------------------------------------------------------
-- 4. PREDICTIONS – for finished matches (scored)
-- ----------------------------------------------------------
-- Helper: Get user IDs
-- Carlos (id via email), María, Pedro, Ana, Luis

-- Match 1: USA 3-0 JAM
-- Carlos: exact (3-0) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'carlos@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'USA' AND a.fifa_code = 'JAM'),
    3, 0, 3, NOW() - INTERVAL '11 days'
);
-- María: tendency (2-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'maria@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'USA' AND a.fifa_code = 'JAM'),
    2, 0, 1, NOW() - INTERVAL '11 days'
);
-- Pedro: wrong (1-2) → 0pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'pedro@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'USA' AND a.fifa_code = 'JAM'),
    1, 2, 0, NOW() - INTERVAL '11 days'
);
-- Ana: tendency (4-1) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'ana@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'USA' AND a.fifa_code = 'JAM'),
    4, 1, 1, NOW() - INTERVAL '11 days'
);
-- Luis: exact (3-0) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'luis@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'USA' AND a.fifa_code = 'JAM'),
    3, 0, 3, NOW() - INTERVAL '11 days'
);

-- Match 2: MEX 2-1 CAN
-- Carlos: tendency (1-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'carlos@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'MEX' AND a.fifa_code = 'CAN'),
    1, 0, 1, NOW() - INTERVAL '11 days'
);
-- María: exact (2-1) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'maria@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'MEX' AND a.fifa_code = 'CAN'),
    2, 1, 3, NOW() - INTERVAL '11 days'
);
-- Pedro: tendency (3-2) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'pedro@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'MEX' AND a.fifa_code = 'CAN'),
    3, 2, 1, NOW() - INTERVAL '11 days'
);

-- Match 3: BRA 4-0 NZL
-- Carlos: tendency (2-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'carlos@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'BRA' AND a.fifa_code = 'NZL'),
    2, 0, 1, NOW() - INTERVAL '10 days'
);
-- María: tendency (3-1) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'maria@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'BRA' AND a.fifa_code = 'NZL'),
    3, 1, 1, NOW() - INTERVAL '10 days'
);
-- Ana: exact (4-0) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'ana@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'BRA' AND a.fifa_code = 'NZL'),
    4, 0, 3, NOW() - INTERVAL '10 days'
);
-- Luis: tendency (5-1) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'luis@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'BRA' AND a.fifa_code = 'NZL'),
    5, 1, 1, NOW() - INTERVAL '10 days'
);

-- Match 4: COL 1-1 PAR
-- Carlos: wrong (2-0) → 0pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'carlos@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'COL' AND a.fifa_code = 'PAR'),
    2, 0, 0, NOW() - INTERVAL '10 days'
);
-- María: exact (1-1) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'maria@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'COL' AND a.fifa_code = 'PAR'),
    1, 1, 3, NOW() - INTERVAL '10 days'
);
-- Pedro: tendency (0-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'pedro@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'COL' AND a.fifa_code = 'PAR'),
    0, 0, 1, NOW() - INTERVAL '10 days'
);
-- Luis: wrong (0-2) → 0pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'luis@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'COL' AND a.fifa_code = 'PAR'),
    0, 2, 0, NOW() - INTERVAL '10 days'
);

-- Match 5: ARG 3-1 BOL
-- Carlos: exact (3-1) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'carlos@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'ARG' AND a.fifa_code = 'BOL'),
    3, 1, 3, NOW() - INTERVAL '9 days'
);
-- María: tendency (2-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'maria@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'ARG' AND a.fifa_code = 'BOL'),
    2, 0, 1, NOW() - INTERVAL '9 days'
);
-- Pedro: exact (3-1) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'pedro@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'ARG' AND a.fifa_code = 'BOL'),
    3, 1, 3, NOW() - INTERVAL '9 days'
);
-- Ana: tendency (1-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'ana@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'ARG' AND a.fifa_code = 'BOL'),
    1, 0, 1, NOW() - INTERVAL '9 days'
);

-- Match 6: PER 0-0 CHI
-- Carlos: tendency (1-1) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'carlos@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'PER' AND a.fifa_code = 'CHI'),
    1, 1, 1, NOW() - INTERVAL '9 days'
);
-- Ana: exact (0-0) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'ana@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'PER' AND a.fifa_code = 'CHI'),
    0, 0, 3, NOW() - INTERVAL '9 days'
);
-- Luis: wrong (2-1) → 0pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'luis@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'PER' AND a.fifa_code = 'CHI'),
    2, 1, 0, NOW() - INTERVAL '9 days'
);

-- Match 7: GER 5-1 IDN
-- Carlos: tendency (3-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'carlos@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'GER' AND a.fifa_code = 'IDN'),
    3, 0, 1, NOW() - INTERVAL '8 days'
);
-- María: tendency (4-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'maria@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'GER' AND a.fifa_code = 'IDN'),
    4, 0, 1, NOW() - INTERVAL '8 days'
);
-- Pedro: tendency (2-0) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'pedro@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'GER' AND a.fifa_code = 'IDN'),
    2, 0, 1, NOW() - INTERVAL '8 days'
);
-- Luis: exact (5-1) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'luis@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'GER' AND a.fifa_code = 'IDN'),
    5, 1, 3, NOW() - INTERVAL '8 days'
);

-- Match 8: JPN 2-2 KOR
-- María: tendency (1-1) → 1pt
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'maria@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'JPN' AND a.fifa_code = 'KOR'),
    1, 1, 1, NOW() - INTERVAL '8 days'
);
-- Pedro: wrong (3-1) → 0pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'pedro@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'JPN' AND a.fifa_code = 'KOR'),
    3, 1, 0, NOW() - INTERVAL '8 days'
);
-- Ana: exact (2-2) → 3pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'ana@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'JPN' AND a.fifa_code = 'KOR'),
    2, 2, 3, NOW() - INTERVAL '8 days'
);
-- Luis: wrong (0-1) → 0pts
INSERT INTO predictions (user_id, match_id, home_score, away_score, points, created_at)
VALUES (
    (SELECT id FROM users WHERE email = 'luis@test.com'),
    (SELECT m.id FROM matches m JOIN teams h ON m.home_team_id = h.id JOIN teams a ON m.away_team_id = a.id WHERE h.fifa_code = 'JPN' AND a.fifa_code = 'KOR'),
    0, 1, 0, NOW() - INTERVAL '8 days'
);

-- ----------------------------------------------------------
-- LEADERBOARD SUMMARY (for reference):
-- Carlos:  3+1+1+0+3+1+1     = 11 pts  (2 exact)
-- María:   1+3+1+3+1+1+1     = 11 pts  (2 exact)
-- Pedro:   0+1+0+1+3+0+1+0   =  6 pts  (1 exact)
-- Ana:     1+0+3+0+1+3+0+3   = 11 pts  (3 exact)  ← top
-- Luis:    3+0+1+0+0+0+3+0   =  7 pts  (2 exact)
-- Admin:   0 pts (no predictions)
-- ----------------------------------------------------------
