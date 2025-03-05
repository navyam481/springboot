-- Show topics
SHOW TOPICS;

CREATE STREAM my_stream (
   message STRING,
   author STRING
) WITH (
   KAFKA_TOPIC='topic_kafka',
   VALUE_FORMAT='JSON',
   PARTITIONS=1
);


-- Read data from stream
SELECT * FROM user_stream EMIT CHANGES;
