DROP KEYSPACE IF EXISTS tsgram;

CREATE KEYSPACE tsgram
            WITH replication ={'class': 'SimpleStrategy', 'replication_factor': 1};

USE tsgram;

CREATE TABLE chats
(
    chat_id       UUID,
    name          TEXT,
    owner_user_id UUID,

    PRIMARY KEY ((chat_id))
);

CREATE TABLE chats_by_participant
(
    participant_id UUID,
    chat_id        UUID,

    PRIMARY KEY ((participant_id), chat_id)
);

CREATE TABLE participants_by_chat
(
    chat_id        UUID,
    participant_id UUID,

    PRIMARY KEY ((chat_id), participant_id)
);