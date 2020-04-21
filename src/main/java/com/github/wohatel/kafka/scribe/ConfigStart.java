package com.github.wohatel.kafka.scribe;

public class ConfigStart {

    public static final String topic = "heima";
    public static final String kvSerializer = "org.apache.kafka.common.serialization.StringSerializer";
    public static final String kvDeserializer = "org.apache.kafka.common.serialization.StringDeserializer";
    public static final String bootstrap_servers = "bootstrap.servers";
    public static final String group_id = "group.id";
}
