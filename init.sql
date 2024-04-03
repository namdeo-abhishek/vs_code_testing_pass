CREATE DATABASE IF NOT EXISTS teamsdb;

use teamsdb;

CREATE TABLE IF NOT EXISTS teams(
    team_id INT AUTO_INCREMENT,
    team_name varchar(255),
    runs INT,
    target_runs INT,
    year INT,
    PRIMARY KEY (team_id)
);

INSERT IGNORE INTO teams (team_name, runs, target_runs, year) VALUES ('RR', 185, 170, 2011);
INSERT IGNORE INTO teams (team_name, runs, target_runs, year) VALUES ('KKR', 120, 130, 2013);
INSERT IGNORE INTO teams (team_name, runs, target_runs, year) VALUES ('RCB', 195, 180, 2013);
