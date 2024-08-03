
CREATE TABLE users (
    user_id serial,
    username varchar(50) NOT NULL UNIQUE,
    passwordHash varchar(50) NOT NULL,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    role varchar(20) NOT NULL,
    email varchar(50),
    user_location varchar(50) NOT NULL,
    isAdvocate boolean NOT NULL,

    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE requests (
    request_id serial,
    request_service int NOT NULL,
    details varchar(100) NOT NULL,
    isCompleted boolean NOT NULL,
    completedBy int,
    request_location varchar(50),

    CONSTRAINT PK_request PRIMARY KEY (request_id)
)