@KafkaListener(topics = "chatApp", groupId = "chatAppGroup")
@SendTo("chatApp")
KafkaTemplate<String, String> kafkaTemplate;
kafkaTemplate.send("topic-name",key, message);
->le diference entre pub/sub et observer c est que l observabel sais leur subscribers

event driven architecture has a high deoupling