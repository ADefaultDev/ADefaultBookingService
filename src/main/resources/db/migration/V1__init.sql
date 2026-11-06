CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL
);

CREATE TABLE addresses (
    id BIGSERIAL PRIMARY KEY,
    country VARCHAR(100),
    city VARCHAR(100),
    street VARCHAR(255),
    house_number VARCHAR(50)
);

CREATE TABLE bookings (
    id BIGSERIAL PRIMARY KEY,
    room_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    booking_status VARCHAR(50) NOT NULL,

    CONSTRAINT fk_bookings_room
        FOREIGN KEY (room_id) REFERENCES rooms(id),

    CONSTRAINT fk_bookings_user
        FOREIGN KEY (user_id) REFERENCES users(id),

    CONSTRAINT chk_booking_time
        CHECK (end_time > start_time)
);